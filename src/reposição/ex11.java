package reposição;

import java.util.Scanner;

public class ex11 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] vet = new int[5];

		for (int i = 0; i < vet.length; i++) {
			System.out.print("Digite o " + (i + 1) + "º número: ");
			vet[i] = in.nextInt();
		}
		System.out.print("Array original: ");
		for (int v : vet) {
			System.out.print(v + " ");
		}

		bubbleSort(vet);

		System.out.print("\nArray ordenado: ");
		for (int v : vet) {
			System.out.print(v + " ");
		}
	}

	public static void bubbleSort(int[] array) {
		int n = array.length;
		boolean trocou;

		for (int i = 0; i < n - 1; i++) {
			trocou = false;

			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {

					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					trocou = true;
				}
			}

			if (!trocou)
				break;
		}
	}
}
