public class Empresa {
    private String nome;
    private String cnpj;
    private String inscricaoEstadual;
    private Endereco endereco;
    private String telefone;
    private String email;
    
    public Empresa(String nome, String cnpj, String inscricaoEstadual, 
                  Endereco endereco, String telefone, String email) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }
    
    // Getters
    public String getNome() {
        return nome;
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public String getEmail() {
        return email;
    }
}