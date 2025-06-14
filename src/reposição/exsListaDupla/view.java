package reposição.exsListaDupla;

import java.util.Iterator;

public class view {

	public static void main(String[] args) {
		encadDuplaController encad = new encadDuplaController();
		
		encad.inserirInicio(2);
		encad.inserirInicio(1);
		encad.inserirInicio(3);
		
		encad.exibir();
		
		encad.inserirInicio(0);
		System.out.println(" ");
		encad.exibir();
		
		System.out.println(" ");
		
		encad.inserirFinal(4);
		encad.exibir();
		
		System.out.println(" ");
		encad.remover(1);
		encad.exibir();
		System.out.println(" ");
		encad.exibirReverse();
		
		System.out.println(" ");
		No resultado = encad.buscar(3);
		if (resultado != null) {
		    System.out.println("Valor encontrado: " + resultado.getValor());
		} else {
		    System.out.println("Valor não encontrado.");
		}

		
		encadDuplaController l1 = new encadDuplaController();
	    l1.inserirFinal(1);
	    l1.inserirFinal(3);
	    l1.inserirFinal(5);

	    encadDuplaController l2 = new encadDuplaController();
	    l2.inserirFinal(2);
	    l2.inserirFinal(4);
	    l2.inserirFinal(6);

	    encadDuplaController resultado2 = encadDuplaController.mesclarListasOrdenadas(l1, l2);

	    resultado2.exibir();
	    
	    int[] vetor = {10, 20, 30, 40};

	    System.out.println("\nCriando lista a partir do vetor:");
	    encadDuplaController listaCriada = encadDuplaController.criarListaDeVetor(vetor);
	    listaCriada.exibir();

	    System.out.println("\nConvertendo lista para vetor:");
	    int[] vetorConvertido = encad.toArray();
	    System.out.print("Vetor: ");
	    for (int v : vetorConvertido) {
	        System.out.print(v + " ");
	    }
	    System.out.println();

	    
	    System.out.println("\nLista antes de remover duplicatas:");
	    encad.exibir();

	    encad.removerDuplicatas();

	    System.out.println("\nLista depois de remover duplicatas:");
	    encad.exibir();

	    
	    System.out.println("Percorrendo do início ao fim:");
	    for (int val : encad) {
	        System.out.println(val);
	    }

	    System.out.println("Percorrendo do fim ao início:");
	    Iterator<Integer> it = encad.reverseIterator();
	    while (it.hasNext()) {
	        System.out.println(it.next());
	    }

	}

}
