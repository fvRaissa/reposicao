package reposição.exsListaDupla;

import java.util.Iterator;

public class encadDuplaController implements Iterable<Integer>{
	private No inicio = null;
	private No fim = null;

	public void inserirInicio(int valor) {
		No novoNo = new No(valor);

		if (inicio == null) {
			inicio = fim = novoNo;
		} else {
			novoNo.setProximo(inicio);
			inicio.setAnterior(novoNo);
			novoNo.setAnterior(null);
			inicio = novoNo;
		}

	}

	public void inserirFinal(int valor) {
		No novoNo = new No(valor);
		if (inicio == null) {
			inicio = fim = novoNo;
		} else {
			fim.setProximo(novoNo);
			novoNo.setAnterior(fim);
			fim = novoNo;
		}

	}

	public void remover(int valor) {
		No atual = inicio;

		while (atual != null) {
			if (atual.getValor() == valor) {
				if (atual.getAnterior() != null) {
					atual.getAnterior().setProximo(atual.getProximo());
				} else {
					inicio = atual.getProximo();
					if (inicio != null) {
						inicio.setAnterior(null);
					}
				}

				if (atual.getProximo() != null) {
					atual.getProximo().setAnterior(atual.getAnterior());
				} else {
					fim = atual.getAnterior();
				}
				return;
			}
			atual = atual.getProximo();
		}

	}

	public void exibir() {
		No atual = inicio;

		while (atual != null) {
			System.out.print(atual.getValor() + " -> ");
			atual = atual.getProximo();
		}

		System.out.print("null");
	}

	public void exibirReverse() {
		No atual = fim;

		while (atual != null) {
			System.out.print(atual.getValor() + " -> ");
			atual = atual.getAnterior();
		}

		System.out.print("null");
	}

	void inserirEm(int posicao, int dado) {
		if (posicao == 0) {
			No novoNo = new No(dado);
			novoNo.setProximo(inicio);

			if (inicio != null)
				inicio.setAnterior(novoNo);

			inicio = novoNo;

			if (fim == null)
				fim = novoNo;

			return;
		}

		No atual = inicio;
		int contador = 0;

		while (atual != null && contador < posicao) {
			atual = atual.getProximo();
			contador++;
		}

		if (atual == null) {

			inserirFinal(dado);
		} else {

			No novoNo = new No(dado);
			novoNo.setAnterior(atual.getAnterior());
			novoNo.setProximo(atual);

			atual.getAnterior().setProximo(novoNo);
			atual.setAnterior(novoNo);
		}
	}

	public No buscar(int valor) {
		No atual = inicio;
		while (atual != null) {
			if (atual.getValor() == valor) {
				return atual;
			}
			atual = atual.getProximo();
		}
		return null;
	}
	
	public static encadDuplaController mesclarListasOrdenadas(encadDuplaController l1, encadDuplaController l2) {
	    encadDuplaController resultado = new encadDuplaController();

	    No atual1 = l1.inicio;
	    No atual2 = l2.inicio;

	    while (atual1 != null && atual2 != null) {
	        if (atual1.getValor() <= atual2.getValor()) {
	            resultado.inserirFinal(atual1.getValor());
	            atual1 = atual1.getProximo();
	        } else {
	            resultado.inserirFinal(atual2.getValor());
	            atual2 = atual2.getProximo();
	        }
	    }

	    // Adiciona os elementos restantes da lista 1
	    while (atual1 != null) {
	        resultado.inserirFinal(atual1.getValor());
	        atual1 = atual1.getProximo();
	    }

	    // Adiciona os elementos restantes da lista 2
	    while (atual2 != null) {
	        resultado.inserirFinal(atual2.getValor());
	        atual2 = atual2.getProximo();
	    }

	    return resultado;
	}
	
	public static encadDuplaController criarListaDeVetor(int[] vetor) {
	    encadDuplaController lista = new encadDuplaController();

	    for (int valor : vetor) {
	        lista.inserirFinal(valor); // Adiciona os valores do vetor na lista
	    }

	    return lista;
	}

	public int[] toArray() {
	    
	    int tamanho = 0;
	    No atual = inicio;
	    while (atual != null) {
	        tamanho++;
	        atual = atual.getProximo();
	    }

	   
	    int[] vetor = new int[tamanho];

	   
	    atual = inicio;
	    int i = 0;
	    while (atual != null) {
	        vetor[i] = atual.getValor();
	        atual = atual.getProximo();
	        i++;
	    }

	    return vetor;
	}

	public void removerDuplicatas() {
	    No atual = inicio;

	    while (atual != null) {
	        No comparador = atual.getProximo();
	        while (comparador != null) {
	            if (comparador.getValor() == atual.getValor()) {
	                
	                if (comparador.getAnterior() != null) {
	                    comparador.getAnterior().setProximo(comparador.getProximo());
	                }
	                if (comparador.getProximo() != null) {
	                    comparador.getProximo().setAnterior(comparador.getAnterior());
	                }

	                
	                if (comparador == fim) {
	                    fim = comparador.getAnterior();
	                }
	            }
	            comparador = comparador.getProximo();
	        }
	        atual = atual.getProximo();
	    }
	}


	public Iterator<Integer> iterator() {
	    return new ListaIterator();
	}

	private class ListaIterator implements Iterator<Integer> {
	    private No atual = inicio;

	    @Override
	    public boolean hasNext() {
	        return atual != null;
	    }

	    @Override
	    public Integer next() {
	        int valor = atual.getValor();
	        atual = atual.getProximo();
	        return valor;
	    }
	}
	
	public Iterator<Integer> reverseIterator() {
	    return new ReverseIterator();
	}

	private class ReverseIterator implements Iterator<Integer> {
	    private No atual = fim;

	    @Override
	    public boolean hasNext() {
	        return atual != null;
	    }

	    @Override
	    public Integer next() {
	        int valor = atual.getValor();
	        atual = atual.getAnterior();
	        return valor;
	    }
	}
	
	//43
	public void tornarCircular() {
		if (inicio == null) return;  
		    
		fim.setProximo(inicio);  
	}

	
}
