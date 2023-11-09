public class CyclicSort {

    public static void main(String[] args){
        int[] in = {2,1,4,3,3,5};

        for(int i: in){
            System.out.print(" "+i);
        }
        cyclicSort(in);
        System.out.println(" ");
        for(int i: in){
            System.out.print(" "+i);
        }
    }

    private static void cyclicSort(int[] in) {
        int counter = 0; //
        while(counter<in.length-1){
            if(in[counter] == counter+1 ){
                counter++;
                continue;
            }
            int temp = in[counter];
            in[counter] = in[temp-1];
            in[temp-1]= temp;
        }
    }
}
