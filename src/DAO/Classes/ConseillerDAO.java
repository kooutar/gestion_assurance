package DAO.Classes;

import DAO.Interfaces.ConseillerInterface;
import databaseConnection.DataBase;
import model.person.Conseiller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class ConseillerDAO implements ConseillerInterface {
    private Connection connection ;
    private ArrayList<Conseiller> Conseillers;
    public ConseillerDAO() throws ClassNotFoundException, SQLException {
        this.connection=  DataBase.getInstance().getConnection();
        Conseillers= new ArrayList<>();
    }
    @Override
    public void AjouterConseiller(
            String nom,
            String prenom,
            String email,
            Optional<Integer> idConseiller
    ) throws SQLException {
        // ✅ Sécurité : si null
        if (idConseiller == null) {
            idConseiller = Optional.empty();
        }

        String req;
        PreparedStatement ps;

        if (idConseiller.isPresent()) {
            // 👉 UPDATE
            req = "UPDATE Conseiller SET nom=?, prenom=?, email=? WHERE id=?";
            ps = connection.prepareStatement(req);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, email);
            ps.setInt(4, idConseiller.get());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Conseiller mis à jour avec succès !");
            } else {
                System.out.println("⚠️ Aucun conseiller trouvé avec cet id !");
            }
        } else {
            // 👉 INSERT
            req = "INSERT INTO Conseiller(nom, prenom, email) VALUES (?,?,?)";
            ps = connection.prepareStatement(req);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, email);
            ps.executeUpdate();
            System.out.println("✅ Conseiller ajouté avec succès !");
        }
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
