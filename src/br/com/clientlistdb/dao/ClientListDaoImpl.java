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

}
