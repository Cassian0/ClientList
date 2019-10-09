package br.com.clientlistdb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**FABRICA DE CONEXÃO QUE VAI LIGAR O JAVA AO BANCO DE DADOS
 *  
 * @author Cassiano
 */
public class ConnectionFactory {
        // METODO UTILIZADO PARA ABRIR CONEXÃO COM O BANCO
    public static Connection openConnection() throws Exception { 
        // FORNAME É O METODO DENTRO DA CLASSE (CLASS)
        Class.forName("com.mysql.jdbc.Driver");
        // IMPORTAR DRIVER JDBC DA BIBLIOTECA
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/clientlist",
                        "root", "");
    }

    // ABRE CONEXÃO COM O BANCO DE DADOS E PREPARA AS INSTRUÇÕES DO MYSQL
    public static void closeConnection(Connection conn, PreparedStatement ps) {
        close(conn, ps, null);
    }

   // PREPARED UTILIZADO EM CONJUNTO COM O INSERT COM O BANCO DE DADOS
    public static void closeConnection(Connection conn, PreparedStatement ps, 
            ResultSet rs) { // PEGAR O QUE VEM DO SELECT DO BANCO DE DADOS
        close(conn, ps, rs);
    }

    private static void close(Connection conn, PreparedStatement ps,
            ResultSet rs) {
        try {
            conn.close();
            ps.close();
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqlE) {
            System.out.println("Erro ao fechar conexão " + sqlE.getMessage());
        }
    }
    
}
