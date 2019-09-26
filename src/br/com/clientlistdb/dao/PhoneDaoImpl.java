package br.com.clientlistdb.dao;

import br.com.ClientList.modeldb.Phone;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Cassiano
 */
public class PhoneDaoImpl implements Serializable {

    private PreparedStatement prepared;
    private Phone phone;

    public void save(Phone phone, int id, Connection connection) {
        String query = "INSERT INTO phone( phoneNumber, type, phoneCarrier, idClient )"
                + "VALUES (?, ?, ?, ?)";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, phone.getPhoneNumber());
            prepared.setString(2, phone.getType());
            prepared.setString(3, phone.getPhoneCarrier());
            prepared.setInt(4, id);
            prepared.executeUpdate();
        } catch (Exception e) {

            System.out.println("Erro ao gravar endereco " + e.getMessage());
        }
    }

}
