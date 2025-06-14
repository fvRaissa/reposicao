package reposição;
import java.util.Scanner;
public class ex7 {
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[] v = new int[5];
		
		for(int i = 0; i < v.length; i++) {
			System.out.println("Digite o "+i+1 +"° num");
			v[i] = in.nextInt();
		}
		
		System.out.println("Digite o valor q deseja verificar");
		int valor = in.nextInt();
		
		cont(v, valor);
		
	}
	
	 static void cont(int []vet, int valor) {
		int cont = 0;
		
		
		for(int i = 0; i < vet.length; i++ ) {
			if(vet[i] == valor) {
				cont ++;
			}
			
		}
		
		System.out.println("Quantidade de vezes que aparece:"+cont);
	}
	
}
