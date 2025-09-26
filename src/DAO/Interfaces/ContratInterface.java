package DAO.Interfaces;

import enumeration.Contrats;
import model.Contrat.Contrat;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public interface ContratInterface {
    public ArrayList<Contrat> getContrat(int idclient) throws SQLException;
    public void ajouterContrat(Contrats typeContrat, LocalDateTime dateDebut, LocalDateTime dateFin,int idClient,Optional<Integer>idContrat) throws SQLException;
    public void supprimerContrat(int idContrat);
    public void modifierContrat();

}
