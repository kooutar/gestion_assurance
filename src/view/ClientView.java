package view;

import service.ClientService;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

public class ClientView {
    private Scanner scanner;
    private ClientService clientService;
    public ClientView() throws SQLException, ClassNotFoundException {
        scanner = new Scanner(System.in);
        this.clientService = new ClientService();
    }
     public void menuPrincipale() throws SQLException, ClassNotFoundException {
         System.out.println("Menu principal");
         System.out.println("1. Cree compte client");
         System.out.println("2. modifier compte");
         System.out.println("3. supprimer compte");
         int choix =scanner.nextInt();
         scanner.nextLine();
         switch(choix){
             case 1:
                 creeCompte();
                 break;
             case 2:
                 modifierCompte();
                 break;
              case 3:
                  supprimerCompte();
                  break;
             default:
                 throw new IllegalStateException("Unexpected value: " + choix);
         }
     }

    private void supprimerCompte() throws SQLException {
        System.out.println("saiser id de compte a supprime ");
       int idcompte= scanner.nextInt();
       scanner.nextLine();
       clientService.supprimerClient(idcompte);
    }

    private  void modifierCompte() throws SQLException {
        System.out.println("Saiser idc compte a modifier : ");
        Integer id=scanner.nextInt();
        scanner.nextLine();
         System.out.println("saiser votre nom");
         String nom = scanner.nextLine();
         System.out.println("saiser votre prenom");
         String prenom = scanner.nextLine();
         System.out.println("saiser votre email");
         String email = scanner.nextLine();
         System.out.println("saiser  email de Coneiller");
         String emailConseiller = scanner.nextLine();
         clientService.ajouterClient(nom,prenom,email,emailConseiller, Optional.of(id));
     }

    private void creeCompte() throws SQLException {
        System.out.println("saiser votre nom");
        String nom = scanner.nextLine();
        System.out.println("saiser votre prenom");
        String prenom = scanner.nextLine();
        System.out.println("saiser votre email");
        String email = scanner.nextLine();
        System.out.println("saiser  email de Coneiller");
        String emailConseiller = scanner.nextLine();
        clientService.ajouterClient(nom,prenom,email,emailConseiller,null);
    }
}
