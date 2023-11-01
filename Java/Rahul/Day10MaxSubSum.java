//https://leetcode.com/problems/maximum-subarray/description/

public class MaxSubArray {

    public static void main(String[] args){
        int[] in = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int previousMax =0;
        int sum =0;
        int max =0;
        //Stack<Integer> res = new Stack<>();

        for(int i=0; i<in.length;i++){
            sum += in[i];
            if(sum>max)
                max = sum;
            if(in[i]>max)
                max = in[i];
        }

        System.out.println(max);
    }

}

