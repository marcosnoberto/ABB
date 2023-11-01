public class App {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();

        arvore.inserir(250);
        arvore.inserir(220);
        arvore.inserir(230);
        arvore.inserir(229);
        arvore.inserir(260);
        arvore.inserir(227);
        arvore.inserir(228);
        arvore.inserir(219);
        arvore.inserir(218);
        arvore.inserir(270);

        arvore.imprimir(1);

        // System.out.println(arvore.buscar(4).getValor());

        arvore.deletar(230);

        arvore.imprimir(1);
    }
}
