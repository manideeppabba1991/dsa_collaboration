import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter just one string: ");
        String inputStr = scan.next();
        System.out.println("Contents of input string: " + inputStr);
        if(inputStr.length() >= 1 && inputStr.length() <= 104 )
            System.out.println("Valid - Given input string: " + inputStr + " met the length constraint [1-104]: " + inputStr.length());
        else {
            System.out.println("Invalid - Given input string: " + inputStr + " didn't met the length constraint [1-104]: " + inputStr.length());
            return;
        }
        char [] validChars = {'(', ')', '[', ']', '{', '}'};
        for(int i = 0; i < inputStr.length(); i++) {
            if(inputStr.charAt(i) == validChars[0] || inputStr.charAt(i) == validChars[1]
            || inputStr.charAt(i) == validChars[2] || inputStr.charAt(i) == validChars[3]
            || inputStr.charAt(i) == validChars[4] || inputStr.charAt(i) == validChars[5]) {
                System.out.println("Valid - Input string have a valid char: " + inputStr.charAt(i) + " at position: " + i);
            }
            else {
                System.out.println("Invalid - Input string have a invalid char: " + inputStr.charAt(i) + " at position: " + i);
                return;
            }
        }
        int countLP = 0;
        int countRP = 0;
        int countLS = 0;
        int countRS = 0;
        int countLF = 0;
        int countRF = 0;
        char [] inputStrCharArray = inputStr.toCharArray();
        for (char c : inputStrCharArray) {
            if (c == '(') {
                countLP++;
            } else if (c == ')') {
                countRP++;
            } else if (c == '[') {
                countLS++;
            } else if (c == ']') {
                countRS++;
            } else if (c == '{') {
                countLF++;
            } else {
                countRF++;
            }
        }
        if(countLP != countRP
                || countLS != countRS
                || countLF != countRF) {
            System.out.println("Invalid - Given input string doesn't have matching parenthesis count");
        } else {
            System.out.println("Valid - Given input string satisfied - matching parenthesis count");
        }
        int indexOfFirstLP;
        int indexOfFirstRP;
        int indexOfFirstLS;
        int indexOfFirstRS;
        int indexOfFirstLF;
        int indexOfFirstRF;
        int indexOfLastLP;
        int indexOfLastRP;
        int indexOfLastLS;
        int indexOfLastRS;
        int indexOfLastLF;
        int indexOfLastRF;

        indexOfFirstLP = inputStr.indexOf(validChars[0]);
        indexOfFirstRP = inputStr.indexOf(validChars[1]);
        indexOfFirstLS = inputStr.indexOf(validChars[2]);
        indexOfFirstRS = inputStr.indexOf(validChars[3]);
        indexOfFirstLF = inputStr.indexOf(validChars[4]);
        indexOfFirstRF = inputStr.indexOf(validChars[5]);

        indexOfLastLP = inputStr.lastIndexOf(validChars[0]);
        indexOfLastRP = inputStr.lastIndexOf(validChars[1]);
        indexOfLastLS = inputStr.lastIndexOf(validChars[2]);
        indexOfLastRS = inputStr.lastIndexOf(validChars[3]);
        indexOfLastLF = inputStr.lastIndexOf(validChars[4]);
        indexOfLastRF = inputStr.lastIndexOf(validChars[5]);

        if((indexOfFirstLP != -1 && indexOfFirstRP != -1 && indexOfFirstLP < indexOfFirstRP)
                || (indexOfFirstLS != -1 && indexOfFirstRS != -1 && indexOfFirstLS < indexOfFirstRS)
                || (indexOfFirstLF != -1 && indexOfFirstRF != -1 && indexOfFirstLF < indexOfFirstRF)
                && (indexOfLastLP != -1 && indexOfLastRP != -1 && indexOfLastLP < indexOfLastRP)
                && (indexOfLastLS != -1 && indexOfLastRS != -1 && indexOfLastLS < indexOfLastRS)
                && (indexOfLastLF != -1 &&  indexOfLastRF != -1 && indexOfLastLF < indexOfLastRF)
        ) {
            System.out.println("Valid - First and Last braces are in correct order");
        } else {
            System.out.println("Invalid - First and Last braces are not in correct order");
        }

    }
}