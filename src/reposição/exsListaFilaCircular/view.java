package reposição.exsListaFilaCircular;



public class view {
    public static void main(String[] args) {
        listCircularController lista = new listCircularController();

        lista.adicionarFinal(20);
        lista.adicionarFinal(10);
        lista.adicionarFinal(30);
        lista.adicionarFinal(40);

        lista.imprimir(); 

       
        lista.imprimir(); 

        lista.remover(40);
        lista.imprimir(); 

        if (lista.buscar(10) != null) {
            System.out.println("Valor 10 encontrado!");
        } else {
            System.out.println("Valor 10 não encontrado.");
        }
        
        System.out.println("É circular? " + lista.isCircular());
        
        
        
        //Josephus
        /*int n = lista.contarNos();
        for (int i = 1; i <= n; i++) {
            lista.adicionarFinal(i);
        }

        int k = 3; 
        int vencedor = lista.josephus(k);
        System.out.println("O vencedor é: " + vencedor);*/
        
        listCircularController[] divididas = lista.dividir();

        System.out.print("Primeira metade: ");
        divididas[0].imprimir();

        System.out.print("Segunda metade: ");
        divididas[1].imprimir();
        
        
        listCircularController l1 = new listCircularController();
        l1.adicionarFinal(1);
        l1.adicionarFinal(2);
        l1.adicionarFinal(3);

        listCircularController l2 = new listCircularController();
        l2.adicionarFinal(4);
        l2.adicionarFinal(5);
        listCircularController mesclada = listCircularController.mesclarListasCirculares(l1, l2);

        System.out.print("Lista mesclada: ");
        mesclada.imprimir();
        
        No inicioDoCiclo = lista.encontrarInicioDoCiclo();

        if (inicioDoCiclo != null) {
            System.out.println("Ciclo começa no nó com valor: " + inicioDoCiclo.getValor());
        } else {
            System.out.println("Nenhum ciclo encontrado.");
        }
        
        
        lista.ordenar();
        System.out.println("Depois da ordenação:");
        lista.imprimir();

        lista.rotacionar(2);
        lista.imprimir();
        
        
        filaCircularController fila = new filaCircularController();

        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.enfileirar(30);
        fila.imprimir();  

        System.out.println("Removido: " + fila.desenfileirar()); 
        fila.imprimir();  

        fila.enfileirar(40);
        fila.imprimir();  
    }
}
