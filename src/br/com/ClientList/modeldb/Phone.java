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
public class Phone {

    private Integer id;
    private String phoneNumber; // NUMERO DO TELEFONE
    private String type; // TIPO (FIXO/ MOVEL)
    private String phoneCarrier; // OPERADORA    

    //  CONTRUTOR DA CLASSE PHONE   
    public Phone() {

    }

    public Phone(String phoneNumber, String type, String phoneCarrier) {
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.phoneCarrier = phoneCarrier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneCarrier() {
        return phoneCarrier;
    }

    public void setPhoneCarrier(String phoneCarrier) {
        this.phoneCarrier = phoneCarrier;
    }

}
