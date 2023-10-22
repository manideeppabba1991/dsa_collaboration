import java.util.Arrays;

public class ProductofArray {
    public static void main(String[] args) {
        int[] a = {1,4,5,10};
        int product = productOfArr(a);
        int recProduct = recProductOfArr(a);
        System.out.println("Product = " + product);
        System.out.println("Recursive Approach Product = " + recProduct);
    }
    private static int productOfArr(int[] a) {
        int product = 1;
        for (int i: a) { //TC: O(n), SC = O(1)
            product = product * i;
        }
        return product;
    }
    private static int recProductOfArr(int[] a) {
        if(a.length == 1){
            return a[0];
        }
        return a[a.length - 1] * recProductOfArr(Arrays.copyOf(a, a.length - 1));
    }

}
