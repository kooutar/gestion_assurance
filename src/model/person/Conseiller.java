package model.person;

import DAO.Classes.ConseillerDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class Conseiller extends Person {
    private ArrayList<Client> clients;
    private ConseillerDAO conseillerDAO;

    public Conseiller(String nom, String prenom, String email, Integer Id) throws SQLException, ClassNotFoundException {
        super(nom, prenom, email, Id);
        this.conseillerDAO = new ConseillerDAO();
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

}
