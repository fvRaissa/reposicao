package reposição.exsListaFilaCircular;



public class listCircularController {
    private No inicio = null;
    private No fim = null;

    
    public void adicionarFinal(int valor) {
        No novoNo = new No(valor);
        if (inicio == null) {
            inicio = fim = novoNo;
            fim.setProximo(inicio); 
        } else {
            fim.setProximo(novoNo);
            fim = novoNo;
            fim.setProximo(inicio); 
        }
    }

   
    public void remover(int valor) {
        if (inicio == null) return;

        No atual = inicio;
        No anterior = fim;
        do {
            if (atual.getValor() == valor) {
                if (atual == inicio) {
                    inicio = inicio.getProximo();
                    fim.setProximo(inicio);
                } else if (atual == fim) {
                    fim = anterior;
                    fim.setProximo(inicio);
                } else {
                    anterior.setProximo(atual.getProximo());
                }
                return;
            }
            anterior = atual;
            atual = atual.getProximo();
        } while (atual != inicio);
    }

    
    public No buscar(int valor) {
        if (inicio == null) return null;

        No atual = inicio;
        do {
            if (atual.getValor() == valor) return atual;
            atual = atual.getProximo();
        } while (atual != inicio);

        return null;
    }

    
    public void imprimir() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        No atual = inicio;
        do {
            System.out.print(atual.getValor() + " -> ");
            atual = atual.getProximo();
        } while (atual != inicio);
        System.out.println("(volta para o início)");
    }

    public boolean isCircular() {
        if (inicio == null) {
            return false; 
        }

        No lento = inicio;
        No rapido = inicio;

        while (rapido != null && rapido.getProximo() != null) {
            lento = lento.getProximo();            
            rapido = rapido.getProximo().getProximo(); 

            if (lento == rapido) {
                return true;  
            }
        }

        return false; 
    }

    
    
    public int contarNos() {
        if (inicio == null) return 0;

        int contador = 0;
        No atual = inicio;
        do {
            contador++;
            atual = atual.getProximo();
        } while (atual != inicio);

        return contador;
    }

    public int josephus(int k) {
        if (inicio == null || k <= 0) return -1; // caso base

        No atual = inicio;
        No anterior = fim;

      
        while (atual != atual.getProximo()) {
            
            for (int count = 1; count < k; count++) {
                anterior = atual;
                atual = atual.getProximo();
            }
            
            System.out.println("Removendo: " + atual.getValor());
            anterior.setProximo(atual.getProximo());

           
            if (atual == inicio) {
                inicio = atual.getProximo();
            }
            
            if (atual == fim) {
                fim = anterior;
            }

            atual = anterior.getProximo(); 
        }

       
        return atual.getValor();
    }

    
    public listCircularController[] dividir() {
        listCircularController[] partes = new listCircularController[2];
        partes[0] = new listCircularController();
        partes[1] = new listCircularController();

        if (inicio == null || inicio.getProximo() == inicio) {
            
            No atual = inicio;
            if (atual != null) partes[0].adicionarFinal(atual.getValor());
            return partes;
        }

     
        No lento = inicio;
        No rapido = inicio;

        while (rapido.getProximo() != inicio && rapido.getProximo().getProximo() != inicio) {
            lento = lento.getProximo();
            rapido = rapido.getProximo().getProximo();
        }

       
        No meio = lento.getProximo();

      
        No atual = inicio;
        do {
            partes[0].adicionarFinal(atual.getValor());
            if (atual == lento) break;
            atual = atual.getProximo();
        } while (atual != inicio);

      
        atual = meio;
        do {
            partes[1].adicionarFinal(atual.getValor());
            atual = atual.getProximo();
        } while (atual != inicio);

        return partes;
    }
    
    
    public static listCircularController mesclarListasCirculares(listCircularController l1, listCircularController l2) {
        listCircularController resultado = new listCircularController();

       
        if (l1.inicio == null && l2.inicio == null) return resultado;

        
        if (l1.inicio != null) {
            No atual = l1.inicio;
            do {
                resultado.adicionarFinal(atual.getValor());
                atual = atual.getProximo();
            } while (atual != l1.inicio);
        }

       
        if (l2.inicio != null) {
            No atual = l2.inicio;
            do {
                resultado.adicionarFinal(atual.getValor());
                atual = atual.getProximo();
            } while (atual != l2.inicio);
        }

        return resultado;
    }


    public No encontrarInicioDoCiclo() {
        No lento = inicio;
        No rapido = inicio;

        
        while (rapido != null && rapido.getProximo() != null) {
            lento = lento.getProximo();
            rapido = rapido.getProximo().getProximo();

            if (lento == rapido) {
               
                No ponteiro = inicio;
                while (ponteiro != lento) {
                    ponteiro = ponteiro.getProximo();
                    lento = lento.getProximo();
                }
                return ponteiro; 
            }
        }

        return null; 
    }
    
    public void ordenar() {
        if (inicio == null || inicio.getProximo() == inicio) return; 

        No novaLista = null; 

        No atual = inicio;
        do {
            No proximo = atual.getProximo();
            atual.setProximo(null); 

            novaLista = inserirOrdenado(novaLista, atual);

            atual = proximo;
        } while (atual != inicio);

       
        No ultimo = novaLista;
        while (ultimo.getProximo() != null)
            ultimo = ultimo.getProximo();

        ultimo.setProximo(novaLista); // circular
        inicio = novaLista;
    }

   
    private No inserirOrdenado(No inicioOrdenado, No novo) {
        if (inicioOrdenado == null || novo.getValor() < inicioOrdenado.getValor()) {
            novo.setProximo(inicioOrdenado);
            return novo;
        }

        No atual = inicioOrdenado;
        while (atual.getProximo() != null && atual.getProximo().getValor() < novo.getValor()) {
            atual = atual.getProximo();
        }

        novo.setProximo(atual.getProximo());
        atual.setProximo(novo);
        return inicioOrdenado;
    }


    public void rotacionar(int k) {
        if (inicio == null || k <= 0) return;

        for (int i = 0; i < k; i++) {
            inicio = inicio.getProximo();
            fim = fim.getProximo();
        }
    }
   
}
