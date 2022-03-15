import service.AdminService;

public class Main {
    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        adminService.saveClient("John Doe", "Passw0rd123");
        //adminService.saveDocument("Le Torrent","Anne Hébert","Tragédie",1950,"Bibliothèque Québecoise",164);
        //List<Document> documentResults = adminService.findDocument("torrent","Anne Hébert","Tragédie",1950);
        //System.out.println(documentResults);
        //ClientService clientService = new ClientService("John Doe", "Passw0rd123");
        //clientService.borrowDocumentById(results.get(0));
        //List<DocumentLoan> documentLoanResults = clientService.findAllDocumentLoan();
        //System.out.println(documentLoanResults);
    }
}
