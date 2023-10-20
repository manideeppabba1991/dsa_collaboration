import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Online Java Compiler and Editor */
public class ProductRecursionArray{

     public static void main(String []args){
         int[] input1 = new int[]{1,3,5};
         
         List<Integer> out = flatObject(input);
         for(Integer i: out){
             System.out.println("out array"+out[i]);
         }

          
     }
     
     public static List<Integer> flatObject (Object input){
        List<Integer> output = new ArrayList<Integer>();
         for(int i=0;i< input.length();i++){
             if( input[i] instanceof Integer) {
                 output.add(input[i]);
             }else{
                 output.addAll(flatObject(input[i]));
                 
             }
         }
         return output;
         
     }
     
     public static Boolean palindromeRecur (String input){
         System.out.println(" value:"+ input);
         if(input.length()==1){
             return true;
         }
         if(input.length()==2 && input.charAt(0) == input.charAt(input.length()-1)){
             return true;
         }
         if(input.charAt(0) != input.charAt(input.length()-1)){
             return false;
         }
         
         return (input.charAt(0) == input.charAt(input.length()-1)) 
         && palindromeRecur(input.substring(1,input.length()-1));

         
     }
     
   
}
