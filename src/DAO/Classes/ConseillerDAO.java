package DAO.Classes;

import DAO.Interfaces.ConseillerInterface;
import databaseConnection.DataBase;
import model.person.Conseiller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConseillerDAO implements ConseillerInterface {
    private Connection connection ;
    public ConseillerDAO() throws ClassNotFoundException, SQLException {
        this.connection=  DataBase.getInstance().getConnection();
    }
    @Override
    public void AjouterConseiller(String nom ,String prenom , String email) throws SQLException {
        String req ="insert into Conseiller (nom,prenom,email) values(?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setString(1,nom);
        preparedStatement.setString(2,prenom);
        preparedStatement.setString(3,email);
        preparedStatement.executeUpdate();
    }

    @Override
    public void SupprimerConseiller(Conseiller conseiller) {

    }

    @Override
    public void ModifierConseiller(Conseiller conseiller) {

    }
}
