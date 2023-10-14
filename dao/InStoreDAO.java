package dao;

import model.Client;
import java.util.*;

public class InStoreDAO implements ClientDAO {
    private Map<String, Client> inStoreClients = new HashMap<>();

    @Override
    public void addClient(Client client) {
        inStoreClients.put(client.getName(), client);
    }

    @Override
    public Client getClient(String name) {
        return inStoreClients.get(name);
    }
}
