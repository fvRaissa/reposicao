package reposição.compara;

public class view {

	public static void main(String[] args) {
        int[] tamanhos = {1000, 5000, 10000};

        for (int tamanho : tamanhos) {
            System.out.println("\n--- Comparando com " + tamanho + " elementos ---");
            compara.compararAlgoritmos(tamanho);
        }
    }

}
