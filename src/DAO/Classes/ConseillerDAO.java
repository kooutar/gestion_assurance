package DAO.Classes;

import DAO.Interfaces.ConseillerInterface;
import databaseConnection.DataBase;
import model.person.Conseiller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConseillerDAO implements ConseillerInterface {
    private Connection connection ;
    private ArrayList<Conseiller> Conseillers;
    public ConseillerDAO() throws ClassNotFoundException, SQLException {
        this.connection=  DataBase.getInstance().getConnection();
        Conseillers= new ArrayList<>();
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

    public  Conseiller getConseillerByMail(String mail) throws SQLException {
        String req ="select * from Conseiller where email = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(req)) {
            preparedStatement.setString(1,mail);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Conseiller conseiller =new Conseiller(resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("email"),resultSet.getInt("id"));
                return conseiller;
            }

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public ArrayList<Conseiller> getConseiller() throws SQLException, ClassNotFoundException {
        String req ="select * from Conseiller";
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
             Conseiller conseiller= new Conseiller(resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("email"),resultSet.getInt("id"));
             Conseillers.add(conseiller);
        }
        if(Conseillers.isEmpty()){
            return  null;
        }
        return Conseillers;
    }
}
