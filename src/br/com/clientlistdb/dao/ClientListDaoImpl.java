package br.com.clientlistdb.dao;

import br.com.ClientList.modeldb.Client;
import br.com.ClientList.modeldb.Phone;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Cassiano
 */
public class ClientListDaoImpl implements Serializable {

    private List<Client> dataClient; //  lISTA DE CLIENTES
    private Connection connection;
    private PreparedStatement prepared;
    private ResultSet result;
    private Client client;
    private PhoneDaoImpl phoneDaoImpl;
    private Phone phone;

    public void save(Client client) {
        String query = "INSERT INTO client( name,individualRegistration,email )"
                + "VALUES (?,?,?)";
        try {
            //CONEXAO COM O BANCO DE DADOS
            connection = ConnectionFactory.openConnection();
            //PREPARAR A CONEXAO COM O BANCO
            prepared = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);// RETORNA A CRAVE PRIMÁRIA DO CORRENTISTA
            // SETAR OS DADOS DO CORRENTISTA PARA O BANCO
            prepared.setString(1, client.getName());
            prepared.setString(2, client.getIndividualRegistration());
            prepared.setString(3, client.getEmail());
            // EXECUTA NO BANCO DE DADOS
            prepared.executeUpdate();
            result = prepared.getGeneratedKeys();//PEGA A CHAVE PRIMARIA
            result.next();// VAI BUSCAR A ID
            client.setId(result.getInt(1));// BUSCA A PRIMEIRA COLUNA
            phoneDaoImpl = new PhoneDaoImpl();
            phoneDaoImpl.save(client.getPhone(), client.getId(), connection);

        } catch (Exception e) {
            //APRESENTAR A MENSAGEM DE ERRO NA TELA
            System.out.println("erro ao gravar correntista " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }
    }

    public void change(Client client) {
        String query = "UPDATE FROM client SET name = ?, individualRegistration = ?,"
                + "email = ? WHERE idClient = ?";
        try {
            connection = ConnectionFactory.openConnection();
            prepared = connection.prepareStatement(query);
            prepared.setString(1, client.getName());
            prepared.setString(2, client.getIndividualRegistration());
            prepared.setString(3, client.getEmail());
            prepared.setInt(1, client.getId());
            prepared.executeUpdate();
            phoneDaoImpl = new PhoneDaoImpl();
            phoneDaoImpl.change(client.getPhone(), connection);
        } catch (Exception e) {
            System.out.println("Erro ao alterar o Cliente " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM Client WHERE idClient = ?";
        try {
            connection = ConnectionFactory.openConnection();
            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            prepared.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao deletar o Cliente " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }
    }

    public List<Client> listAll() {
        String query = "SELECT FROM Client INNER JOIN Phone ON Client.idclient = Phone.idclient";
        try {
            connection = ConnectionFactory.openConnection();
            prepared = connection.prepareStatement(query);
            prepared.executeUpdate();
            while (result.next()) {
                client = new Client();
                client.setId(result.getInt("Client.idClient"));
                client.setName(result.getString("name"));
                client.setIndividualRegistration(result.getString("individualRegistration"));
                client.setEmail(result.getString("email"));
                phone = new Phone();
                phone.setId(result.getInt("Phone.idPhone"));
                phone.setPhoneNumber(result.getString("phoneNumber"));
                phone.setType(result.getString("type"));
                phone.setPhoneCarrier(result.getString("phoneCarrier"));
                client.setPhone(phone);
                dataClient.add(client);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar o Cliente " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataClient;
    }

    public Client searchById(int id) {
        String query = "SELECT FROM client INNER JOIN Phone ON Client.idClient = "
                + "Phone.idClient WHERE Client.idClient = ?";
        try {
            connection = ConnectionFactory.openConnection();
            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            result.next();
            client = new Client();
            client.setId(result.getInt("Client.idClient"));
            client.setName(result.getString("name"));
            client.setIndividualRegistration(result.getString("individualRegistration"));
            client.setEmail(result.getString("email"));
            phone = new Phone();
            phone.setId(result.getInt("Phone.idPhone"));
            phone.setPhoneNumber(result.getString("phoneNumber"));
            phone.setType(result.getString("type"));
            phone.setPhoneCarrier(result.getString("phoneCarrier"));
            client.setPhone(phone);
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar Cliente " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return client;
    }

}
