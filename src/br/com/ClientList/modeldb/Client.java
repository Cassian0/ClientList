package br.com.ClientList.modeldb;

/**
 * É preciso cadastrar cliente com nome, cpf, e-mail e seus telefones de
 * contato. Para cada telefone é preciso cadastrar o tipo de telefone(fixo ou
 * celular), numero e operadora.Criar o manter cliente (CRUD) onde um cliente
 * pode ter um telefone e cada telefone é de um cliente. Obs.: Criar projeto
 * novo.
 *
 * @author Cassiano
 */
public class Client {

    private Integer id;
    private String name;
    private String individualRegistration;//  CPF DO CLIENTE
    private String email;
    private Phone phone; // CLIENTE TEM UM TELEFONE OU MAIS

    //    CONSTRUTORES DA CLASSE CLIENTE
    public Client() {

    }

    public Client(Integer id, String name, String individualRegistration, String email) {
        this.id = id;
        this.name = name;
        this.individualRegistration = individualRegistration;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndividualRegistration() {
        return individualRegistration;
    }

    public void setIndividualRegistration(String individualRegistration) {
        this.individualRegistration = individualRegistration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

}
