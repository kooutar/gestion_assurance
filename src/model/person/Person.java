package model.person;

public class Person {
    protected String nom;
    protected String prenom;
    protected String email;

    public Person(String nom, String prenom, String email) {
       this.nom = validerFullName(nom);
       this.prenom = validerFullName(prenom);
       this.email = validerEmail(email);
    }

    private String validerEmail(String email) {
  return "";
    }

    private String validerFullName(String nom) {
        return "";
    }

    private void setEmail(String email) {
        this.email=validerEmail(email);
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

    @Override
    public String toString() {
        return nom+" "+prenom+" "+email;
    }
}
