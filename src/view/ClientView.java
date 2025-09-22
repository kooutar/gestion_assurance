package view;

import service.ClientService;

import java.sql.SQLException;
import java.util.Scanner;

public class ClientView {
    private Scanner scanner;
    private ClientService clientService;
    public ClientView() throws SQLException, ClassNotFoundException {
        scanner = new Scanner(System.in);
        this.clientService = new ClientService();
    }
     public void menuPrincipale() throws SQLException {
         System.out.println("Menu principal");
         System.out.println("1. Cree compte Conseiller");
         int choix =scanner.nextInt();
         scanner.nextLine();
         switch(choix){
             case 1:
                 creeCompte();
                 break;
         }
     }

    private void creeCompte() throws SQLException {
        System.out.println("saiser votre nom");
        String nom = scanner.nextLine();
        System.out.println("saiser votre prenom");
        String prenom = scanner.nextLine();
        System.out.println("saiser votre email");
        String email = scanner.nextLine();
        clientService.ajouterClient(nom,prenom,email);
    }
}
