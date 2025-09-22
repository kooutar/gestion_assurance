package DAO.Interfaces;

import model.person.Client;

import java.sql.SQLException;
import java.util.HashMap;

public interface ClientInterface {
    public void ajouterClient(Client client) throws SQLException;
    public boolean supprimerClient();
    public boolean modifierClient();
//    public HashMap<String, ClientInterface> getClients();


}
