package reposição;

public class ex15 {
	 public static void main(String[] args) {
	        int[] array = {38, 27, 43, 3, 9, 82, 10};
	        System.out.println("Array original:");
	        imprimirArray(array);

	        mergeSort(array, 0, array.length - 1);

	        System.out.println("Array ordenado:");
	        imprimirArray(array);
	    }
	 
	 public static void mergeSort(int[] array, int inicio, int fim) {
	        if (inicio < fim) {
	            int meio = (inicio + fim) / 2;

	         
	            mergeSort(array, inicio, meio);

	        
	            mergeSort(array, meio + 1, fim);

	    
	            merge(array, inicio, meio, fim);
	        }
	    }

	   
	    public static void merge(int[] array, int inicio, int meio, int fim) {
	        int n1 = meio - inicio + 1;
	        int n2 = fim - meio;

	        int[] esquerda = new int[n1];
	        int[] direita = new int[n2];

	    
	        for (int i = 0; i < n1; i++)
	            esquerda[i] = array[inicio + i];
	        for (int j = 0; j < n2; j++)
	            direita[j] = array[meio + 1 + j];

	        int i = 0, j = 0;
	        int k = inicio;

	    
	        while (i < n1 && j < n2) {
	            if (esquerda[i] <= direita[j]) {
	                array[k] = esquerda[i];
	                i++;
	            } else {
	                array[k] = direita[j];
	                j++;
	            }
	            k++;
	        }

	    
	        while (i < n1) {
	            array[k] = esquerda[i];
	            i++;
	            k++;
	        }

	        while (j < n2) {
	            array[k] = direita[j];
	            j++;
	            k++;
	        }
	    }

	
	    public static void imprimirArray(int[] array) {
	        for (int i : array)
	            System.out.print(i + " ");
	        System.out.println();
	    }
}
