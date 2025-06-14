package reposição;

public class ex20 {

	public static void countingSort(int[] array) {
	    if (array.length == 0) return;
	    
	 
	    int max = array[0];
	    for (int num : array) {
	        if (num > max) {
	            max = num;
	        }
	    }
	    
	  
	    int[] count = new int[max + 1];
	    
	 
	    for (int num : array) {
	        count[num]++;
	    }
	    
	  
	    int index = 0;
	    for (int i = 0; i < count.length; i++) {
	        while (count[i] > 0) {
	            array[index++] = i;
	            count[i]--;
	        }
	    }
	}


	public static void main(String[] args) {
	    int[] vet = {4, 2, 2, 8, 3, 3, 1};
	    countingSort(vet);
	    for (int i : vet) {
	        System.out.print(i + " ");
	    }
	   
	}

}
