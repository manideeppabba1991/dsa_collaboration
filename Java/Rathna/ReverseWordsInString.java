public class ReverseWordsInString {
    public static void main(String[] args) {
        String str = "  Hello  a Friend  ";
        String reverseStr = reverseString(str);
        System.out.println("Reverse words in the string: " + reverseStr);
    }

    private static String reverseString(String str) {
        String reverse = "";
        String delimiter = " ";

        str = str.trim();
        String[] strings = str.split(" ");
        int left = 0;
        int right = strings.length - 1;
        while(left < right) { //TC = O(n) and SC = O(1)
            String temp = strings[left];
            strings[left] = strings[right];
            strings[right] = temp;
            left++;
            right--;
        }
        for(String s: strings) {
            if(!s.isEmpty()) {
                reverse += s + delimiter;
            }
        }
        return reverse;
    }
}
