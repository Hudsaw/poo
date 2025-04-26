package nota;

public class Empresa {
    private String nome;
    private String cnpj;
    private String razaoSocial;
    private Endereco endereco;
    private String telefone;
    
    public Empresa(String nome, String cnpj, String razaoSocial, 
                  Endereco endereco, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    public String getNome() { return nome; }
    public String getCnpj() { return cnpj; }
    public String getRazaoSocial() { return razaoSocial; }
    public Endereco getEndereco() { return endereco; }
    public String getTelefone() { return telefone; }
}