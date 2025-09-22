package DAO.Interfaces;

import java.util.HashMap;
import java.util.List;

public interface Sinistre {
    public void ajouterSinistre(Client client);
    public void supprimerSinistre(Client client);
    public void modifierSinistre(Client client);
    public List<Sinistre> getSinistreContrat(Contrat contrat);

}
