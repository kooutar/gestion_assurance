package DAO.Interfaces;

import enumeration.Contrats;

import java.sql.SQLException;
import java.time.LocalDateTime;

public interface ContratInterface {
    public void getContrat();
    public void ajouterContrat(Contrats typeContrat, LocalDateTime dateDebut, LocalDateTime dateFin) throws SQLException;
    public void supprimerContrat();
    public void modifierContrat();

}
