package service;

import DAO.Classes.ContratDAO;
import enumeration.Contrats;
import model.Contrat.Contrat;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class ContratService {
    private final ContratDAO contratDAO;
    public ContratService() throws SQLException, ClassNotFoundException {
        contratDAO = new ContratDAO();
    }

    public void listerContratClient(int idClient) throws SQLException {
        ArrayList<Contrat> contrats = contratDAO.getContrat(idClient);

        // utilisation Stream API pour afficher
        contrats.stream()
                .sorted(Comparator.comparing(Contrat::getDateDebut)) // exemple : tri par date début
                .forEach(c -> System.out.println(
                        "Contrat ID: " + c.getId() +
                                ", Type: " + c.getTypeContrat() +
                                ", Début: " + c.getDateDebut() +
                                ", Fin: " + c.getDateFin()
                ));
    }


    public void ajouterContrat(Contrats typeContrat, LocalDateTime dateDebut, LocalDateTime dateFin,int idClient, Optional<Integer> idContrat) throws SQLException {
        contratDAO.ajouterContrat(typeContrat,dateDebut,dateFin,idClient,idContrat);

    }

    public  void supprimerContrat(int idContart) throws SQLException {
        contratDAO.supprimerContrat(idContart);
    }
}
