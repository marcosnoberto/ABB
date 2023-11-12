public class No {

    private No direita;
    private No esquerda;
    private int valor;
    private int posicaoOrdemSimetrica;
    private int altura;
    private boolean empty;

    No(){
        this.direita = null;
        this.esquerda = null;
        this.empty = true;
    }

    public No getDireita() {
        return direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public int getValor() {
        return valor;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public void setValor(int valor) {
        this.empty = false;
        this.valor = valor;
    }

    public boolean isEmpty(){
        return this.empty;
    }

    public int getPosicaoOrdemSimetrica() {
        return posicaoOrdemSimetrica;
    }

    public void setPosicaoOrdemSimetrica(int posicaoOrdemSimetrica) {
        this.posicaoOrdemSimetrica = posicaoOrdemSimetrica;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

}
