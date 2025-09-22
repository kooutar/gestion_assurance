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
    public void ajouterClient(Client client) throws SQLException {
        String req="insert into client('nom','prenom','email') Values(?,?,?);";
        PreparedStatement preparedStatement= connection.prepareStatement(req);
        preparedStatement.setString(1,client.getNom());
        preparedStatement.setString(2,client.getPrenom());
        preparedStatement.setString(3,client.getEmail());
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
