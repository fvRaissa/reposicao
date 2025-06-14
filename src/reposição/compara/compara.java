package reposição.compara;
import java.util.Arrays;
import java.util.Random;

public class compara {


    public static int[] gerarArrayOrdenado(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = i;
        }
        return array;
    }

   
    public static int[] gerarArrayInvertido(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = tamanho - i;
        }
        return array;
    }

   
    public static int[] gerarArrayAleatorio(int tamanho) {
        int[] array = new int[tamanho];
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            array[i] = rand.nextInt(tamanho);
        }
        return array;
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
            if (!trocou) break;
        }
    }

    
    public static void quickSort(int[] array, int esquerda, int direita) {
        if (esquerda < direita) {
            int pivo = array[(esquerda + direita) / 2];
            int i = esquerda;
            int j = direita;
            while (i <= j) {
                while (array[i] < pivo) i++;
                while (array[j] > pivo) j--;
                if (i <= j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }
            if (esquerda < j) quickSort(array, esquerda, j);
            if (i < direita) quickSort(array, i, direita);
        }
    }

   
    public static void mergeSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(array, inicio, meio);
            mergeSort(array, meio + 1, fim);
            merge(array, inicio, meio, fim);
        }
    }

    public static void merge(int[] array, int inicio, int meio, int fim) {
        int[] temp = new int[fim - inicio + 1];
        int i = inicio, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) {
            if (array[i] <= array[j]) temp[k++] = array[i++];
            else temp[k++] = array[j++];
        }
        while (i <= meio) temp[k++] = array[i++];
        while (j <= fim) temp[k++] = array[j++];
        System.arraycopy(temp, 0, array, inicio, temp.length);
    }

    
    public static void compararAlgoritmos(int tamanho) {
        int[] original = gerarArrayAleatorio(tamanho);

        int[] array1 = Arrays.copyOf(original, original.length);
        int[] array2 = Arrays.copyOf(original, original.length);
        int[] array3 = Arrays.copyOf(original, original.length);

        long inicio, fim;

        
        inicio = System.nanoTime();
        bubbleSort(array1);
        fim = System.nanoTime();
        System.out.println("Bubble Sort: " + (fim - inicio) + " ns");

        
        inicio = System.nanoTime();
        quickSort(array2, 0, array2.length - 1);
        fim = System.nanoTime();
        System.out.println("Quick Sort: " + (fim - inicio) + " ns");

        
        inicio = System.nanoTime();
        mergeSort(array3, 0, array3.length - 1);
        fim = System.nanoTime();
        System.out.println("Merge Sort: " + (fim - inicio) + " ns");
    }

    
}

