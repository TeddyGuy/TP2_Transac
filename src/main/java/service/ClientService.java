package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Client;
import model.DocumentLoan;
import model.Documents.Book;
import model.Documents.Document;
import persistence.ClientDaoJPAH2;
import persistence.DocumentDaoJPAH2;
import persistence.DocumentLoanDaoJPAH2;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientService {
    ClientDaoJPAH2 clientDao;
    DocumentDaoJPAH2 documentDao;
    DocumentLoanDaoJPAH2 documentLoanDao;
    Client authenticatedClient;

    public ClientService(ClientDaoJPAH2 clientDao, DocumentDaoJPAH2 documentDao, DocumentLoanDaoJPAH2 documentLoanDao){
        this.clientDao = clientDao;
        this.documentDao = documentDao;
        this.documentLoanDao = documentLoanDao;
    }

    public void login(String username, String password) {
        Client clientToLogin = new Client();
        clientToLogin.setUsername(username);
        clientToLogin.setPassword(password);
        Optional<Client> clientInDatabase = clientDao.find(clientToLogin);
        if(clientInDatabase.isPresent()){
            authenticatedClient = clientInDatabase.get();
        }else{
            throw new RuntimeException("login faild for user : " + username);
        }
    }

    public void borrowDocumentById(int i) {
        Document documentToBorrow = documentDao.findById(i);

        if(documentToBorrow.getCopies() == 0){
            throw new RuntimeException("Insufficient Amount of copies for document : " + documentToBorrow.getId());
        }

        documentToBorrow.setCopies(documentToBorrow.getCopies() - 1);

        LocalDate expectedReturnDate = LocalDate.now();

        if(documentToBorrow instanceof Book){
            expectedReturnDate = expectedReturnDate.plusWeeks(Book.BORROW_TIME_IN_WEEKS);
        }

        DocumentLoan documentLoan = DocumentLoan.builder().document(documentToBorrow).lendingDate(LocalDate.now()).expectedReturnDate(expectedReturnDate).client(authenticatedClient).build();
        authenticatedClient.getDocumentLoans().add(documentLoan);

        documentLoanDao.save(documentLoan);
        clientDao.update(authenticatedClient);
        documentDao.update(documentToBorrow);
    }

    public List<DocumentLoan> findAllDocumentLoans() {
        return documentLoanDao.getByClientId(authenticatedClient.getId());
    }
}
