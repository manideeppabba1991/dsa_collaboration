/*
  time complexity = n or n^2, i believe it is n, but i doubt due to recursion inside for
  space = n;
  first i didn't get an idea to use object, I spent more time on setting the input to int [] and unable to figure that out, 
  later i tried to get some additional help and got the idea of using object, and then was able to get it going.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Online Java Compiler and Editor */
public class FlatObject{

     public static void main(String []args){
         Object[] input = {1, 2, 3, new Object[]{4, new Object[]{5, new Object[]{6}}}, 7};
         
         List<Integer> out = flatObject(input);
         System.out.println(out);
     }
     
     public static List<Integer> flatObject (Object[] input){
        List<Integer> output = new ArrayList<Integer>();
         for(Object i: input){
             if( i instanceof Integer) {
                 output.add((Integer)i);
             }else{
                 output.addAll(flatObject((Object[]) i));
             }
         }
         return output;
         
     } 
}
