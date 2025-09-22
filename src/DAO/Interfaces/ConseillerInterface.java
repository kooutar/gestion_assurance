package DAO.Interfaces;

import model.person.Conseiller;

import java.sql.SQLException;

public interface ConseillerInterface {
    public void AjouterConseiller(String nom , String prenom , String mail) throws SQLException;
    public void SupprimerConseiller(Conseiller conseiller);
    public void ModifierConseiller(Conseiller conseiller);


}
