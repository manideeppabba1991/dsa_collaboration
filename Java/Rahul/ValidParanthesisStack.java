//space complexity O(n)
//time O(n)

import java.util.Stack;

public class ValidParanthesisStack {

    public static void main(String[] args) {

        char[] x = new char[]{'(','{','[',']','}',')'};

        if(ValidParanthesis(x)){
            System.out.println("Valid");
        }else{
            System.out.println("InValid");
        }

    }
    public static boolean ValidParanthesis(char[] in){
        Stack<Character> stor= new Stack<>();
        for(char val: in){
            if(val == '(' ||val == '{' || val == '['){
                stor.push(val);
            } else {
                char p = stor.pop();
                if((val == ')' && p !='(') || (val == ']'
                        && p !='[') || (val == '}' && p !='{')) {
                    return false;
                }
            }
        }
        return stor.size() ==0;
    }
}
