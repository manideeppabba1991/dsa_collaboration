//time complexity n2
//space complexity constant

public class BubbleSort{

     public static void main(String []args){
         int[] input = new int[]{10,3,8,9,5};
          bubbleSort( input);
         for (int i = 0; i < input.length; i++)
            System.out.println("Element at index " + i
                               + " : " + input[i]);

     }
     
     public static int[] bubbleSort(int[] input){
         
        int loop = input.length-1;
        while (loop>0){
            for(int i= 0 ; i< loop ;i++){
                if(input[i]> input[i+1]){
                    int temp = input[i];
                    input[i] = input[i+1];
                    input[i+1] = temp;
                }
            }
            loop--;
        }
        return input;
     }
}
