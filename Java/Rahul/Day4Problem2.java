
/*

https://www.educative.io/courses/grokking-coding-interview-patterns-java/reverse-words-in-a-string
Given a sentence, reverse the order of its words without affecting the order of letters within a given word.

Constraints:

Sentence contains English uppercase and lowercase letters, digits, and spaces.

The order of the letters within a word is not to be reversed.
 */
public class Day4Problem2 {
    public static void main(String[] args){
        String in ="Hello Friend";
        String out = reverseStatement(in);
        System.out.println(out);
    }

    private static String reverseStatement(String in) {
        in = in.trim();
        String[] input = in.split("\\s+");
        int left =0;
        int right = input.length-1;

        while(left<right){
            String temp = input[left];
            input[left] = input[right];
            input[right] = temp;
            left++;
            right--;
        }
        return String.join(" ",input);
    }
}
