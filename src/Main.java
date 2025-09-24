
import view.ClientView;
import view.ConseillerView;
import view.ContratView;
import view.SinistreView;

import java.sql.SQLException;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Agence d'assurance");
        System.out.println("1 Gestion de Clients");
        System.out.println("2 Gestion de Contrats");
        System.out.println("3 Gestion de Conseillers");
        System.out.println("4 Gestion de Sinistres");
        int choice=sc.nextInt();
        switch (choice){
            case 1:
                ClientView clientView = new ClientView();
                clientView.menuPrincipale();
                break;
            case 2:
                ContratView contratView = new ContratView();
                contratView.menuPrincipale();
            case 3:
                 ConseillerView conseillerView = new ConseillerView();
                 conseillerView.menuPrincipal();
                 break;
            case 4:
                SinistreView sinistreView = new SinistreView();
                sinistreView.menuPrincipale();
                break;
        }


    }
}