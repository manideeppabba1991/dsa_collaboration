import java.util.Scanner;

public class FindValueAtFibSeries {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the position value: ");
        int position = scan.nextInt();
        System.out.println();
        System.out.println("Value in Fib series at position: " + position + " is " + findValue(position));
        scan.close();
    }

    private static int findValue(int position) {
        if(position == 1) {
            return 0;
        } else if(position == 2) {
            return 1;
        }
        return findValue(position - 1) + findValue(position - 2);
    }
}
