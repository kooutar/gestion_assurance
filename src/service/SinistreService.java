package service;

import DAO.Classes.ContratDAO;
import DAO.Classes.SinistreDAO;

import enumeration.Sinistres;
import model.Contrat.Contrat;
import model.Sinistre.Sinistre;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class SinistreService {
    private SinistreDAO sinistreDAO ;
    private ContratDAO contratDAO ;
    public SinistreService() throws SQLException, ClassNotFoundException {
        sinistreDAO= new SinistreDAO();
    }
    public void ajouterSinistre(LocalDateTime dateTime, Sinistres typeSinistre, double montant, String description, int idContrat, Optional<Integer> idSinistre) throws SQLException, ClassNotFoundException {
        sinistreDAO.ajouterSinistre(dateTime, typeSinistre, montant, description, idContrat,idSinistre);
    }

    public  void supprimerSinistre(int idSinistre) throws SQLException, ClassNotFoundException {
        sinistreDAO.supprimerSinistre(idSinistre);
    }

    public double calculerCoutTotalSinistres(int idClient) throws SQLException {
        ArrayList<Contrat> contrats = contratDAO.getContrat(idClient);

        // Stream API : on aplatit tous les sinistres de tous les contrats
        double total = contrats.stream()
                .flatMap(c -> c.getSinistres().stream())  // récupère tous les sinistres
                .mapToDouble(Sinistre::getMontant)           // extrait le coût
                .sum();                                   // somme des coûts

        return total;
    }

}
