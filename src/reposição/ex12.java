package reposição;

import java.util.Scanner;

public class ex12 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] vet = new String[5];

		for (int i = 0; i < vet.length; i++) {
			System.out.print("Digite o " + (i + 1) + "º nome: ");
			vet[i] = in.next();
		}
		System.out.print("Array original: ");
		for (String v : vet) {
			System.out.print(v + " ");
		}

		bubbleSort(vet);

		System.out.print("\nArray ordenado: ");
		for (String v : vet) {
			System.out.print(v + " ");
		}
	}

	public static void bubbleSort(String[] array) {
		int n = array.length;
		boolean trocou;

		for (int i = 0; i < n - 1; i++) {
			trocou = false;

			for (int j = 0; j < n - i - 1; j++) {
				
				if (array[j].compareTo(array[j + 1]) > 0) {
					String temp = array[j];
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
