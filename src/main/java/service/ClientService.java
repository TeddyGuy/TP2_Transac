package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Client;
import persistence.ClientDaoJPAH2;
import persistence.Dao;
import persistence.DaoJPAH2;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientService {
    ClientDaoJPAH2 clientDao = new ClientDaoJPAH2();
    Client authenticatedClient;
    public void login(String username, String password) {
        Client clientToLogin = new Client();
        clientToLogin.setUsername(username);
        clientToLogin.setPassword(password);
        Optional<Client> clientInDatabase = clientDao.find(clientToLogin);
        //clientInDatabase.ifPresent(client -> authenticatedClient = client);
    }
}
