//https://leetcode.com/problems/maximum-subarray/description/
//time = o(n)
//space = constant

public class MaxSubArray {

    public static void main(String[] args){
        int[] in = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(in));
    }

     public int maxSubArray(int[] in) {
        int sumCurMax =in[0];
        int actaulMax =in[0];

        for(int i=1; i<in.length;i++){
            sumCurMax += in[i];
            sumCurMax= Math.max(sumCurMax,in[i]);
            actaulMax = Math.max(sumCurMax,actaulMax);

        }
        return actaulMax;
    }

}

