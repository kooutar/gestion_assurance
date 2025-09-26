package view;

import model.person.Client;
import service.ClientService;
import service.ConseillerService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class ConseillerView {
    private Scanner scanner;
    private ConseillerService conseillerService;
    private ClientService clientService;

    public ConseillerView() throws SQLException, ClassNotFoundException {
        scanner = new Scanner(System.in);
        conseillerService = new ConseillerService();
        clientService = new ClientService();
    }

    public void menuPrincipal() throws SQLException, ClassNotFoundException {
        System.out.println("Menu principal");
        System.out.println("1. Cree compte Conseiller");
        System.out.println("2. Modifier compte Conseiller");
        System.out.println("3. Supprimer compte Conseiller");
        System.out.println("4. affiche tous les clients d'un Conseiller");
        System.out.println("5. Afficher les conseillers");
        int choix = scanner.nextInt();
        scanner.nextLine();
        switch (choix) {
            case 1:
                creeCompte();
                break;
            case 2:
                modifierCompte();
                break;
            case 3:
                supprimerCompte();
                break;
            case 4:
                afficheClientConseiller();
                break;
            case 5:
                afficheAllConseillers();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choix);

        }

    }

    private void afficheAllConseillers() throws SQLException, ClassNotFoundException {
        conseillerService.getConseillers();

    }

    private void afficheClientConseiller() throws SQLException {
        ArrayList<Client> arrayClient = new ArrayList<>();
        System.out.println("saiser id de conseiller ");
        int idConseiller = scanner.nextInt();
        scanner.nextLine();
        arrayClient = clientService.getClientsConseiller(idConseiller);
        arrayClient.stream().forEach(System.out::println);

    }

    private void supprimerCompte() throws SQLException {
        System.out.println("saiser id de Compte ");
        int idCompte = scanner.nextInt();
        scanner.nextLine();
        conseillerService.supprimerConseiller(idCompte);
    }

    private void modifierCompte() throws SQLException {
        System.out.println("saiser id de Compte ");
        int idCompte = scanner.nextInt();
        scanner.nextLine();
        System.out.println("saiser votre nom");
        String nom = scanner.nextLine();
        System.out.println("saiser votre prenom");
        String prenom = scanner.nextLine();
        System.out.println("saiser votre email");
        String email = scanner.nextLine();
        conseillerService.ajouterConseiller(nom, prenom, email, Optional.of(idCompte));
    }

    private void creeCompte() throws SQLException {
        System.out.println("saiser votre nom");
        String nom = scanner.nextLine();
        System.out.println("saiser votre prenom");
        String prenom = scanner.nextLine();
        System.out.println("saiser votre email");
        String email = scanner.nextLine();
        conseillerService.ajouterConseiller(nom, prenom, email, null);
    }
}
