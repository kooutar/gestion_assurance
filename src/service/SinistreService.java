package service;

import DAO.Classes.SinistreDAO;

import enumeration.Sinistres;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

public class SinistreService {
    private SinistreDAO sinistreDAO ;
    public SinistreService() throws SQLException, ClassNotFoundException {
        sinistreDAO= new SinistreDAO();
    }
    public void ajouterSinistre(LocalDateTime dateTime, Sinistres typeSinistre, double montant, String description, int idContrat, Optional<Integer> idSinistre) throws SQLException, ClassNotFoundException {
        sinistreDAO.ajouterSinistre(dateTime, typeSinistre, montant, description, idContrat,idSinistre);
    }

    public  void supprimerSinistre(int idSinistre) throws SQLException, ClassNotFoundException {
        sinistreDAO.supprimerSinistre(idSinistre);
    }
}
