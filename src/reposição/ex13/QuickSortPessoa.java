package reposição.ex13;

public class QuickSortPessoa {

	
	public static void main(String[] args) {
        Pessoa[] pessoas = {
            new Pessoa("Ana", 25),
            new Pessoa("Carlos", 20),
            new Pessoa("Beatriz", 30)
        };

        QuickSortPessoa.quickSort(pessoas, 0, pessoas.length - 1);

        for (Pessoa p : pessoas) {
            System.out.println(p.nome + " - " + p.idade);
        }
    }
	
    public static void quickSort(Pessoa[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivoIndex = particionar(vetor, inicio, fim);
            quickSort(vetor, inicio, pivoIndex - 1);
            quickSort(vetor, pivoIndex + 1, fim);
        }
    }

    private static int particionar(Pessoa[] vetor, int inicio, int fim) {
        Pessoa pivo = vetor[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (vetor[j].idade <= pivo.idade) {
                i++;
                Pessoa temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        Pessoa temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        return i + 1;
    }
}

