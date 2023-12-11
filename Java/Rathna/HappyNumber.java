public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        boolean isHappy = isHappy(n);
        System.out.println("Is given number Happy?: " + isHappy);
    }

    private static boolean isHappy(int n) {
        int slow = n;
        int fast = n;


        while(true) { // TC = O(n) and SC = O(1)
            slow = sumOfSquares(slow);
            System.out.println("Slow value: " + slow);
            fast = sumOfSquares(sumOfSquares(fast));
            System.out.println("Fast value: " + fast);

            if(fast == 1) {
                return true;
            } else if(slow == fast) {
                return false;
            }
        }
    }

    private static int sumOfSquares(int num) {
        int square = 0;
        while(num > 0) {
            int remainder = num % 10;
            square += remainder * remainder;
            num = num / 10;
        }
        return square;
    }
    
}
