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

        String comando, valor;

        while (scanEntrada.hasNext()) {
            valor = scanEntrada.next();
            arvore.inserir(Integer.parseInt(valor));
        }

        while (scanComandos.hasNext()) {
            comando = scanComandos.next();
            if (comando.equals("INSIRA")) {
                valor = scanComandos.next();
                if (arvore.inserir(Integer.parseInt(valor))) {
                    System.out.println(valor + " adicionado");
                } else {
                    System.out.println(valor + " já está na árvore, não pode ser inserido");
                }
            } else if (comando.equals("ENESIMO")) {
                try {
                    System.out.println(arvore.enesimoElemento(Integer.parseInt(scanComandos.next())));
                } catch (Exception e) {
                    System.out.println("Elemento inválido!");
                }
            } else if (comando.equals("POSICAO")) {
                try {
                    System.out.println(arvore.posicao(Integer.parseInt(scanComandos.next())));
                } catch (Exception e) {
                    System.out.println("Posição inválida!");
                }
            } else if (comando.equals("MEDIANA")) {
                System.out.println(arvore.mediana());
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
                valor = scanComandos.next();
                if (arvore.deletar(Integer.parseInt(valor))) {
                    System.out.println(valor + " removido");
                } else {
                    System.out.println(valor + " não está na árvore, não pode ser removido");
                }
            } else if (comando.equals("PREORDEM")) {
                System.out.println(arvore.pre_ordem());
            } else if (comando.equals("MEDIA")) {
                valor = scanComandos.next();
                if (arvore.buscar(Integer.parseInt(valor)) != null) {
                    System.out.println(arvore.média(Integer.parseInt(valor)));
                } else {
                    System.out.println(valor + "não encontrado");
                }
            } else if (comando.equals("BUSCAR")) {
                if (arvore.buscar(Integer.parseInt(scanComandos.next())) != null) {
                    System.out.println("Chave encontrada");
                } else {
                    System.out.println("Chave não encontrada");
                }

            }
        }

        scanEntrada.close();
        scanComandos.close();
    }
}
