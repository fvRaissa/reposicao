package reposição;

public class ex14 {
	 public static void main(String[] args) {
	        double[] numeros = { 3.5, 2.1, 4.8, 1.0, 2.9 };

	        quickSort(numeros, 0, numeros.length - 1);

	        for (double n : numeros) {
	            System.out.print(n + " ");
	        }
	    }
	 
	 public static void quickSort(double[] vetor, int inicio, int fim) {
	        if (inicio < fim) {
	            int pivoIndex = particionar(vetor, inicio, fim);
	            quickSort(vetor, inicio, pivoIndex - 1);
	            quickSort(vetor, pivoIndex + 1, fim);
	        }
	    }

	    private static int particionar(double[] vetor, int inicio, int fim) {
	        double pivo = vetor[fim];
	        int i = inicio - 1;

	        for (int j = inicio; j < fim; j++) {
	            if (vetor[j] <= pivo) {
	                i++;
	                double temp = vetor[i];
	                vetor[i] = vetor[j];
	                vetor[j] = temp;
	            }
	        }

	        double temp = vetor[i + 1];
	        vetor[i + 1] = vetor[fim];
	        vetor[fim] = temp;

	        return i + 1;
	    }
}
