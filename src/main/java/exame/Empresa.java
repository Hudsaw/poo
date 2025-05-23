package exame;

public class Empresa {
    private Endereco endereco = new Endereco();
    private String nomeFantasia;
    private String telefone;
    private String url;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUrl() {return url;}

    public void setUrl(String url) {this.url = url;}
}
