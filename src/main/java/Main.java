import model.DocumentLoan;
import model.Documents.Document;
import persistence.*;
import service.AdminService;
import service.ClientService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientDaoJPAH2 clientDaoJPAH2 = new ClientDaoJPAH2();
        DocumentDaoJPAH2 documentDaoJPAH2 = new DocumentDaoJPAH2();
        DocumentLoanDaoJPAH2 documentLoanDao = new DocumentLoanDaoJPAH2();
        AdminService adminService = new AdminService(clientDaoJPAH2,documentDaoJPAH2,documentDaoJPAH2);
        adminService.saveClient("JohnDoe", "password");
        adminService.saveBook("Le Torrent","Anne Hébert","Tragédie",1950,"Bibliothèque Québecoise",164);
        List<Document> documentResults = adminService.findDocuments("torrent","Anne Hébert","Tragédie",1950);
        System.out.println(documentResults);
        ClientService clientService = new ClientService(clientDaoJPAH2, documentDaoJPAH2, documentLoanDao);
        clientService.login("JohnDoe","password");
        clientService.borrowDocumentById(1);
        adminService.addCopiesToDocument(4,1);
        List<DocumentLoan> documentLoanResults = clientService.findAllDocumentLoans();
        System.out.println(documentLoanResults);

        for ( DocumentLoan dl : documentLoanResults) {
            System.out.println(dl.getClient().getUsername());
            System.out.println(dl.getDocument().getTitle());
            System.out.println(dl.getDocument().getCopies());
        }
    }
}
