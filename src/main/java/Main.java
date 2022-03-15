import model.Documents.Document;
import persistence.DaoJPAH2;
import service.AdminService;
import service.ClientService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        adminService.saveClient("John Doe", "Passw0rd123");
        adminService.saveBook("Le Torrent","Anne Hébert","Tragédie",1950,"Bibliothèque Québecoise",164);
        List<Document> documentResults = adminService.findDocuments("torrent","Anne Hébert","Tragédie",1950);
        System.out.println(documentResults);
        ClientService clientService = new ClientService();
        clientService.login("John Doe","Passw0rd123");
        //clientService.borrowDocumentById();
        //List<DocumentLoan> documentLoanResults = clientService.findAllDocumentLoan();
        //System.out.println(documentLoanResults);
    }
}
