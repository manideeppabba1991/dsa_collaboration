// added all methods i can, few needs collection so didn't get them
public class MyArrayList {
    private int[] input;
    private int size;

    public MyArrayList(int cap){
        input = new int[cap];
    }

    public MyArrayList(){
        input = new int[10];
    }

    private void checkCapacity(int ne ){
        if(input.length <= size+ne ){
            int[] updated = new int[Math.max(input.length*2,size+ne)];
            // Copying elements of a[] to b[]
            System.arraycopy(input, 0, updated, 0,size);
            input = updated;
        }
    }
    public void add(int i){
        checkCapacity(1);
        input[size] =i;
        size = size+1;
    }

    public boolean addAll(int[] in){
        checkCapacity( in.length);
        for(int i=0;i< in.length;i++){
            input[size] =in[i];
            size++;
        }
        return true;
    }

    public int remove(int index) throws Exception {
        if(index<0 || index> size-1){
            throw new Exception("Index Out of Bound");
        }
        int out = input[index];
        int[] newAry = new int[size-1];
        for(int j=0,k=0;j< size;j++){
            if(j!=index){
                newAry[k]=input[j];
                k++;
            }
        }
        input = newAry;
        size = size-1;
        return out;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size ==0)
            return true;

        return false;
    }

    public boolean contains(int i){

        for (int x =0 ; x < size;x++) {
            if(i==input[x])
                return true;
        }
        return false;
    }

    public int indexOf(int i){

        for (int x =0 ; x< size;x++) {
            if(i==input[x])
                return x;
        }
        return -1;
    }

    public int lastIndexOf(int i){
        for (int x =size ; x> 0;x--) {
            if(i==input[x])
                return x;
        }
        return -1;
    }
    public void clear() {
        if(size>0){
            input = new int[10];
        }
        size =0;
    }
}
