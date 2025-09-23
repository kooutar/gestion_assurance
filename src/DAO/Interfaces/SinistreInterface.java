package DAO.Interfaces;

import java.util.List;

public interface SinistreInterface {
    public void ajouterSinistre(ClientInterface client);
    public void supprimerSinistre(ClientInterface client);
    public void modifierSinistre(ClientInterface client);
    public List<SinistreInterface> getSinistreContrat(ContratInterface contrat);

}
