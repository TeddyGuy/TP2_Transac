package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Client;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientService {
    Client authenticatedClient;

    public void login(String username, String password) {
    }
}
