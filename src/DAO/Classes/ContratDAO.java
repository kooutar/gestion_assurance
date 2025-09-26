package DAO.Classes;

import DAO.Interfaces.ContratInterface;
import databaseConnection.DataBase;
import enumeration.Contrats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

public class ContratDAO implements ContratInterface {
    private Connection connection;


    public  ContratDAO() throws SQLException, ClassNotFoundException {
      connection= DataBase.getInstance().getConnection();
    }

    @Override
    public void getContrat() {

    }

    @Override
    public void ajouterContrat(
            Contrats typeContrat,
            LocalDateTime dateDebut,
            LocalDateTime dateFin,
            int idClient,
            Optional<Integer> idContrat
    ) throws SQLException {
        // ✅ Sécurité : éviter un Optional null
        if (idContrat == null) {
            idContrat = Optional.empty();
        }

        String req;
        PreparedStatement ps;

        try {
            if (idContrat.isPresent()) {
                // 👉 UPDATE
                req = "UPDATE Contrat SET typeContrat=?, dateDebut=?, dateFin=?, idClient=? WHERE id=?";
                ps = connection.prepareStatement(req);
                ps.setString(1, typeContrat.toString());
                ps.setObject(2, dateDebut);
                ps.setObject(3, dateFin);
                ps.setInt(4, idClient);
                ps.setInt(5, idContrat.get());

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("✅ Contrat mis à jour avec succès !");
                } else {
                    System.out.println("⚠️ Aucun contrat trouvé avec cet id !");
                }
            } else {
                // 👉 INSERT
                req = "INSERT INTO Contrat(typeContrat, dateDebut, dateFin,idClient) VALUES (?,?,?,?)";
                ps = connection.prepareStatement(req);
                ps.setString(1, typeContrat.toString());
                ps.setObject(2, dateDebut);
                ps.setObject(3, dateFin);
                ps.setInt(4, idClient);
                ps.executeUpdate();
                System.out.println("✅ Contrat ajouté avec succès !");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // ⚠️ affichage clair de l'erreur
            System.out.println("❌ Erreur lors de l'ajout/mise à jour du contrat");
        }
    }


    @Override
    public void supprimerContrat(int idContrat) {
        String req = "DELETE FROM Contrat WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(req)) {
            ps.setInt(1, idContrat);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Contrat supprimé avec succès !");
            } else {
                System.out.println("⚠️ Aucun contrat trouvé avec cet id !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Erreur lors de la suppression du contrat");
        }
    }


    @Override
    public void modifierContrat() {

    }
}
