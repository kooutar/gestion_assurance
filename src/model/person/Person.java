package model.person;

import java.util.regex.Pattern;

public abstract class Person {
    protected String nom;
    protected String prenom;
    protected String email;
    protected Integer Id;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public Person(String nom, String prenom, String email) {
       this.nom = nom;
       this.prenom =prenom;
       validerEmail(email);
    }

    public Person(String nom, String prenom, String email, Integer Id) {
        this.nom = nom;
        this.prenom =prenom;
        this.Id = Id;
        validerEmail(email);
    }

    private void validerEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            System.out.println("❌ L'email ne peut pas être vide.");
            return;
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            System.out.println("❌ Format d'email invalide.");
            return;
        }
       this.email = email;
    }

    private String validerFullName(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            return "❌ Le nom complet ne peut pas être vide.";
        }
        // Supprimer les espaces en trop
        nom = nom.trim();

        // Vérifie si contient des chiffres
        if (nom.matches(".*\\d.*")) {
            return "❌ Le nom complet ne doit pas contenir de chiffres.";
        }

        // Vérifie si au moins prénom + nom
        if (!nom.contains(" ")) {
            return "❌ Le nom complet doit contenir au moins un prénom et un nom.";
        }

        return nom;
    }

    private void setEmail(String email) {
        validerEmail(email);
    }

    private void setPrenom(String prenom) {
        this.prenom=validerFullName(prenom);
    }

    private void setNom(String nom) {
       this.nom=validerFullName(nom);
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Integer getId() {
        return Id;
    }

    @Override
    public String toString() {
        return nom+" "+prenom+" "+email;
    }
}
