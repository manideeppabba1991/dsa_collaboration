public class Swap {
    public static void main(String[] args){
        int[] in = {1,2,3,4,5,6,7};
        swapIndices(in, 0,4);
    }

    private static int[] swapIndices(int[] in, int i, int i1) {
        int temp = in[i1];
        in[i1] = in[i];
        in[i] = temp;
        return in;
    }

    private static void swapVal(int i, int i1) {
        int temp = i1;
        i1 = i;
        i = temp;
    }
    private static int[] swapVariable(int[] in, int i, int i1) {
        int indx1=-1 ;
        int indx2=-1;
        for(int j=0;j<in.length;j++){
            if(in[j] == i || in[j]==i1){
                if(in[j] == i){
                    indx1 = j;
                }else{
                    indx2= i;
                }
            }
        }
        int temp = in[indx1];
        in[indx1] = in[indx2];
        in[indx2] = temp;
        return in;
    }



}
