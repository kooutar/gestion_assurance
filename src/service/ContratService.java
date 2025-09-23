package service;

import DAO.Classes.ContratDAO;
import enumeration.Contrats;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class ContratService {
    private final ContratDAO contratDAO;
    public ContratService() throws SQLException, ClassNotFoundException {
        contratDAO = new ContratDAO();
    }
    public void ajouterContrat(Contrats typeContrat, LocalDateTime dateDebut, LocalDateTime dateFin) throws SQLException {
        contratDAO.ajouterContrat(typeContrat,dateDebut,dateFin);

    }
}
