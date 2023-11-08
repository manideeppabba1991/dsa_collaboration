import java.util.HashMap;
import java.util.Map;

public class BiggestPalindromeInString {
    public static void main(String[] args) {
        String str = "bbccddefaaghha";
        int bigPalindromeLength = findBigPalindrome(str);
        System.out.println("Maximum possible palindrome length is: " + bigPalindromeLength);
    }

    private static int findBigPalindrome(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            int counter = 1;
            if(hashMap.containsKey(c)) {
                counter = hashMap.get(c);
                counter++;
            }
            hashMap.put(c, counter);
        }
        System.out.println("HashMap contents: " + hashMap.toString());
        int maxLength = 0;
        int oddLength = 0;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            int counter = entry.getValue();
            if(counter % 2 == 0) {
                maxLength = maxLength + counter;
            } else {
                maxLength = maxLength + counter - 1;
                oddLength = 1;
            }
        }
        return oddLength == 1 ? ++maxLength : maxLength;
    }
}
