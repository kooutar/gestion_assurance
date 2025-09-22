package model.person;

import java.util.ArrayList;

public class Conseiller extends Person {
    private ArrayList<Client> clients;
    public Conseiller(String nom, String prenom, String email) {
        super(nom, prenom, email);
        clients = new ArrayList<>();
    }


}
