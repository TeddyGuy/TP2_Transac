package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Client;
import model.DocumentLoan;
import model.Documents.Book;
import model.Documents.Document;
import persistence.ClientDaoJPAH2;
import persistence.Dao;
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
    DocumentDaoJPAH2 documentDaoJPAH2;
    DocumentLoanDaoJPAH2 documentLoanDao;
    Client authenticatedClient;

    public ClientService(ClientDaoJPAH2 clientDao, DocumentDaoJPAH2 documentDaoJPAH2, DocumentLoanDaoJPAH2 documentLoanDao){
        this.clientDao = clientDao;
        this.documentDaoJPAH2 = documentDaoJPAH2;
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
        Document documentToBorrow = documentDaoJPAH2.findById(i);
        LocalDate expectedReturnDate = LocalDate.now();

        if(documentToBorrow instanceof Book){
            expectedReturnDate.plusWeeks(Book.BORROW_TIME_IN_WEEKS);
        }

        DocumentLoan documentLoan = DocumentLoan.builder().document(documentToBorrow).lendingDate(LocalDate.now()).expectedReturnDate(expectedReturnDate).client(authenticatedClient).build();
        authenticatedClient.getDocumentLoans().add(documentLoan);

        documentLoanDao.save(documentLoan);
        clientDao.update(authenticatedClient);
    }

    public List<DocumentLoan> findAllDocumentLoan() {
        //return documentLoanDao.getByClientId(authenticatedClient.getId());
    }
}
