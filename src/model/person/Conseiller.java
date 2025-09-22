package model.person;

import DAO.Classes.ConseillerDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Conseiller extends Person {
    private ArrayList<Client> clients;
    private ConseillerDAO conseillerDAO;
    public Conseiller(String nom, String prenom, String email) throws SQLException, ClassNotFoundException {
        super(nom, prenom, email);
        this.conseillerDAO = new ConseillerDAO(); // ⚠️ initialisation obligatoire
    }

    public void AjouterConseiller() throws SQLException {
        conseillerDAO.AjouterConseiller(nom,prenom,email);

    }

}
