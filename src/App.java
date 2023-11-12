import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();
        String caminho = System.getProperty("user.dir");
        String separador = System.getProperty("file.separator");

        File arquivoEntrada = new File(caminho + separador + "arquivo_entrada.txt");
        Scanner scanEntrada = new Scanner(arquivoEntrada);

        File arquivoComandos = new File(caminho + separador + "arquivo_comandos.txt");
        Scanner scanComandos = new Scanner(arquivoComandos);

        String comando;

        while (scanEntrada.hasNext()) {
            arvore.inserir(Integer.parseInt(scanEntrada.next()));
        }

        while (scanComandos.hasNext()) {
            comando = scanComandos.next();
            if (comando.equals("ENESIMO")) {
                try {
                    System.out.println(
                            "Enesimo elemento: " + arvore.enesimoElemento(Integer.parseInt(scanComandos.next())));
                } catch (Exception e) {
                    System.out.println("Elemento inválido!");
                }
            } else if (comando.equals("POSICAO")) {
                try {
                    System.out.println("Posição: " + arvore.posicao(Integer.parseInt(scanComandos.next())));
                } catch (Exception e) {
                    System.out.println("Posição inválida!");
                }
            } else if (comando.equals("MEDIANA")) {
                System.out.println("Mediana: " + arvore.mediana());
            } else if (comando.equals("CHEIA")) {
                if (arvore.ehCheia()) {
                    System.out.println("A árvore é cheia");
                } else {
                    System.out.println("A árvore não é cheia");
                }
            } else if (comando.equals("COMPLETA")) {
                if (arvore.ehCompleta()) {
                    System.out.println("A árvore é completa");
                } else {
                    System.out.println("A árvore não é completa");
                }
            } else if (comando.equals("IMPRIMA")) {
                arvore.imprimir(Integer.parseInt(scanComandos.next()));
            } else if (comando.equals("REMOVA")) {
                arvore.deletar(Integer.parseInt(scanComandos.next()));
                System.out.println("Nó removido.0");
            }
        }
    }
}
