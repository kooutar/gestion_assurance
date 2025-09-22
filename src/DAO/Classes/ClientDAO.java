package DAO.Classes;

import DAO.Interfaces.ClientInterface;
import databaseConnection.DataBase;
import model.person.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ClientDAO implements ClientInterface {
     private Connection connection ;
     public ClientDAO() throws SQLException, ClassNotFoundException {
        this.connection =  DataBase.getInstance().getConnection();
     }
    @Override
    public void ajouterClient(String nom,String prenom , String email) throws SQLException {
        String req="insert into Client(nom,prenom,email) Values(?,?,?);";
        PreparedStatement preparedStatement= connection.prepareStatement(req);
        preparedStatement.setString(1,nom);
        preparedStatement.setString(2,prenom);
        preparedStatement.setString(3,email);
        preparedStatement.execute();
    }



    @Override
    public boolean supprimerClient() {
        return false;
    }

    @Override
    public boolean modifierClient() {
        return false;
    }

//    @Override
//    public HashMap<String, Client> getClients() {
//        return null;
//    }
}
