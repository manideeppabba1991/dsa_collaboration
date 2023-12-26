
class Solution {
    public int[][] intervalIntersection(int[][] intervalA, int[][] intervalB) {
        int left =0;
        int right =0;
        List<int[]> out = new ArrayList<>();

        while(left <intervalA.length && right< intervalB.length){
            int[] leftInterval = intervalA[left];
            int[] rightInterval = intervalB[right];
            int[] temp = new int[2];
            if( leftInterval[0] <= rightInterval[1] && rightInterval[0]<= leftInterval[1]){
                temp[0] = Math.max(leftInterval[0],rightInterval[0]);
                temp[1] = Math.min(leftInterval[1],rightInterval[1]);
                out.add(temp);
                if(leftInterval[1]>=rightInterval[1])
                    right++;
                else
                    left++;

            } else  {
                if(leftInterval[1]>=rightInterval[1])
                    right++;
                else
                    left++;
            }
        }

        return out.toArray(new int[out.size()][]);
    }
}
