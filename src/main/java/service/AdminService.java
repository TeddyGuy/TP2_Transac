package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Client;
import model.Documents.Book;
import persistence.DaoJPAH2;
import persistence.Dao;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminService {
    Dao<Client> clientDAO = new DaoJPAH2<>();

    public void saveClient(String username, String password) {
        Client clientToSave = new Client();
        clientToSave.setUsername(username);
        clientToSave.setPassword(password);
        clientDAO.save(clientToSave);
    }

    public void saveBook(String title, String author, String genre, int year, String publisher, int pages) {
        //Book book;
        //bookDAO.save(book);
    }
}
