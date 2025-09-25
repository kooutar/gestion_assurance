package DAO.Interfaces;

import model.person.Conseiller;

import java.sql.SQLException;
import java.util.Optional;

public interface ConseillerInterface {
    public void AjouterConseiller(String nom , String prenom , String mail, Optional<Integer> idConseiller) throws SQLException;
    public void SupprimerConseiller(Conseiller conseiller);
    public void ModifierConseiller(Conseiller conseiller);


}
