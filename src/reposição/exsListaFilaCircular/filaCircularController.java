package reposição.exsListaFilaCircular;

public class filaCircularController {
    private No inicio = null;
    private No fim = null;

    public boolean isVazia() {
        return inicio == null;
    }

    public void enfileirar(int valor) {
        No novo = new No(valor);

        if (isVazia()) {
            inicio = fim = novo;
            fim.setProximo(inicio);  
        } else {
            fim.setProximo(novo);
            fim = novo;
            fim.setProximo(inicio);  
        }
    }

    public int desenfileirar() {
        if (isVazia()) {
            throw new IllegalStateException("Fila vazia");
        }

        int valorRemovido = inicio.getValor();

        if (inicio == fim) { 
            inicio = fim = null;
        } else {
            inicio = inicio.getProximo();
            fim.setProximo(inicio);  
        }

        return valorRemovido;
    }

    public void imprimir() {
        if (isVazia()) {
            System.out.println("Fila vazia");
            return;
        }

        No atual = inicio;
        do {
            System.out.print(atual.getValor() + " -> ");
            atual = atual.getProximo();
        } while (atual != inicio);

        System.out.println("(volta ao início)");
    }
}

