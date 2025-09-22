package service;

import DAO.Classes.ConseillerDAO;
import model.person.Conseiller;

import java.sql.SQLException;


public class ConseillerService {
    private ConseillerDAO conseiller;
    public ConseillerService() throws SQLException, ClassNotFoundException {
        conseiller= new ConseillerDAO();
    }

    public void ajouterConseiller(String nom ,String prenom,String email) throws SQLException {
        conseiller.AjouterConseiller(nom,prenom,email);
    }
}
