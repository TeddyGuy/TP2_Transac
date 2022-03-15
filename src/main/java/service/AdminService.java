package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Client;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminService {
    //Dao<Client> clientDAO;
    public void saveClient(String username, String password) {
        //clientDAO.save(username,password);
    }
}
