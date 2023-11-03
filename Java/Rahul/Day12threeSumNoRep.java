//Tc = O(n^2)
//space = constant


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumNonRepeat {

    public static void main(String[] args){
        int[] in ={1,1,1,1,1,1};
        //[[-1, 0, 5], [-2, 2, 4], [-1, 2, 3], [0, 2, 2]]
        //[[-2, 2, 4], [-1, 0, 5], [-1, 2, 3], [0, 2, 2], [0, 2, 2]]
        int target =3;
        List<List<Integer>> opt = threeSum(in, target);
        System.out.println(opt);
    }

    private static List<List<Integer>> threeSum(int[] in, int target) {
        Arrays.sort(in); // nlog(n) 
        List<List<Integer>> opt=new ArrayList<>();
        //iterating through
        for(int i = 0; i< in.length-2; i++){//n2
            if(i!=0 && in[i] == in[i-1])continue;

            opt.addAll(twoSum(in,i+1, target - in[i], in[i])); // n
        }
        return opt;
    }

    private static List<List<Integer>> twoSum(int[] in,int left, int target,int value) {
        int right = in.length-1;

        List<List<Integer>> opt = new ArrayList<>();

        while(left<right){
            if(in[left]+ in[right]== target){
                List<Integer> op = new ArrayList<>();
                op.add(value);
                op.add(in[left]);
                op.add(in[right]);
                opt.add(op);
              
                while(left<right && in[left] ==in[left+1])
                    left++;
                while(left<right && in[right] == in[right-1])
                    right--;

                left++;
                right--;
            }else if(in[left]+ in[right]< target){
                left++;
            }else{
                right--;
            }
        }
        return opt;
    }
}
