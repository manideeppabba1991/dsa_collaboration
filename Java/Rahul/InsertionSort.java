/* Online Java Compiler and Editor */
public class InsertionSort{

     public static void main(String []args){
         int[] input = new int[]{10,3,8,9,5};
          insertionSort(input);
         for (int i = 0; i < input.length; i++)
            System.out.println("Element at index " + i
                               + " : " + input[i]);

     }
     
     public static int[] insertionSort(int[] input){
         
        for (int j=1 ;j<input.length;j++){
            for(int i = j ; i > 0 ;i--){
                if(input[i] < input[i-1]){
                    int temp = input[i-1];
                    input[i-1] = input[i];
                    input[i] = temp;
                }
            }
        }
        return input;
     }
}
