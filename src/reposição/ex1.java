package reposição;
import java.util.Scanner;
public class ex1 {
	//Maior e menor em um vetor
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[] v = new int[5];
		
		for(int i = 0; i < v.length; i++) {
			System.out.println("Digite o "+i+1 +"° num");
			v[i] = in.nextInt();
		}
		
		maiorMenor(v);
		
	}
	
	 static void maiorMenor(int []vet) {
		int maior = vet[0], menor = vet[0];
		
		for(int i = 0; i < vet.length; i++ ) {
			if(vet[i] > maior) {
				maior = vet[i];
			}
			if(vet[i]< menor) {
				menor = vet[i];
			}
		}
		System.out.println("Maior:"+maior);
		System.out.println("Menor:"+menor);
	}
	
}
