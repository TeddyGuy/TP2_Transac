package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Client;
import persistence.DaoJPAH2;
import persistence.Dao;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminService {
    Dao<Client> clientDAO = new DaoJPAH2<>();

    public void saveClient(String username, String password) {
        Client clientToSave = Client.builder().username(username).password(password).build();
        clientDAO.save(clientToSave);
    }

    public void saveBook(String title, String author, String genre, int year, String publisher, int pages) {
        //Book bookToSave;
        //bookDAO.save(book);
    }
}
