package DAO.Interfaces;

import model.person.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public interface ClientInterface {
    public void ajouterClient(String nom , String prenom , String email, int id_conseiller, Optional<Integer> idClient) throws SQLException;
    public void supprimerClient(int idClient);
    public boolean modifierClient();

    ArrayList<Client> getAllClient() throws SQLException;
//    public HashMap<String, ClientInterface> getClients();


}
