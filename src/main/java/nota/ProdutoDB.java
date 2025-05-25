package nota;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
public class ProdutoDB {
    private static HashMap<Integer, Produto> produtos = new HashMap<>();
    static {
        try {
            Scanner s = new Scanner(new File("produtos.csv"));
            //Skip na primeira linha
            s.nextLine();
            while(s.hasNext()){
                String linha = s.nextLine();
                String[] colunas = linha.split(",");

                Produto produto = new Produto();
                produto.setCodigo(Integer.parseInt(colunas[0]));
                produto.setDescricao(colunas[1]);
                produto.setValorUnitario(Double.parseDouble(colunas[2]));

                produtos.put(produto.getCodigo(),produto);
                System.out.println(linha);
            }
            System.out.println("Produtos carregados: " + produtos.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo não encontrado");
        }
    }
    public static Produto buscaPorCodigo(Integer codigo){
        return produtos.get(codigo);
    }
}
