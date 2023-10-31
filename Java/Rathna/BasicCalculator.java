import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String exprsn = "12 - (6 + 2) + 8";
        int result = calculator(exprsn);
        System.out.println("Result of the expression is: " + result);
    }

    private static int calculator(String exprsn) {
        Stack<Double> number = new Stack<>();
        double formNumber = 0;
        int symbol = 1; //1 indicates positive and -1 for negative

        for (int i = 0; i < exprsn.length(); i++) {
            if (Character.isDigit(exprsn.charAt(i))) {
                formNumber = formNumber * 10 + Character.getNumericValue(exprsn.charAt(i));
            } else if (exprsn.charAt(i) == '+') {
                number.push(formNumber * symbol);
                formNumber = 0;
                symbol = 1;
                System.out.println("Stack values: " + number);
            } else if (exprsn.charAt(i) == '-') {
                number.push(formNumber * symbol);
                formNumber = 0;
                symbol = -1;
                System.out.println("Stack values: " + number);
            } else if (exprsn.charAt(i) == '(') {
                if (symbol == -1) {
                    number.push(Double.NEGATIVE_INFINITY);
                    System.out.println("Stack values: " + number);
                } else {
                    number.push(Double.POSITIVE_INFINITY);
                    System.out.println("Stack values: " + number);
                }
                symbol = 1;
            } else if (exprsn.charAt(i) == ')') {
                double interimResult = formNumber * symbol;
                System.out.println("Interim result before closing ): " + interimResult);
                symbol = 1;

                while (!number.isEmpty() && number.peek() != Double.NEGATIVE_INFINITY && number.peek() != Double.POSITIVE_INFINITY) {
                    System.out.println("Stack peek value: " + number.peek());
                    System.out.println("Stack values before popping: " + number);
                    interimResult += number.pop();
                    System.out.println("Stack values after popping: " + number);
                    if (number.peek() == Double.NEGATIVE_INFINITY)
                        interimResult = -1 * interimResult;
                    System.out.println("Interim result if peek is negative infinity: " + interimResult);
                }
                System.out.println("Stack values outside before popping: " + number);
                number.pop();
                System.out.println("Stack values outside after popping: " + number);
                formNumber = interimResult;
            }
        }
        if (formNumber > 0) {
            number.push(formNumber * symbol);
            System.out.println("Stack values: " + number);
        }
        int result = 0;
        while (!number.isEmpty()) {
            result += number.pop();
        }
        return result;
    }
}