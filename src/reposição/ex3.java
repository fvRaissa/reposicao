package reposição;
import java.util.Scanner;
public class ex3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] v = new int[5];
		
		for(int i = 0; i < v.length; i++) {
			System.out.println("Digite o "+i+1 +"° num");
			v[i] = in.nextInt();
		}
		
		media(v);
		
	}
	 static void media(int []vet) {
		
		int m, r = 0;
		for (int i = 0; i < vet.length; i++) {
		    r = r +vet[i];
		}
		
		m = r/vet.length;
		
			System.out.println("media: "+m);
		
	}
}
