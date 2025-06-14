package reposição;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] vetor = new int[6];
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            vetor[i] = in.nextInt();
        }

        divideParesImpares(vetor);
    }

    static void divideParesImpares(int[] vetor) {
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();

        for (int num : vetor) {
            if (num % 2 == 0) {
                pares.add(num);
            } else {
                impares.add(num);
            }
        }

        System.out.println("\nPares: " + pares);
        System.out.println("Ímpares: " + impares);
    }
}
