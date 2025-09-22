package DAO.Interfaces;

import java.util.List;

public interface Sinistre {
    public void ajouterSinistre(ClientInterface client);
    public void supprimerSinistre(ClientInterface client);
    public void modifierSinistre(ClientInterface client);
    public List<Sinistre> getSinistreContrat(Contrat contrat);

}
