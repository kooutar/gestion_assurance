package DAO.Classes;

import DAO.Interfaces.ClientInterface;
import DAO.Interfaces.ContratInterface;
import DAO.Interfaces.SinistreInterface;
import databaseConnection.DataBase;
import enumeration.Sinistres;
import model.Sinistre.Sinistre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SinistreDAO implements SinistreInterface {
  private Connection connection;
  public SinistreDAO() throws SQLException, ClassNotFoundException {
        this.connection = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouterSinistre(
            LocalDateTime dateTime,
            Sinistres typeSinistre,
            double montant,
            String description,
            int idContrat,
            Optional<Integer> idSinistre
    ) throws SQLException {
        // ✅ Sécurité : si jamais on passe null à la place d’un Optional
        if (idSinistre == null) {
            idSinistre = Optional.empty();
        }

        String req;
        PreparedStatement statement;

        if (idSinistre.isPresent()) {
            // 👉 UPDATE
            req = "UPDATE Sinistre SET typeSinistre=?, dateSinistre=?, montant=?, description=?, id_contrat=? WHERE id=?";
            statement = connection.prepareStatement(req);
            statement.setString(1, typeSinistre.toString());
            statement.setObject(2, dateTime);
            statement.setDouble(3, montant);
            statement.setString(4, description);
            statement.setInt(5, idContrat);
            statement.setInt(6, idSinistre.get());  // l’id existe ici
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Sinistre mis à jour avec succès !");
            } else {
                System.out.println("⚠️ Aucun sinistre trouvé avec cet id !");
            }
        } else {
            // 👉 INSERT
            req = "INSERT INTO Sinistre(typeSinistre, dateSinistre, montant, description, id_contrat) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(req);
            statement.setString(1, typeSinistre.toString());
            statement.setObject(2, dateTime);
            statement.setDouble(3, montant);
            statement.setString(4, description);
            statement.setInt(5, idContrat);
            statement.executeUpdate();
            System.out.println("✅ Sinistre ajouté avec succès !");
        }
    }



    public Sinistre getSinistreById(int idSinistre) throws SQLException, ClassNotFoundException {
      String req="select * from Sinistre where idSinistre=?";
      PreparedStatement statement = connection.prepareStatement(req);
      statement.setInt(1,idSinistre);
        ResultSet rs=statement.executeQuery();
      while(rs.next()){
          Sinistre sinistre=  new Sinistre((LocalDateTime) rs.getObject("dateSinistre"), (Sinistres) rs.getObject("typeSinistre"),rs.getDouble("montant"),rs.getString("description"));
          return sinistre;
      }
      return null;
    }

    @Override
    public void supprimerSinistre(ClientInterface client) {

    }

    @Override
    public void modifierSinistre(ClientInterface client) {

    }

    @Override
    public List<SinistreInterface> getSinistreContrat(ContratInterface contrat) {
        return Collections.emptyList();
    }
}
