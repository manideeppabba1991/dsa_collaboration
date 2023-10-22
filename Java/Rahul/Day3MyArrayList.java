/* Online Java Compiler and Editor */
public class MyArrayList{

    private int[] input;
    private int size;
    
    public MyArrayList(int cap){
        input = new int[](cap);
    }
    
    public MyArrayList(){
        input = new int[](10);
    }
    
    public void checkCapacity(int ne ){
        if(input.length <= size+ne ){
            int[] updated = new int[](Math.max(input.length*2,size+ne));
            // Copying elements of a[] to b[] 
            System.arraycopy(input, 0, updated, 0); 
            input = updated;
        }
    }
    public void add(int i){
        checkCapacity();
        input[size] =i;
    }
       
     public static void main(String []args){
        System.out.println("Hello, World!");
        
     }
}
