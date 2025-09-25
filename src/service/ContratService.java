package service;

import DAO.Classes.ContratDAO;
import enumeration.Contrats;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

public class ContratService {
    private final ContratDAO contratDAO;
    public ContratService() throws SQLException, ClassNotFoundException {
        contratDAO = new ContratDAO();
    }
    public void ajouterContrat(Contrats typeContrat, LocalDateTime dateDebut, LocalDateTime dateFin, Optional<Integer> idContrat) throws SQLException {
        contratDAO.ajouterContrat(typeContrat,dateDebut,dateFin,idContrat);

    }

    public  void supprimerContrat(int idContart) throws SQLException {
        contratDAO.supprimerContrat(idContart);
    }
}
