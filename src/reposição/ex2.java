package reposição;
import java.util.Scanner;
public class ex2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] v = new int[5];
		
		for(int i = 0; i < v.length; i++) {
			System.out.println("Digite o "+i+1 +"° num");
			v[i] = in.nextInt();
		}
		
		inverte(v);
		
	}
	 static void inverte(int []vet) {
		
		int m = vet.length / 2;
		int temp;
		for (int i = 0; i < m; i++) {
		    temp = vet[i];
		    vet[i] = vet[vet.length - 1 - i];
		    vet[vet.length - 1 - i] = temp;
		}
		
		for(int i = 0; i < vet.length; i ++) {
			System.out.println(vet[i] +" ");
		}
	}
}
