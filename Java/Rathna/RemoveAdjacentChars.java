import java.util.Stack;

public class RemoveAdjacentChars {
    public static void main(String[] args) {
        String str = "abbddaccaaabcd";
        String afterRemoving = removeDuplicates(str);
        System.out.print("After removing all adjacent chars: " + afterRemoving);
    }

    private static String removeDuplicates(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) { //TC = O(n)
            if(!stack.isEmpty() && stack.peek() == str.charAt(i)) {
                stack.pop();
            } else {
                stack.push(str.charAt(i));
            }
        }
        if(!stack.isEmpty()) {
            Character[] obj = stack.toArray(new Character[stack.size()]); //SC = O(n)
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < obj.length; i++) {
                stringBuilder.append(obj[i]);
            }
            return stringBuilder.toString();
        }

        return "";
    }
}
