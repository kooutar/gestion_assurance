package service;

import DAO.Classes.ClientDAO;
import databaseConnection.DataBase;

import java.sql.Connection;
import java.sql.SQLException;

public class ClientService {
    private Connection connection;
    private ClientDAO clientDAO;

    public ClientService() throws SQLException, ClassNotFoundException {
        this.connection = DataBase.getInstance().getConnection();
        this.clientDAO = new ClientDAO();
    }
    public void ajouterClient(String nom,String prenom , String email) throws SQLException
    {
        clientDAO.ajouterClient(nom,prenom,email);
    }
}
