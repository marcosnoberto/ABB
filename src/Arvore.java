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
            if (n == no.getValor()) {
                return no;
            } else if (no.getEsquerda() != null && n < no.getValor()) {
                return buscaRecursiva(n, no.getEsquerda());
            } else if (no.getDireita() != null && no.getValor() < n) {
                return buscaRecursiva(n, no.getDireita());
            }
        }

        return null;
    }

    public void imprimir(int forma) {
        if (this.base != null) {
            if (forma == 1) {
                imprimirFormato1Recursivo(base, 0);
            } else if (forma == 2) {
                imprimirFormato2Recursivo(base);
                System.out.println();
            }
        }

    }

    private void imprimirFormato1Recursivo(No no, int pos) {
        if (!no.isEmpty()) {

            for (int i = 0; i < pos; i++) {
                System.out.print("   ");
            }
            System.out.print(no.getValor());
            for (int i = 10; i > pos; i--) {
                System.out.print("---");
            }
            System.out.println();

            if (no.getEsquerda() != null) {
                imprimirFormato1Recursivo(no.getEsquerda(), pos + 1);
            }
            if (no.getDireita() != null) {
                imprimirFormato1Recursivo(no.getDireita(), pos + 1);
            }
        }
    }

    private void imprimirFormato2Recursivo(No no) {
        if (!no.isEmpty()) {
            System.out.print("(" + no.getValor());
            if (no.getEsquerda() != null) {
                imprimirFormato2Recursivo(no.getEsquerda());
            }
            if (no.getDireita() != null) {
                imprimirFormato2Recursivo(no.getDireita());
            }
            System.out.print(")");
        }
    }

    public void deletar(int n) {
        No no = this.base;
        while (no != null) {
            if (no.getValor() == n) {
                break;
            } else if (no.getEsquerda() != null && n < no.getValor()) {
                no = no.getEsquerda();
            } else if (no.getDireita() != null && no.getValor() < n) {
                no = no.getDireita();
            } else {
                return;
            }
        }

        if (no.getDireita() == null && no.getEsquerda() == null) {
            if (this.base.getValor() == n) {
                this.base = null;
                return;
            } else {
                deletarFolha(n, this.base);
            }
        } else if (no.getDireita() == null) {
            System.out.println("Apenas 1 filho, da esquerda.");
        } else if (no.getEsquerda() == null) {
            System.out.println("Apenas 1 filho, da direita.");
            deletar1FilhoDireita(n, this.base);
        } else {
            System.out.println("Dois filhos");
        }
    }

    private void deletarFolha(int n, No no) {
        if (n < no.getValor()) {
            if (!no.getEsquerda().isEmpty()) {
                if (no.getEsquerda().getValor() == n) {
                    no.setEsquerda(null);
                    return;
                }
            }
            deletarFolha(n, no.getEsquerda());
        } else if (no.getValor() < n) {
            if (!no.getDireita().isEmpty()) {
                if (no.getDireita().getValor() == n) {
                    no.setDireita(null);
                    return;
                }
            }
            deletarFolha(n, no.getDireita());
        }

    }

    private void deletar1FilhoDireita(int n, No no) {
        if (n < no.getValor()) {
            if (!no.getEsquerda().isEmpty()) {
                if (no.getEsquerda().getValor() == n) {
                    if (no.getEsquerda().getDireita().getEsquerda() == null) {
                        no.getEsquerda().setValor(no.getEsquerda().getDireita().getValor());
                        no.getEsquerda().setDireita(no.getEsquerda().getDireita().getDireita());
                    } else {
                        no.getEsquerda().setValor(excluirNoDireita(n, no.getEsquerda().getDireita()));
                    }
                    return;
                }
            }
            deletar1FilhoDireita(n, no.getEsquerda());
        } else if (no.getValor() < n) {
            if (!no.getDireita().isEmpty()) {
                if (no.getDireita().getValor() == n) {
                    if (no.getDireita().getDireita().getEsquerda() == null) {
                        no.getDireita().setValor(no.getDireita().getDireita().getValor());
                        no.getDireita().setDireita(no.getEsquerda().getDireita().getDireita());
                    } else {
                        no.getDireita().setValor(excluirNoDireita(n, no.getDireita().getDireita()));
                    }
                    return;
                }
            }
            deletar1FilhoDireita(n, no.getDireita());
        }
    }

    private int excluirNoDireita(int n, No no) {
        int valor;

        if (no.getEsquerda().getEsquerda() == null) {
            valor = no.getEsquerda().getValor();
            no.setEsquerda(no.getEsquerda().getDireita());
            return valor;
        }

        return excluirNoDireita(n, no.getEsquerda());
    }

}
