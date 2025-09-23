package DAO.Classes;

import DAO.Interfaces.ClientInterface;
import DAO.Interfaces.ContratInterface;
import DAO.Interfaces.SinistreInterface;

import java.util.Collections;
import java.util.List;

public class SinistreDAO implements SinistreInterface {
    @Override
    public void ajouterSinistre(ClientInterface client) {

    }

    @Override
    public void supprimerSinistre(ClientInterface client) {

    }

    @Override
    public void modifierSinistre(ClientInterface client) {

    }

    @Override
    public List<SinistreInterface> getSinistreContrat(ContratInterface contrat) {
        return Collections.emptyList();
    }
}
