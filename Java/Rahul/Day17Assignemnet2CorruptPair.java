//https://thecodingsimplified.com/find-currupt-pair/
// TC O(n), SC = constant

import java.util.ArrayList;
import java.util.List;

public class MissingNDuplicate {
    
    public static void main(String[] args){
        int[] in = {4,1,4,3,5};
        for(int i: in){
            System.out.print(" "+i);
        }
        List<Integer> out= findMissingDuplicate(in);
        System.out.println("");
        for(int i: out){
            System.out.print(" "+i);
        }
    }

    private static List<Integer> findMissingDuplicate(int[] in) {
        int cur =0;
        List<Integer> pair = new ArrayList<>();
        while(cur< in.length){
            if(in[cur] == cur+1 || in[cur]>=in.length || in[cur] == in[in[cur]-1]){
                cur++;
                continue;
            }
            int temp = in[cur];
            in[cur] = in[temp-1];
            in[temp-1] = temp;
        }
      
        for(int i=0;i<in.length;i++){
            if(in[i] != i+1){
                pair.add(i+1);
                pair.add(in[i]);
            }
        }
        return  pair;
    }
}
