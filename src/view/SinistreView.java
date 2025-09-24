package view;


import enumeration.Sinistres;
import service.SinistreService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

public class SinistreView {
    private SinistreService sinistreService;
    private Scanner scanner;
    public SinistreView() throws SQLException, ClassNotFoundException {
        sinistreService= new SinistreService();
        scanner = new Scanner(System.in);
    }

    public  void menuPrincipale(){
        System.out.println("Menu principal Sinistre");
        System.out.println("1. ajouter sinistre");
        System.out.println("2. modifier sinistre");
        int choix =scanner.nextInt();
        scanner.nextLine();
        switch(choix){
            case 1:
                creeSinistre();
                break;
            case 2:
                modifierSinistre();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choix);
        }
    }

    private void modifierSinistre() {
        try {
             System.out.println("id de Sinistre modifier");
             Integer idSinistre=scanner.nextInt();
             scanner.nextLine();
            System.out.println("Saiser Type de Sinistre");
            String typeSinistreString= scanner.nextLine();
            String typeSinistreUperCase= typeSinistreString.toUpperCase();
            Sinistres typeSinistre = Sinistres.valueOf(typeSinistreUperCase);
            System.out.println("Saiser date Fin de Sinistre");
            String DateSinistreString = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
            LocalDateTime DateSinistreparse= LocalDateTime.parse(DateSinistreString,formatter);
            System.out.println("Saiser montant de Sinistre");
            double montant=scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Saiser une description");
            String description= scanner.nextLine();
            System.out.println("Saiser id de contrat");
            int idContrat= scanner.nextInt();
//            String typeSinistreString= scanner.nextLine();
            sinistreService.ajouterSinistre(DateSinistreparse,typeSinistre,montant,description,idContrat, Optional.of(idSinistre));
        }catch (IllegalArgumentException e){
            System.out.println("❌ Contrat invalide !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void creeSinistre() {
        try {

            System.out.println("Saiser Type de Sinistre");
            String typeSinistreString= scanner.nextLine();
            String typeSinistreUperCase= typeSinistreString.toUpperCase();
            Sinistres typeSinistre = Sinistres.valueOf(typeSinistreUperCase);
            System.out.println("Saiser date Fin de Sinistre");
            String DateSinistreString = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
            LocalDateTime DateSinistreparse= LocalDateTime.parse(DateSinistreString,formatter);
            System.out.println("Saiser montant de Sinistre");
            double montant=scanner.nextDouble();
            System.out.println("Saiser une description");
            String description= scanner.nextLine();
            System.out.println("Saiser id de contrat");
            int idContrat= scanner.nextInt();
//            String typeSinistreString= scanner.nextLine();
            sinistreService.ajouterSinistre(DateSinistreparse,typeSinistre,montant,description,idContrat,null);
        }catch (IllegalArgumentException e){
            System.out.println("❌ Contrat invalide !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
