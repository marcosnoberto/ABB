public class App {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();

        arvore.inserir(5);
        arvore.inserir(3);
        arvore.inserir(2);
        arvore.inserir(4);
        arvore.inserir(6);

        arvore.imprimirFormato2();

        System.out.println(arvore.buscar(4).getValor());
    }
}
