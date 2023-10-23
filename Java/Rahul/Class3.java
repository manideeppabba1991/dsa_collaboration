import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Class3 {
    public static void  main(String args[]) throws Exception {
        int[] input = new int[]{1,4,5,3,2,6,7};
        int[] op = reverseStri(input);
        if (checkPalindrome("resser")) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }

    private static int[] twoSumBrute(int[] input, int k) throws Exception {

        for(int i=0;i<input.length;i++){
            for(int j= i+1;j< input.length;j++){
                if(k== input[i]+input[j]){
                    return new int[]{input[i],input[j]};
                }
            }
        }

        throw new Exception("not found");
    }

    private static int[] twoSum(int[] input, int k) throws Exception {

        Arrays.stream(input).sorted();
        for(int i: input){
            System.out.println("input"+i);
        }
        int left = 0;
        int right = input.length-1;

        while(left<right){
            if(k == input[left]+input[right]){
                return new int[]{input[left],input[right]};
            }else if(k < input[left]+input[right]){
                right = right-1;
            }else{
                left = left+1;
            }

        }
        throw new Exception("not found");

    }

    private static int[] twoSumMap(int[] input, int k) throws Exception {
        Map<Integer, Integer> op = new HashMap<>();

        for(int i =0;i<input.length;i++){
            if(op.containsKey(k-input[i])){
                return new int[]{input[i],input[op.get(k-input[i])]};
            }
            op.put(input[i],i);
        }
        throw new Exception("not found");
    }

    private static int[] reverseStri(int[] in)  {
        int left = 0;
        int right = in.length-1;

        while(left<= right){
            int temp = in[left];
            in[left] = in[right];
            in[right] = temp;
            left = left+1;
            right = right-1;
        }
        return in;
    }

    private static boolean checkPalindrome(String in){
        int left =0;
        int right = in.length()-1;
        while(left<= right){
            if(in.charAt(left) !=  in.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

}
