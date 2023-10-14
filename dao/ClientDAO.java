package dao;

import model.Client;

public interface ClientDAO {
    void addClient(Client client);
    Client getClient(String name);
    // Add other methods as needed, like updateClient, deleteClient, etc.
}
