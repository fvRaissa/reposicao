package reposição;

import java.util.Scanner;

public class ex9 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] v1 = new int[5];
        int[] v2 = new int[5];

        for(int i = 0; i < v1.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º número do vetor 1: ");
            v1[i] = in.nextInt();
        }

        for(int i = 0; i < v2.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º número do vetor 2: ");
            v2[i] = in.nextInt();
        }

        interseccao(v1, v2);
        in.close();
    }

    static void interseccao(int[] v1, int[] v2) {
        int[] inter = new int[Math.min(v1.length, v2.length)];
        int cont = 0;

        for(int i = 0; i < v1.length; i++) {
            for(int j = 0; j < v2.length; j++) {
                if(v1[i] == v2[j]) {
                   
                    boolean jaExiste = false;
                    for(int k = 0; k < cont; k++) {
                        if(inter[k] == v1[i]) {
                            jaExiste = true;
                            break;
                        }
                    }
                    if(!jaExiste) {
                        inter[cont] = v1[i];
                        cont++;
                    }
                }
            }
        }

       
        System.out.println("\nInterseção entre os vetores:");
        if (cont == 0) {
            System.out.println("Nenhum elemento em comum.");
        } else {
            for(int i = 0; i < cont; i++) {
                System.out.print(inter[i] + " ");
            }
            System.out.println();
        }
    }
}

