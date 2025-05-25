package exame;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Empresa
        Empresa hospital = new Empresa();
        hospital.setNomeFantasia("Hospital Universitário do IFSC");
        hospital.getEndereco().setLogradouro("Av Manoel Gonçalves da Luz");
        hospital.getEndereco().setNumero("469");
        hospital.getEndereco().setBairro("Bela Vista");
        hospital.getEndereco().setCidade("Gaspar");
        hospital.getEndereco().setEstado("SC");
        hospital.getEndereco().setCep("89150-000");
        hospital.getEndereco().setUrl("http://www.ifsc.edu.br/hospital");
        hospital.setTelefone("(47)3097-0863");

        // Paciente
        Cliente cliente = new Cliente();
        cliente.setNome("Angenor de Oliveira");
        cliente.setId(123456);
        cliente.setSexo("Masculino");
        Calendar nascimento = Calendar.getInstance();
        nascimento.set(1980, Calendar.NOVEMBER, 30); 
        cliente.setDataNascimento(nascimento.getTime());

        // Gerando usuário e senha
        String primeiroNome = cliente.getNome().split(" ")[0];
        String diaNascimento = new Utilidade().formatarData(cliente.getDataNascimento()).substring(0, 2);
        String usuario = primeiroNome + diaNascimento;
        String senha = new Utilidade().formatarData(cliente.getDataNascimento()).replaceAll("/", "");

        // Solicitação
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setId(1001);
        solicitacao.setDatasolicitacao(new Date());
        solicitacao.setSolicitante("Dr. Hudson Borges");
        solicitacao.setResponsavel("Recepção Central");

        // Exames
        TipoItem tipo1 = new TipoItem();
        tipo1.setCodigo(12345);
        tipo1.setDescricao("CULTURA AERÓBIA");
        tipo1.setColeta("FEZES");
        tipo1.setPrazo(5);

        TipoItem tipo2 = new TipoItem();
        tipo2.setCodigo(67890);
        tipo2.setDescricao("HEMOGRAMA COMPLETO");
        tipo2.setColeta("SANGUE");
        tipo2.setPrazo(2);

        Exame exame1 = new Exame();
        exame1.setTipoItem(tipo1);
        exame1.setDataColeta(new Date());

        Exame exame2 = new Exame();
        exame2.setTipoItem(tipo2);
        exame2.setDataColeta(new Date());

        solicitacao.setExames(Arrays.asList(exame1, exame2));

        // Imprimir protocolo
        Impressao protocolo = new Impressao();
        protocolo.setEmpresa(hospital);
        protocolo.setCliente(cliente);
        protocolo.setSolicitacao(solicitacao);
        protocolo.imprimir(usuario, senha);
    }
}