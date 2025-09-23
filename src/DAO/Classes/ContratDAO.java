package DAO.Classes;

import DAO.Interfaces.ContratInterface;
import databaseConnection.DataBase;
import enumeration.Contrats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;

public class ContratDAO implements ContratInterface {
    private Connection connection;


    public  ContratDAO() throws SQLException, ClassNotFoundException {
      connection= DataBase.getInstance().getConnection();
    }

    @Override
    public void getContrat() {

    }

    @Override
    public void ajouterContrat(Contrats typeContrat, LocalDateTime dateDebut, LocalDateTime dateFin) throws SQLException {
        String typeContratString=typeContrat.toString();
        String req ="insert into Contrat(typeContrat, dateDebut, dateFin) values(?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        try {

            preparedStatement.setObject(1, typeContratString);
            preparedStatement.setObject(2, dateDebut);
            preparedStatement.setObject(3, dateFin);
            preparedStatement.executeUpdate();
            System.out.println("Ajout Contrat done");
        }catch(SQLException e){
            System.out.println(e.getStackTrace());
            System.out.println("erreur Ajout Contrat");
        }
    }



    @Override
    public void supprimerContrat() {

    }

    @Override
    public void modifierContrat() {

    }
}
