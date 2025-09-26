package model.Contrat;

import enumeration.Contrats;
import model.Sinistre.Sinistre;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

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
        sinistres=new ArrayList<>();
    }


    public Contrats getTypeContrat() {
        return typeContrat;
    }


    public void setTypeContrat(Contrats typeContrat) {
        this.typeContrat = typeContrat;
    }

    public Integer getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(Integer idContrat) {
        this.idContrat = idContrat;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getId() {
        return idContrat.toString();
    }

    public ArrayList<Sinistre> getSinistres() {
       return this.sinistres;
    }

    public void setSinistres(Sinistre sinistre) {
        sinistres.add(sinistre);
    }

}
