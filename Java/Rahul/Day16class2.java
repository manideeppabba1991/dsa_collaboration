
import java.util.LinkedList;

public class ParseStringInt {
    public static void main(String[] args){
        String x = "678";
       /* int val =0;
        int sqr =0;
        int[] in = {1,2,3,4,5,6};
        for(int i=0;i<in.length;i++){
            System.out.print(in[i]);
        }
        int[] out = reverseArrayInt(in);
        System.out.println("");
        for(int i=0;i<out.length;i++){
            System.out.print(out[i]);
        }*/

       /* String inS = "race";
        System.out.println(reverseString(inS));*/

        //val = intVal(x, val);
        //sqr = sumSqr(x);

        //System.out.println(sqr);
        //System.out.println(sumSqr(678));
    }

    private static String reverseString(String inS) {
        int left =0;
        int right = inS.length()-1;
        StringBuilder in = new StringBuilder(inS);
        while(left<right){

            Character temp = in.charAt(left);
            in.setCharAt(left,in.charAt(right));
            in.setCharAt(right,temp);
            left++;
            right--;
        }
        return in.toString();
    }

    private static LinkedListNode reverseLinList(LinkedListNode head){

        //1,2,3,4,5,6,null;

        LinkedListNode cur = head;
        LinkedListNode prev = null;
        LinkedListNode temp ;
        while(cur.next != null){
            temp = cur.next; // 2-- ,3--
            cur.next = prev; //null,1-null
            prev = cur;  //1-null, 2-1-nu
            cur = temp; //2-- /3--
        }

        return prev;
    }


    private static int[] reverseArrayInt(int[] in) {
        int left =0;
        int right = in.length-1;
        while(left<right){
            int temp = in[left];
            in[left] = in[right];
            in[right] = temp;
            left++;
            right--;
        }
        return in;
    }

    private static int sumSqr(String x) {
        int value =0;
        for(int i = 0; i< x.length(); i++){
            if(!Character.isDigit(x.charAt(i))){
                System.out.println(false);
                break;
            }

            int temp =  Character.getNumericValue(x.charAt(i)) ;
            int tempSqr = temp*temp;
            value = value+tempSqr;

        }
        return value;
    }

    private static int sumSqr(int x) {
        int value =0;
        while(x>0){
            int temp =  x%10; ;
            int tempSqr = temp*temp;
            value = value+tempSqr;
            x= x/10;
        }

        return value;
    }

    private static int intVal(String x, int val) {
        for(int i = 0; i< x.length(); i++){
            if(!Character.isDigit(x.charAt(i))){
                System.out.println(false);
                break;
            }
            val = val *10 +  Character.getNumericValue(x.charAt(i));
        }
        return val;
    }
}
