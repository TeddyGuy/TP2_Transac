package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Client;
import persitence.Dao;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminService {
    Dao<Client> clientDAO;
    public void saveClient(String username, String password) {
        Client clientToSave = Client.builder().username(username).password(password).build();
        clientDAO.save(clientToSave);
    }
}
