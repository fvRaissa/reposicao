package reposição.exsListaEncadeada;
import java.util.Objects;
import java.util.Stack;



public class encadSimplesController<T> {
	private nó<T> inicio = null;
	
	
	public encadSimplesController() {
		this.inicio = null;
	}
	
	//para testar o ciclo
	public void setInicio(nó<T> inicio) {
	    this.inicio = inicio;
	}
	
	//ex21
	public void inserirInicio(int valor) {
		nó<T> novoNo = new nó<>(valor);
		novoNo.setProximo(inicio);
		inicio = novoNo;
	}
	
	
	public void inserirNoFinal(int valor){
		nó<T> novoNo = new nó<>(valor);
		if (inicio == null) {
			inicio = novoNo;
		}else {
			nó <T>atual = inicio;
			while (atual.getProximo() != null) {
				atual = atual.getProximo();
			}
			atual.setProximo(novoNo);
		}
	}
	
	public void inserirNaPosicao(int valor, int posicao) {
	    nó<T> novo = new nó<>(valor);
	    if (posicao <= 0 || inicio == null) {
	        novo.setProximo(inicio);
	        inicio = novo;
	        return;
	    }
	    nó<T> atual = inicio;
	    for (int i = 0; i < posicao - 1 && atual.getProximo() != null; i++) {
	        atual = atual.getProximo();
	    }
	    novo.setProximo(atual.getProximo());
	    atual.setProximo(novo);
	}
	
	//ex22
	public boolean remove(int valor) {
		nó<T> atual = inicio;
		nó<T> anterior = null;
		
		while (atual != null && atual.getValor() != valor) {
			anterior = atual;
			atual = atual.getProximo();
		}
		
		if (atual == null) {
			return false;
		}
		
		if (anterior == null) {
			inicio = atual.getProximo();
		}else {
			anterior.setProximo(atual.getProximo());
		}
		
		return true;
	}
	
	//23
	public void inverte () {
		nó<T> ant = null;
		nó<T> seg;
		nó<T> atual = inicio;
		
		while (atual != null) {
			
			seg = atual.getProximo();
			atual.setProximo(ant);
			ant = atual;
			atual = seg;
			
		}
		inicio = ant;
		
	}
	
	//ex24
	public nó<T> encontrarMeio() {
	    if (inicio == null) return null;

	    nó<T> lento = inicio;
	    nó<T> rapido = inicio;

	    while (rapido != null && rapido.getProximo() != null) {
	        lento = lento.getProximo();
	        rapido = rapido.getProximo().getProximo();
	    }

	    return lento;
	}
	
	//25
	public boolean ciclo() {
		nó<T> aux = inicio;
		if (aux == null) return false;
		
		nó<T> lento = aux;
		nó<T> rapido = aux.getProximo();
		
		while (rapido != null && rapido.getProximo() != null) {
			if (rapido == lento) {
				return true;
			}
			lento = lento.getProximo();
			rapido = rapido.getProximo().getProximo();
			
		}
		return false;
	}
	
	//ex26

	//ex27
	public void removerDuplicatas() {
	    nó<T> atual = inicio;

	    while (atual != null) {
	        nó<T> anterior = atual;
	        nó<T> comparador = atual.getProximo();

	        while (comparador != null) {
	        	if (Objects.equals(atual.getValor(), comparador.getValor())) {
	                anterior.setProximo(comparador.getProximo());
	            } else {
	                anterior = comparador;
	            }
	            comparador = comparador.getProximo();
	        }

	        atual = atual.getProximo();
	    }
	}
	
	//ex28
	public nó<T> nAposFim(int n) {
	    nó<T> lento = inicio;
	    nó<T> rapido = inicio;

	    for (int i = 0; i < n; i++) {
	        if (rapido == null) return null;
	        rapido = rapido.getProximo();
	    }

	    while (rapido != null) {
	        lento = lento.getProximo();
	        rapido = rapido.getProximo();
	    }

	    return lento;
	}

	//ex29
	public encadSimplesController<T> dividirEmDuas() {
	    if (inicio == null || inicio.getProximo() == null) return null;

	    nó<T> lento = inicio;
	    nó<T> rapido = inicio;
	    nó<T> anterior = null;

	    while (rapido != null && rapido.getProximo() != null) {
	        anterior = lento;
	        lento = lento.getProximo();
	        rapido = rapido.getProximo().getProximo();
	    }

	    anterior.setProximo(null);

	    encadSimplesController<T> novaLista = new encadSimplesController<>();
	    novaLista.setInicio(lento);
	    return novaLista;
	}

	//ex30
	

	//ex43
	public void tornarCircular() {
	    if (inicio == null) return;

	    nó<T> atual = inicio;
	    while (atual.getProximo() != null) {
	        atual = atual.getProximo();
	    }
	    
	    atual.setProximo(inicio);
	}



	/*public void exibir() {
		nó atual = inicio;
		
		while (atual != null) {
			System.out.print(atual.getValor() + " -> ");
			atual = atual.getProximo();
		}
		
		System.out.print("null");
	}*/
	
	public void exibir() {
	    nó atual = inicio;
	    int contador = 0;
	    int limite = 20;

	    while (atual != null && contador < limite) {
	        System.out.print(atual.getValor() + " -> ");
	        atual = atual.getProximo();
	        contador++;
	    }

	    if (contador == limite) {
	        System.out.print("... (possível ciclo detectado)");
	    } else {
	        System.out.print("null");
	    }

	    System.out.println();
	}

}
