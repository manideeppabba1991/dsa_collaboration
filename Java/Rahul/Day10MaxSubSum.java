//https://leetcode.com/problems/maximum-subarray/description/

public class MaxSubArray {

    public static void main(String[] args){
        int[] in = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int sumCurMax =in[0];
        int actaulMax =in[0];

        for(int i=1; i<in.length;i++){
            sumCurMax += in[i];
            sumCurMax= Math.max(sumCurMax,in[i]);
            actaulMax = Math.max(sumCurMax,actaulMax);

        }

        System.out.println(actaulMax);
    }

}

