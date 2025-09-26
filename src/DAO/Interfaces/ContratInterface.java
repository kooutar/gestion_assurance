package DAO.Interfaces;

import enumeration.Contrats;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

public interface ContratInterface {
    public void getContrat();
    public void ajouterContrat(Contrats typeContrat, LocalDateTime dateDebut, LocalDateTime dateFin,int idClient,Optional<Integer>idContrat) throws SQLException;
    public void supprimerContrat(int idContrat);
    public void modifierContrat();

}
