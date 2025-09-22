import databaseConnection.DataBase;
import model.person.Conseiller;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Conseiller conseiller= new Conseiller("kaoutar","laajil","kaoutarlaajil@gmail.com");
        conseiller.AjouterConseiller();
    }
}