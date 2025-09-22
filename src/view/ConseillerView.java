package view;

import service.ConseillerService;

import java.sql.SQLException;
import java.util.Scanner;

public class ConseillerView {
     private Scanner scanner;
     private ConseillerService conseillerService;
     public ConseillerView() throws SQLException, ClassNotFoundException {
         scanner = new Scanner(System.in);
         conseillerService = new ConseillerService();
     }
    public void menuPrincipal() throws SQLException {
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
        conseillerService.ajouterConseiller(nom,prenom,email);
    }
}
