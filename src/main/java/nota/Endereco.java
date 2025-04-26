package nota;

public class Endereco {
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    
    public Endereco(String logradouro, String numero, String bairro, 
                   String cidade, String estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return logradouro + ", " + numero + " - " + bairro + ", " + cidade + "/" + estado;
    }
}