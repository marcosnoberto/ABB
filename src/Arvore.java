public class Arvore {
    private No base;

    Arvore() {
        this.base = new No();
    }

    public void inserir(int n) {
        inserirRecursivo(n, this.base);
    }

    private void inserirRecursivo(int n, No no) {
        if (no.isEmpty()) {
            no.setValor(n);
        } else {
            if (n < no.getValor()) {
                if (no.getEsquerda() == null) {
                    No novo = new No();
                    no.setEsquerda(novo);
                }
                inserirRecursivo(n, no.getEsquerda());
            } else if (no.getValor() < n) {
                if (no.getDireita() == null) {
                    No novo = new No();
                    no.setDireita(novo);
                }
                inserirRecursivo(n, no.getDireita());
            }
        }
    }

     public No buscar(int n) {
        return buscaRecursiva(n, this.base);
    }

    private No buscaRecursiva(int n, No no) {
        if (!no.isEmpty()) {
            if(n == no.getValor()){
                return no;
            }
            else if (no.getEsquerda() != null && n < no.getValor()) {
                return buscaRecursiva(n, no.getEsquerda());
            } 
            else if (no.getDireita() != null && no.getValor() < n) {
                return buscaRecursiva(n, no.getDireita());
            }
        }

        return null;
    }

    public void imprimirFormato2() {
        imprimirFormato2Recursivo(base);
        System.out.println("");
    }

    private void imprimirFormato2Recursivo(No no) {
        if (!no.isEmpty()) {
            System.out.print("(" + no.getValor());
            if (no.getEsquerda() != null) {
                imprimirFormato2Recursivo(no.getEsquerda());
            } if (no.getDireita() != null) {
                imprimirFormato2Recursivo(no.getDireita());
            }
            System.out.print(")");
        }
    }

}
