import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();

        File arquivoEntrada = new File("C:/Users/Vinicios/Desktop/ABB/arquivo_entrada.txt");
        Scanner scanEntrada = new Scanner(arquivoEntrada);

        File arquivoComandos = new File("C:/Users/Vinicios/Desktop/ABB/arquivo_comandos.txt");
        Scanner scanComandos = new Scanner(arquivoComandos);

        String comando;

        while (scanEntrada.hasNext()) {
            arvore.inserir(Integer.parseInt(scanEntrada.next()));
        }

        while (scanComandos.hasNext()) {
            comando = scanComandos.next();
            if (comando.equals("ENESIMO")) {
                try {
                    System.out.println(arvore.enesimoElemento(Integer.parseInt(scanComandos.next())));
                } catch (Exception e) {
                    System.out.println("Elemento inválido!");
                }
            } else if (comando.equals("POSICAO")) {
                try {
                    System.out.println(arvore.posicao(Integer.parseInt(scanComandos.next())));
                } catch (Exception e) {
                    System.out.println("Posição invalida!");
                }
            } else if (comando.equals("MEDIANA")) {
                System.out.println(arvore.mediana());
            } else if (comando.equals("CHEIA")) {
                if (arvore.ehCheia()) {
                    System.out.println("Eh cheia");
                } else {
                    System.out.println("Vixi, não é cheia");
                }
            } else if (comando.equals("COMPLETA")) {
                if (arvore.ehCompleta()) {
                    System.out.println("Eh completa");
                } else {
                    System.out.println("Vixi, não é completa");
                }
            } else if (comando.equals("IMPRIMA")) {
                arvore.imprimir(Integer.parseInt(scanComandos.next()));
            } else if (comando.equals("REMOVA")) {
                arvore.deletar(Integer.parseInt(scanComandos.next()));
            }
        }
    }
}
