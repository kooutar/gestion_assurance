package DAO.Classes;

import DAO.Interfaces.ClientInterface;
import DAO.Interfaces.Contrat;
import DAO.Interfaces.Sinistre;

import java.util.Collections;
import java.util.List;

public class SinistreDAO implements Sinistre {
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
    public List<Sinistre> getSinistreContrat(Contrat contrat) {
        return Collections.emptyList();
    }
}
