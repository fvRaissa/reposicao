package reposição;
import java.util.Scanner;
public class ex8 {
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[] v1 = new int[5];
		int[] v2 = new int[5];
		
		for(int i = 0; i < v1.length; i++) {
			System.out.println("Digite o "+(i+1) +"° num");
			v1[i] = in.nextInt();
		}
		
		for(int i = 0; i < v2.length; i++) {
			System.out.println("Digite o "+(i+1) +"° num");
			v2[i] = in.nextInt();
		}
		
		
		junta(v1, v2);
		
	}
	
	 static void junta(int []v1, int[] v2) {
		int cont = 0, dif = 0;
		int sum = v1.length + v2.length;
		int [] vet = new int[sum];
		
        for(int i = 0; i < v1.length; i++ ) {
            vet[cont] = v1[i]; 
            cont++;
        }

       
        for(int i = 0; i < v2.length; i++ ) {
            boolean repetido = false;

            for(int j = 0; j < cont; j++) {
                if (v2[i] == vet[j]) {
                    repetido = true;
                    break;
                }
            }

            if(!repetido) {
                vet[cont] = v2[i]; 
                cont++;
            }
        }
		for(int i = 0; i < cont; i ++) {
			System.out.print(vet[i]+" ");
		}
		
	}
	
}
