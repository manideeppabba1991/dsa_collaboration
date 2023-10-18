/* Online Java Compiler and Editor */
public class SelectionSort{

     public static void main(String []args){
         int[] input = new int[]{10,3,8,9,5};
          selectionSort(input);
         for (int i = 0; i < input.length; i++)
            System.out.println("Element at index " + i
                               + " : " + input[i]);

     }
     
     public static int[] selectionSort(int[] input){
         
        for (int j=0;j<input.length-1;j++){
            int minimum = input[j];
            int minIndx = j;
            for(int i= j ; i < input.length-1 ;i++){
                if(minimum > input[i+1]){
                    minimum = input[i+1];
                    minIndx = i+1;
                }
            }
            input[minIndx] = input[j];
            input[j] = minimum;
        }
        return input;
     }
}
