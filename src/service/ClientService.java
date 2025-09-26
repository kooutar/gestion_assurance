package service;

import DAO.Classes.ClientDAO;
import DAO.Classes.ConseillerDAO;
import databaseConnection.DataBase;
import model.person.Client;
import model.person.Conseiller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class ClientService {
    private Connection connection;
    private ClientDAO clientDAO;
    private ConseillerDAO conseillerDAO;


    public ClientService() throws SQLException, ClassNotFoundException {
        this.connection = DataBase.getInstance().getConnection();
        this.clientDAO = new ClientDAO();
        this.conseillerDAO = new ConseillerDAO();
    }

    public void ajouterClient(String nom, String prenom, String email, String emailConseiller, Optional<Integer> idClient) throws SQLException {

        Conseiller conseiller = conseillerDAO.getConseillerByMail(emailConseiller);
        if (conseiller == null) {
            System.out.println("Erreur : la conseiller est vide !");
            return;
        }
        clientDAO.ajouterClient(nom, prenom, email, conseiller.getId(), idClient);
    }

    public void supprimerClient(int idClient) throws SQLException {
          clientDAO.supprimerClient(idClient);
    }

    public ArrayList<Client> getClientsConseiller(int idConseiller) throws SQLException {
        return   clientDAO.getClientsConseiller(idConseiller);
    }
}
