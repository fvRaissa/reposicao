package reposição.ex16;

public class MergeSortPessoa {

    public static void mergeSort(Pessoa[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
    }

    private static void merge(Pessoa[] vetor, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        Pessoa[] esquerda = new Pessoa[n1];
        Pessoa[] direita = new Pessoa[n2];

        for (int i = 0; i < n1; i++) {
            esquerda[i] = vetor[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            direita[j] = vetor[meio + 1 + j];
        }

        int i = 0, j = 0;
        int k = inicio;

        while (i < n1 && j < n2) {
            if (esquerda[i].idade <= direita[j].idade) {
                vetor[k] = esquerda[i];
                i++;
            } else {
                vetor[k] = direita[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            vetor[k] = esquerda[i];
            i++;
            k++;
        }

        while (j < n2) {
            vetor[k] = direita[j];
            j++;
            k++;
        }
    }
    
    
    public static void main(String[] args) {
        Pessoa[] pessoas = {
            new Pessoa("Ana", 25),
            new Pessoa("Carlos", 20),
            new Pessoa("Beatriz", 30),
            new Pessoa("Daniel", 22)
        };

        MergeSortPessoa.mergeSort(pessoas, 0, pessoas.length - 1);

        for (Pessoa p : pessoas) {
            System.out.println(p.nome + " - " + p.idade);
        }
    }
}

