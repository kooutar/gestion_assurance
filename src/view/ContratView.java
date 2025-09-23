package view;

import enumeration.Contrats;
import service.ContratService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ContratView {
    private ContratService contratService ;
    private Scanner scanner ;
    public ContratView() throws SQLException, ClassNotFoundException {
        contratService = new ContratService();
        scanner = new Scanner(System.in);
    }
    public void menuPrincipale(){
        System.out.println("Menu principal Contrat");
        System.out.println("1. Cree compte client");
        int choix =scanner.nextInt();
        scanner.nextLine();
        switch(choix){
            case 1:
                creeContrat();
                break;
        }
    }

    private void creeContrat() {

        try {
            System.out.println("Saiser TypeContart");
            String typeContratString= scanner.nextLine();
            String typeContratUperCase= typeContratString.toUpperCase();
            Contrats typeContrat = Contrats.valueOf(typeContratUperCase);
            System.out.println("Saiser date Fin de contrat");
            String DateFinContrat = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
            LocalDateTime dateFinparsee= LocalDateTime.parse(DateFinContrat,formatter);
            LocalDateTime dateDebut = LocalDateTime.now();
            contratService.ajouterContrat(typeContrat,dateDebut,dateFinparsee);
        }catch (IllegalArgumentException e){
            System.out.println("❌ Contrat invalide !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
