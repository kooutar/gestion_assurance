package service;

import DAO.Classes.ConseillerDAO;
import model.person.Conseiller;

import java.sql.SQLException;
import java.util.ArrayList;


public class ConseillerService {
    private ConseillerDAO conseiller;
    public ConseillerService() throws SQLException, ClassNotFoundException {
        conseiller= new ConseillerDAO();
    }

    public void ajouterConseiller(String nom ,String prenom,String email) throws SQLException {
        conseiller.AjouterConseiller(nom,prenom,email);
    }

    public ArrayList getConseillers() throws SQLException, ClassNotFoundException {
        return conseiller.getConseiller();
    }

    public Conseiller getConseillerByEmail(String email) throws SQLException, ClassNotFoundException {
        return  conseiller.getConseillerByMail(email);
    }
}
