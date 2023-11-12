public class Arvore {
    private No base;

    Arvore() {
        this.base = new No();
    }

    public void inserir(int n) {
        inserirRecursivo(n, this.base);
        definirPosicaoOrdemSimetrica(base, 0);
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
                System.out.print(" ");
                imprimirFormato2Recursivo(no.getEsquerda());
            }
            if (no.getDireita() != null) {
                System.out.print(" ");
                imprimirFormato2Recursivo(no.getDireita());
            }
            System.out.print(")");
        }
    }

    public boolean deletar(int n) {
        No no = this.base;
        while (no != null) {
            if (no.getValor() == n) {
                break;
            } else if (no.getEsquerda() != null && n < no.getValor()) {
                no = no.getEsquerda();
            } else if (no.getDireita() != null && no.getValor() < n) {
                no = no.getDireita();
            } else {
                return false;
            }
        }

        if (no.getDireita() == null && no.getEsquerda() == null) {
            if (this.base.getValor() == n) {
                this.base = null;
                return true;
            } else {
                deletarFolha(n, this.base);
            }
        } else if (no.getDireita() == null) {
            if (this.base.getValor() == n) {
                if (this.base.getEsquerda().getDireita() == null) {
                    this.base.getEsquerda().setDireita(this.base.getDireita());
                    this.base = this.base.getEsquerda();
                } else {
                    this.base.setValor(excluirNoEsquerda(this.base.getEsquerda()));
                }
            } else {
                deletar1FilhoEsquerda(n, this.base);
            }
        } else if (no.getEsquerda() == null) {
            if (this.base.getValor() == n) {
                if (this.base.getDireita().getEsquerda() == null) {
                    this.base.getDireita().setEsquerda(this.base.getEsquerda());
                    this.base = this.base.getDireita();
                } else {
                    this.base.setValor(excluirNoDireita(this.base.getDireita()));
                }
            } else {
                deletar1FilhoDireita(n, this.base);
            }
        } else {
            if (this.base.getValor() == n) {
                if (this.base.getDireita().getEsquerda() == null) {
                    this.base.getDireita().setEsquerda(this.base.getEsquerda());
                    this.base = this.base.getDireita();
                } else {
                    this.base.setValor(excluirNoDireita(this.base.getDireita()));
                }
            } else {
                deletar1FilhoDireita(n, this.base);
            }
        }
        definirPosicaoOrdemSimetrica(base, 0);
        return true;
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
                        no.getEsquerda().setValor(excluirNoDireita(no.getEsquerda().getDireita()));
                    }
                    return;
                }
                deletar1FilhoDireita(n, no.getEsquerda());
            }
        } else if (no.getValor() < n) {
            if (!no.getDireita().isEmpty()) {
                if (no.getDireita().getValor() == n) {
                    if (no.getDireita().getDireita().getEsquerda() == null) {
                        no.getDireita().setValor(no.getDireita().getDireita().getValor());
                        no.getDireita().setDireita(no.getDireita().getDireita().getDireita());
                    } else {
                        no.getDireita().setValor(excluirNoDireita(no.getDireita().getDireita()));
                    }
                    return;
                }
                deletar1FilhoDireita(n, no.getDireita());
            }
        }
    }

    private int excluirNoDireita(No no) {
        int valor;

        if (no.getEsquerda().getEsquerda() == null) {
            valor = no.getEsquerda().getValor();
            no.setEsquerda(no.getEsquerda().getDireita());
            return valor;
        }

        return excluirNoDireita(no.getEsquerda());
    }

    private void deletar1FilhoEsquerda(int n, No no) {
        if (n < no.getValor()) {
            if (!no.getEsquerda().isEmpty()) {
                if (no.getEsquerda().getValor() == n) {
                    if (no.getEsquerda().getEsquerda().getDireita() == null) {
                        no.getEsquerda().setValor(no.getEsquerda().getEsquerda().getValor());
                        no.getEsquerda().setDireita(no.getEsquerda().getEsquerda().getDireita());
                    } else {
                        no.getEsquerda().setValor(excluirNoEsquerda(no.getEsquerda().getEsquerda()));
                    }
                    return;
                }
                deletar1FilhoEsquerda(n, no.getEsquerda());
            }
        } else if (no.getValor() < n) {
            if (!no.getDireita().isEmpty()) {
                if (no.getDireita().getValor() == n) {
                    if (no.getDireita().getEsquerda().getDireita() == null) {
                        no.getDireita().setValor(no.getDireita().getEsquerda().getValor());
                        no.getDireita().setEsquerda(no.getDireita().getEsquerda().getEsquerda());
                    } else {
                        no.getDireita().setValor(excluirNoEsquerda(no.getDireita().getEsquerda()));
                    }
                    return;
                }
                deletar1FilhoEsquerda(n, no.getEsquerda());
            }

        }
    }

    private int excluirNoEsquerda(No no) {
        int valor;

        if (no.getDireita().getDireita() == null) {
            valor = no.getDireita().getValor();
            no.setDireita(no.getDireita().getEsquerda());
            return valor;
        }

        return excluirNoEsquerda(no.getDireita());
    }

    public int enesimoElemento(int posicao) {
        return getEnesimoElemento(this.base, posicao);
    }

    private int getEnesimoElemento(No no, int posicao) {
        if (no.getPosicaoOrdemSimetrica() == posicao) {
            return no.getValor();
        } else {
            if (posicao < no.getPosicaoOrdemSimetrica()) {
                return getEnesimoElemento(no.getEsquerda(), posicao);
            } else {
                return getEnesimoElemento(no.getDireita(), posicao);
            }
        }
    }

    private int definirPosicaoOrdemSimetrica(No no, int contador) {
        if (no.getEsquerda() != null) {
            contador = definirPosicaoOrdemSimetrica(no.getEsquerda(), contador);
        }

        contador++;
        no.setPosicaoOrdemSimetrica(contador);

        if (no.getDireita() != null) {
            contador = definirPosicaoOrdemSimetrica(no.getDireita(), contador);
        }

        return contador;
    }

    public int posicao(int x) {
        No no = this.base;
        while (no.getValor() != x) {
            if (no.getEsquerda() != null && x < no.getValor()) {
                no = no.getEsquerda();
            } else if (no.getDireita() != null && no.getValor() < x) {
                no = no.getDireita();
            } else {
                no = null;
                break;
            }
        }
        return no.getPosicaoOrdemSimetrica();
    }

    public int mediana() {
        No no = this.base;
        int media, maior;

        while (no.getDireita() != null) {
            no = no.getDireita();
        }
        maior = no.getPosicaoOrdemSimetrica();

        media = (maior + 1) / 2;

        return buscarMediana(this.base, media);
    }

    private int buscarMediana(No no, int media) {
        if (media < no.getPosicaoOrdemSimetrica()) {
            if (no.getEsquerda() != null) {
                return buscarMediana(no.getEsquerda(), media);
            }
        } else if (no.getPosicaoOrdemSimetrica() < media) {
            if (no.getDireita() != null) {
                return buscarMediana(no.getDireita(), media);
            }
        }
        return no.getValor();
    }

    public double média(int x) {
        No no = buscar(x);
        No noSalvar = no;
        double soma = 0, quantidade, max, min;

        soma = somarNos(no, soma);

        while (no.getDireita() != null) {
            no = no.getDireita();
        }
        max = no.getPosicaoOrdemSimetrica();

        no = noSalvar;

        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        min = no.getPosicaoOrdemSimetrica();

        quantidade = max - min + 1;

        return soma / quantidade;
    }

    private double somarNos(No no, double soma) {
        soma = soma + no.getValor();

        if (no.getEsquerda() != null) {
            soma = somarNos(no.getEsquerda(), soma);
        }
        if (no.getDireita() != null) {
            soma = somarNos(no.getDireita(), soma);
        }
        return soma;
    }

    public boolean ehCompleta() {
        definirAltura(this.base, 0);
        return checarCompletude(this.base, true);
    }

    public boolean ehCheia() {
        definirAltura(this.base, 0);
        return checarCheia(this.base, true);
    }

    private boolean checarCheia(No no, boolean status) {
        if (no.getAltura() == 1) {
            return true;
        } else if (no.getDireita() == null || no.getEsquerda() == null) {
            return false;
        }

        status = checarCheia(no.getEsquerda(), status);

        if (status == false) {
            return status;
        }

        status = checarCheia(no.getDireita(), status);

        return status;

    }

    private boolean checarCompletude(No no, boolean status) {
        if (no.getAltura() <= 2) {
            return true;
        } else if (no.getDireita() == null || no.getEsquerda() == null) {
            return false;
        }

        status = checarCompletude(no.getEsquerda(), status);

        if (status == false) {
            return status;
        }

        status = checarCompletude(no.getDireita(), status);

        return status;

    }

    private int definirAltura(No no, int alturaFilho) {
        if (no.getEsquerda() == null && no.getDireita() == null) {
            no.setAltura(1);
            return 1;
        }

        if (no.getEsquerda() != null) {
            alturaFilho = definirAltura(no.getEsquerda(), alturaFilho);
        }
        no.setAltura(alturaFilho + 1);

        if (no.getDireita() != null) {
            alturaFilho = 0;
            alturaFilho = definirAltura(no.getDireita(), alturaFilho);
        }

        if (no.getAltura() < alturaFilho + 1) {
            no.setAltura(alturaFilho + 1);
        }

        return no.getAltura();
    }

    public String pre_ordem() {
        String preOrdem = "[";
        preOrdem = percorrerPreOrdem(this.base, preOrdem);
        preOrdem = preOrdem.substring(0, preOrdem.length() - 2) + "]";
        return preOrdem;
    }

    public String percorrerPreOrdem(No no, String preOrdem) {
        String valor = no.getValor() + ", ";
        preOrdem = preOrdem + valor;

        if (no.getEsquerda() != null) {
            preOrdem = percorrerPreOrdem(no.getEsquerda(), preOrdem);
        }
        if (no.getDireita() != null) {
            preOrdem = percorrerPreOrdem(no.getDireita(), preOrdem);
        }
        return preOrdem;
    }

}
