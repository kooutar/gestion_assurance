package DAO.Interfaces;

import java.util.HashMap;

public interface Client {
    public void ajouterClient();
    public boolean supprimerClient();
    public boolean modifierClient();
    public HashMap<String,Client> getClients();

}
