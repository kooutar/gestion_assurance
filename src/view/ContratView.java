package view;

import enumeration.Contrats;
import service.ContratService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

public class ContratView {
    private ContratService contratService ;
    private Scanner scanner ;
    public ContratView() throws SQLException, ClassNotFoundException {
        contratService = new ContratService();
        scanner = new Scanner(System.in);
    }
    public void menuPrincipale() throws SQLException {
        System.out.println("Menu principal Contrat");
        System.out.println("1. ajouter Contrat");
        System.out.println("2. modifier Contrat");
        System.out.println("3. Supprimer Contrat");
        System.out.println("4. lister Contrats d'un client");
        int choix =scanner.nextInt();
        scanner.nextLine();

        switch(choix){
            case 1:
                creeContrat();
                break;
            case 2:
                modifierContrat();
                break;
            case 3:
                supprimerContrat();
                break;
            case 4:
                listerContratClient();
                break;


        }
    }

    private void listerContratClient() throws SQLException {
        System.out.println("saiser id client");
        int idClient = scanner.nextInt();
        scanner.nextLine();
        contratService.listerContratClient(idClient);
    }

    private void modifierContrat() {

        try {
            System.out.println("saiser id client");
            int idClient = scanner.nextInt();
            scanner.nextLine();
            System.out.println("saiser id contrat");
            int idContrat = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Saiser TypeContart");
            String typeContratString= scanner.nextLine();
            String typeContratUperCase= typeContratString.toUpperCase();
            Contrats typeContrat = Contrats.valueOf(typeContratUperCase);
            System.out.println("Saiser date Fin de contrat");
            String DateFinContrat = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
            LocalDateTime dateFinparsee= LocalDateTime.parse(DateFinContrat,formatter);
            LocalDateTime dateDebut = LocalDateTime.now();
            contratService.ajouterContrat(typeContrat,dateDebut,dateFinparsee,idClient, Optional.ofNullable(idContrat));
        }catch (IllegalArgumentException e){
            System.out.println("❌ Contrat invalide !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void creeContrat() {

        try {
            System.out.println("saiser id client");
            int idClient = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Saiser TypeContart");
            String typeContratString= scanner.nextLine();
            String typeContratUperCase= typeContratString.toUpperCase();
            Contrats typeContrat = Contrats.valueOf(typeContratUperCase);
            System.out.println("Saiser date Fin de contrat");
            String DateFinContrat = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
            LocalDateTime dateFinparsee= LocalDateTime.parse(DateFinContrat,formatter);
            LocalDateTime dateDebut = LocalDateTime.now();
            contratService.ajouterContrat(typeContrat,dateDebut,dateFinparsee,idClient, Optional.ofNullable(null));
        }catch (IllegalArgumentException e){
            System.out.println("❌ Contrat invalide !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private void supprimerContrat() throws SQLException {
        System.out.println("Saiser idContrat");
        int idContrat = scanner.nextInt();
        scanner.nextLine();
        contratService.supprimerContrat(idContrat);
    }
}
