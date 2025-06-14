package reposição;
import java.util.Scanner;

public class ex5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] vetor = new int[5];

        System.out.println("Digite 5 números:");
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = in.nextInt();
        }

        if (estaCrescente(vetor)) {
            System.out.println("O vetor está em ordem crescente.");
        } else {
            System.out.println("O vetor NÃO está em ordem crescente.");
        }

        in.close();
    }

    static boolean estaCrescente(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i] > vetor[i + 1]) {
                return false; 
            }
        }
        return true;
    }
}
