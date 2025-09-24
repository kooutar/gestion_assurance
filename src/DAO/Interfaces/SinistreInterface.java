package DAO.Interfaces;

import enumeration.Sinistres;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SinistreInterface {
    public void ajouterSinistre(LocalDateTime dateTime, Sinistres typeSinistre, double montant, String description, int idContrat, Optional<Integer> idSinistre) throws SQLException;
    public void supprimerSinistre(ClientInterface client);
    public void modifierSinistre(ClientInterface client);
    public List<SinistreInterface> getSinistreContrat(ContratInterface contrat);

}
