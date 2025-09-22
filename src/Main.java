import databaseConnection.DataBase;
import model.person.Conseiller;
import view.ClientView;
import view.ConseillerView;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        ConseillerView  conseillerView = new ConseillerView();
//         conseillerView.menuPrincipal();
        ClientView clientView = new ClientView();
        clientView.menuPrincipale();
    }
}