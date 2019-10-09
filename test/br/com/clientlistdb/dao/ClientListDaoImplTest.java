package br.com.clientlistdb.dao;

import br.com.ClientList.modeldb.Client;
import br.com.ClientList.modeldb.Phone;
import java.util.List;

/**
 *
 * @author Cassiano
 */
public class ClientListDaoImplTest {
    
    private Client client;
    private ClientListDaoImpl clientDao;
    private Phone phone;
    private List<Client> dataClient;

    public ClientListDaoImplTest() {
        clientDao = new ClientListDaoImpl();
    }

    //@Test
    public void testSave() {
        System.out.println("Salvar");
        client = new Client(null,"Joao", "123.145.789-45", "cassio@gmail.com");
        phone = new Phone("98421-5189", "movel", "oi");
        client.setPhone(phone);
        clientDao.save(client);
    }
   //@Test
    public void testList() {
        System.out.println("Listar");
        dataClient = clientDao.listAll();
        for (Client client : dataClient) {
            System.out.println("ID: " + client.getId());
            System.out.println("Nome: " + client.getName());
            System.out.println("CPF: " + client.getIndividualRegistration());
            System.out.println("Email: " + client.getEmail());
            System.out.println("Telefone: " + client.getPhone().getPhoneNumber());
            System.out.println("Tipo: " + client.getPhone().getType());
            System.out.println("Operadora: " + client.getPhone().getPhoneCarrier());
            System.out.println(" ");
        }
    }
    //@Test
    public void testListById() {
        int id = 1;
        System.out.println("Listar por ID");
        client = clientDao.searchById(id);
        System.out.println("ID: " + client.getId());
        System.out.println("Nome: " + client.getName());
        System.out.println("CPF: " + client.getIndividualRegistration());
        System.out.println("Email: " + client.getEmail());
        System.out.println("Telefone: " + client.getPhone().getPhoneNumber());
        System.out.println("Tipo: " + client.getPhone().getType());
        System.out.println("Operadora: " + client.getPhone().getPhoneCarrier());
        System.out.println(" ");
    }
    //@Test
    public void testSearchByName() {
        System.out.println("Pesquisar por nome");
        String name = "";
        dataClient = clientDao.searchByName(name);
        for (Client client1 : dataClient) {
            System.out.println("ID: " + client1.getId());
            System.out.println("Nome: " + client1.getName());
            System.out.println("CPF: " + client1.getIndividualRegistration());
            System.out.println("E-mail: " + client1.getEmail());
            System.out.println("ID Telefone: " + client1.getPhone().getId());
            System.out.println("Numero Telefone: " + client1.getPhone().getPhoneNumber());
            System.out.println("Tipo: " + client1.getPhone().getType());
            System.out.println("Operadora: " + client1.getPhone().getPhoneCarrier());
            System.out.println();
            
        }
    }
    //@Test
    public void testChange() {
        System.out.println("Alterar");
        int id = 1;
        client = new Client(id, "Tommy", "371.787.247-43", "tommy@email.com");
        phone = new Phone("554799660064", "Movel", "Vivo");
        phone.setId(id);
        client.setPhone(phone);
        clientDao.change(client);
    }
   //@Test
    public void testDelete() {
        System.out.println("Deletar");
        int id = 1;
        clientDao.delete(id);
    }

}
