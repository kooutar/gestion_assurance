package model.Sinistre;

import enumeration.Sinistres;

import java.time.LocalDateTime;

public class Sinistre {
    private Sinistres typeSinistre;
    private LocalDateTime dateTime;
    private double montant;
    private String description;

    public Sinistre(LocalDateTime dateTime, Sinistres typeSinistre, double montant, String description) {
        this.dateTime = dateTime;
        this.typeSinistre = typeSinistre;
        this.montant = montant;
        this.description = description;
    }

    public void setTypeSinistre(Sinistres typeSinistre) {
        this.typeSinistre = typeSinistre;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sinistres getTypeSinistre() {
        return typeSinistre;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double getMontant() {
        return montant;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
