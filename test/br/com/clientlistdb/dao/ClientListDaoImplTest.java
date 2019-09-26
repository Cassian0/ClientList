package br.com.clientlistdb.dao;


import br.com.ClientList.modeldb.Client;
import br.com.ClientList.modeldb.Phone;
import org.junit.Test;

/**
 *
 * @author Cassiano
 */
public class ClientListDaoImplTest {
    
    private Client client;
    private ClientListDaoImpl clientDao;
    private Phone phone;

    public ClientListDaoImplTest() {
    }
    
    @Test
    public void testSave() {
        System.out.println("Salvar");
        client = new Client("Cassiano","123.145.789-45","cassio@gmail.com");
        phone = new Phone("98421-5189", "movel", "oi");
        client.setPhone(phone);
        clientDao = new ClientListDaoImpl();
        clientDao.save(client);
    }   
}
