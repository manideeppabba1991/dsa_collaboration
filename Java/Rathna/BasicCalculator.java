import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String exprsn = "12-(6+2)+8";
        int result = calculator(exprsn);
        System.out.println("Result of the expression is: " + result);
    }

    private static int calculator(String exprsn) {
        Stack<Character> signValue = new Stack<>();
        Stack<Integer> number = new Stack<>();
        int formNumber = 0;
        int result = 0;

        for(int i = 0; i < exprsn.length(); i++) {
            if(Character.isDigit(exprsn.charAt(i))) {
                formNumber = formNumber * 10 + Character.getNumericValue(exprsn.charAt(i));
            } else if(exprsn.charAt(i) == '+') {
                number.push(formNumber);
                signValue.push(exprsn.charAt(i));
                formNumber = 0;
            } else if(exprsn.charAt(i) == '-') {
                number.push(formNumber);
                signValue.push(exprsn.charAt(i));
                formNumber = 0;
            } else if (exprsn.charAt(i) =='(') {
                signValue.push(exprsn.charAt(i));
            } else if (exprsn.charAt(i) ==')') {
                number.push(formNumber);
                signValue.push(exprsn.charAt(i));
            }

            if(i == exprsn.length() - 1) {
                number.push(formNumber);
            }
        }
        System.out.println(signValue);
        System.out.println(number);
        return result; // this is not the complete solution, I am working on it and unable to figure it out.
    }
}
