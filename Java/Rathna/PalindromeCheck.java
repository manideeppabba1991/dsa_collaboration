public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "MALAYALAM";
        if(IsPalindromeUsingRec(str) && IsPalindrome(str)) {
            System.out.println("Given string is a palindrome");
        }
         else {
            System.out.println("Given string is not a palindrome");
        }
    }

    private static boolean IsPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) { //TC = O(n/2) ==> o(n) and SC = O(1)
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    private static boolean IsPalindromeUsingRec(String str) {
        if(str.length() == 1){
            return true;
        }
        if(str.length() == 2 && str.charAt(0) == str.charAt(1)) {
            return true;
        }
        return ((str.charAt(0) == str.charAt(str.length() - 1)) &&
                IsPalindromeUsingRec(str.substring(1, str.length() - 1)));
    }
}
