package dao;

import model.Client;
import java.util.*;

public class OnlineClientDAO implements ClientDAO {
    private Map<String, Client> onlineClients = new HashMap<>();

    @Override
    public void addClient(Client client) {
        onlineClients.put(client.getName(), client);
    }

    @Override
    public Client getClient(String name) {
        return onlineClients.get(name);
    }
}
