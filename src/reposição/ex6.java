package reposição;
import java.util.Scanner;
public class ex6 {
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[] v = new int[5];
		
		for(int i = 0; i < v.length; i++) {
			System.out.println("Digite o "+i+1 +"° num");
			v[i] = in.nextInt();
		}
		
		segMenor(v);
	
	}
	
	 static void segMenor(int []vet) {
		int maior = vet[0], segMaior = vet[0];
		
		for(int i = 0; i < vet.length; i++ ) {
			if(vet[i] > maior) {
				maior = vet[i];	
			}
		}
		for(int j = 0; j < vet.length; j++ ) {
			if(vet[j] > segMaior && vet[j] < maior) {
				segMaior = vet[j];	
			}
		}
		
		System.out.println("Segundo maior:"+segMaior);
	}
		
}
