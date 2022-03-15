package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Client;
import model.Documents.Book;
import model.Documents.Document;
import persistence.ClientDaoJPAH2;
import persistence.DaoJPAH2;
import persistence.Dao;
import persistence.DocumentDaoJPAH2;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminService {
    ClientDaoJPAH2 clientDAO;
    DocumentDaoJPAH2 documentDAO;

    public void saveClient(String username, String password) {
        Client clientToSave = new Client();
        clientToSave.setUsername(username);
        clientToSave.setPassword(password);
        clientDAO.save(clientToSave);
    }

    public void saveBook(String title, String author, String genre, int year, String publisher, int pages) {
        Book bookToSave = new Book();
        bookToSave.setTitle(title);
        bookToSave.setAuthor(author);
        bookToSave.setGenre(genre);
        bookToSave.setPublicationYear(year);
        bookToSave.setPublisher(publisher);
        bookToSave.setPages(pages);
        documentDAO.save(bookToSave);
    }

    public List<Document> findDocuments(String titleSearch, String authorSearch, String genreSearch, int year) {
        return documentDAO.find(titleSearch, authorSearch, genreSearch, year);
    }
}
