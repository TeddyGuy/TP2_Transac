package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Client;
import model.Documents.Document;
import persistence.ClientDaoJPAH2;
import persistence.DocumentDaoJPAH2;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientService {
    ClientDaoJPAH2 clientDao;
    DocumentDaoJPAH2 documentDaoJPAH2;
    Client authenticatedClient;

    public ClientService(ClientDaoJPAH2 clientDao, DocumentDaoJPAH2 documentDaoJPAH2){
        this.clientDao = clientDao;
        this.documentDaoJPAH2 = documentDaoJPAH2;
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

    }
}
