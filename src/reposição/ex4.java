package reposição;
public class ex4 {
	
	 public static void main(String[] args) {
	        int[] vetor = {4, 5, 2, 4, 2, 3, 5, 1};
	        int[] semDuplicatas = removerDuplicados(vetor);

	        for (int valor : semDuplicatas) {
	            System.out.print(valor + " ");
	        }
	        
	    }
	 
	 
    public static int[] removerDuplicados(int[] vetor) {
        int n = vetor.length;
        int[] temp = new int[n];
        int novoTamanho = 0;

        for (int i = 0; i < n; i++) {
            boolean duplicado = false;
            for (int j = 0; j < novoTamanho; j++) {
                if (vetor[i] == temp[j]) {
                    duplicado = true;
                    break;
                }
            }
            if (!duplicado) {
                temp[novoTamanho++] = vetor[i];
            }
        }

       
        int[] resultado = new int[novoTamanho];
        for (int i = 0; i < novoTamanho; i++) {
            resultado[i] = temp[i];
        }

        return resultado;
    }

   
}
