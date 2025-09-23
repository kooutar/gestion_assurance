package model.Contrat;

import enumeration.Contrats;
import model.Sinistre.Sinistre;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Contrat {
    private Contrats typeContrat;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private ArrayList<Sinistre> sinistres;
    private Integer idContrat;
    public Contrat(Contrats typeContrat, LocalDateTime dateDebut, LocalDateTime dateFin,Integer idContrat) {
        this.typeContrat = typeContrat;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idContrat = idContrat;
    }

}
