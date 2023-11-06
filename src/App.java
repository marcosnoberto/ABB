public class App {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();

        arvore.inserir(20);
        arvore.inserir(25);
        arvore.inserir(24);
        arvore.inserir(27);
        arvore.inserir(10);
        arvore.inserir(8);
        arvore.inserir(11);
        arvore.inserir(9);
        arvore.inserir(26);

        // arvore.imprimir(1);

        // arvore.deletar(20);

        arvore.imprimir(1);

        System.out.println(arvore.posicao(25));
        System.out.println(arvore.enesimoElemento(6));
        System.out.println(arvore.mediana());
        System.out.println(arvore.média(25));

        if (arvore.ehCompleta()) {
            System.out.println("Eh completa");
        } else {
            System.out.println("Vixi, não é completa");
        }

        if (arvore.ehCheia()) {
            System.out.println("Eh cheia");
        } else {
            System.out.println("Vixi, não é cheia");
        }

        System.out.println(arvore.pre_ordem());
    }
}
