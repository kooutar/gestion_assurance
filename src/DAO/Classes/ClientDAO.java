package DAO.Classes;

import DAO.Interfaces.ClientInterface;
import databaseConnection.DataBase;
import model.person.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


public class ClientDAO implements ClientInterface {
     private Connection connection ;
     public ClientDAO() throws SQLException, ClassNotFoundException {
        this.connection =  DataBase.getInstance().getConnection();
     }

    @Override
    public void ajouterClient(
            String nom,
            String prenom,
            String email,
            int idConseiller,
            Optional<Integer> idClient
    ) throws SQLException {
        // ✅ Sécurité : si jamais idClient est passé en null
        if (idClient == null) {
            idClient = Optional.empty();
        }

        String req;
        PreparedStatement ps;

        if (idClient.isPresent()) {
            // 👉 UPDATE
            req = "UPDATE Client SET nom=?, prenom=?, email=?, id_conseiller=? WHERE id=?";
            ps = connection.prepareStatement(req);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, email);
            ps.setInt(4, idConseiller);
            ps.setInt(5, idClient.get());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Client mis à jour avec succès !");
            } else {
                System.out.println("⚠️ Aucun client trouvé avec cet id !");
            }
        } else {
            // 👉 INSERT
            req = "INSERT INTO Client(nom, prenom, email, id_conseiller) VALUES (?,?,?,?)";
            ps = connection.prepareStatement(req);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, email);
            ps.setInt(4, idConseiller);
            ps.executeUpdate();
            System.out.println("✅ Client ajouté avec succès !");
        }
    }




    @Override
    public void supprimerClient(int idClient) {
        String req = "DELETE FROM Client WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(req)) {
            ps.setInt(1, idClient);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Client supprimé avec succès !");
            } else {
                System.out.println("⚠️ Aucun client trouvé avec cet id !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Erreur lors de la suppression du client");
        }
    }

    @Override
    public boolean modifierClient() {
        return false;
    }

    @Override
    public ArrayList<Client> getAllClient() throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        String req = "SELECT * FROM Client ";
        PreparedStatement ps=connection.prepareStatement(req);
        ResultSet rs=ps.executeQuery();
        while (rs.next()) {
            int id=rs.getInt("id");
            String nom=rs.getString("nom");
            String prenom=rs.getString("prenom");
            String email=rs.getString("email");
            clients.add(new Client(nom,prenom,email,id));
        }
        return   clients;
    }

    public ArrayList<Client> getClientsConseiller(int idConseiller) throws SQLException {
         ArrayList<Client> clients = new ArrayList<>();
          String req = "SELECT * FROM Client WHERE id_conseiller = ?";
          PreparedStatement ps=connection.prepareStatement(req);
          ps.setInt(1, idConseiller);
          ResultSet rs=ps.executeQuery();
          while (rs.next()) {
              int id=rs.getInt("id");
              String nom=rs.getString("nom");
              String prenom=rs.getString("prenom");
              String email=rs.getString("email");
              clients.add(new Client(nom,prenom,email,id));
          }
         return   clients;
    }

    public ArrayList<Client> ChercherClientParSonNom(String nomClient) throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        String req = "SELECT * FROM Client where nom = ?";
        PreparedStatement ps=connection.prepareStatement(req);
        ps.setString(1, nomClient);
        ResultSet rs=ps.executeQuery();
        while (rs.next()) {
            int id=rs.getInt("id");
            String nom=rs.getString("nom");
            String prenom=rs.getString("prenom");
            String email=rs.getString("email");
            clients.add(new Client(nom,prenom,email,id));
        }
        return   clients;
    }

//    @Override
//    public HashMap<String, Client> getClients() {
//        return null;
//    }
}
