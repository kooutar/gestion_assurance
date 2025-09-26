package service;

import DAO.Classes.ConseillerDAO;
import model.person.Conseiller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


public class ConseillerService {
    private ConseillerDAO conseiller;
    public ConseillerService() throws SQLException, ClassNotFoundException {
        conseiller= new ConseillerDAO();
    }

    public void ajouterConseiller(String nom , String prenom, String email, Optional<Integer>idConseiller) throws SQLException {
        conseiller.AjouterConseiller(nom,prenom,email,idConseiller);
    }

    public void supprimerConseiller(int idConseiller) throws SQLException {
        conseiller.supprimerConseiller(idConseiller);
    }

    public void getConseillers() throws SQLException, ClassNotFoundException {
        ArrayList<Conseiller>conseillers= conseiller.getConseiller();
        conseillers.forEach(c -> System.out.println(
                "Nom: " + c.getNom() + ", Prénom: " + c.getPrenom() + ", Email: " + c.getEmail()
        ));
    }

    public Conseiller getConseillerByEmail(String email) throws SQLException, ClassNotFoundException {
        return  conseiller.getConseillerByMail(email);
    }
}
