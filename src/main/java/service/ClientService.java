package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Client;
import persistence.ClientDaoJPAH2;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientService {
    ClientDaoJPAH2 clientDao;
    Client authenticatedClient;

    public ClientService(ClientDaoJPAH2 clientDao){
        this.clientDao = clientDao;
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
}
