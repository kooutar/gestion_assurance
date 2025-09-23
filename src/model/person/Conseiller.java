package model.person;

import DAO.Classes.ConseillerDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Conseiller extends Person {
    private ArrayList<Client> clients;
    private ConseillerDAO conseillerDAO;

    public Conseiller(String nom, String prenom, String email, Integer Id) throws SQLException, ClassNotFoundException {
        super(nom, prenom, email, Id);
        this.conseillerDAO = new ConseillerDAO();
    }

    public void AjouterConseiller() throws SQLException {
        conseillerDAO.AjouterConseiller(nom,prenom,email);

    }

}
