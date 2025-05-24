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
        Paciente paciente = new Paciente();
        paciente.setNome("Angenor de Oliveira");
        paciente.setId(123456);
        paciente.setSexo("Masculino");
        Calendar nascimento = Calendar.getInstance();
        nascimento.set(1980, Calendar.NOVEMBER, 30); 
        paciente.setDataNascimento(nascimento.getTime());

        // Gerando usuário e senha
        String primeiroNome = paciente.getNome().split(" ")[0];
        String diaNascimento = new Utilidade().formatarData(paciente.getDataNascimento()).substring(0, 2);
        String usuario = primeiroNome + diaNascimento;
        String senha = new Utilidade().formatarData(paciente.getDataNascimento()).replaceAll("/", "");

        // Solicitação
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setId(1001);
        solicitacao.setDatasolicitacao(new Date());
        solicitacao.setSolicitante("Dr. Hudson Borges");
        solicitacao.setResponsavel("Recepção Central");

        // Exames
        TipoExame tipo1 = new TipoExame();
        tipo1.setCodigo(12345);
        tipo1.setDescricao("CULTURA AERÓBIA");
        tipo1.setColeta("FEZES");
        tipo1.setPrazo(5);

        TipoExame tipo2 = new TipoExame();
        tipo2.setCodigo(67890);
        tipo2.setDescricao("HEMOGRAMA COMPLETO");
        tipo2.setColeta("SANGUE");
        tipo2.setPrazo(2);

        Exame exame1 = new Exame();
        exame1.setTipoExame(tipo1);
        exame1.setDataColeta(new Date());

        Exame exame2 = new Exame();
        exame2.setTipoExame(tipo2);
        exame2.setDataColeta(new Date());

        solicitacao.setExames(Arrays.asList(exame1, exame2));

        // Imprimir protocolo
        Impressao protocolo = new Impressao();
        protocolo.setEmpresa(hospital);
        protocolo.setPaciente(paciente);
        protocolo.setSolicitacao(solicitacao);
        protocolo.imprimir(usuario, senha);
    }
}