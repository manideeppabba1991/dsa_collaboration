//space is o(n)
//time is o(n)
//https://leetcode.com/problems/simplify-path/submissions/?envType=study-plan-v2&envId=top-interview-150

import java.util.Stack;

public class Day7Problem3 {
    public static  void main(String[] args){
        String input = "/../";
        System.out.println(simplify(input));
    }

    private static String simplify(String input) {
        Stack<String> in = new Stack<>();

        StringBuilder out = new StringBuilder("");

        int counter =0;
        while(counter< input.length()){
            StringBuilder word = new StringBuilder("");
            while(counter< input.length()&&input.charAt(counter) !='/'){
                word =word.append(input.charAt(counter));
                counter++;
            }
            if(word.toString().equals(".." )  ){
                word = new StringBuilder("");
                if(!in.isEmpty())
                    in.pop();
            } else if (word.toString().equals("." )) {
                word = new StringBuilder("");
            }

            if(!word.toString().equals("")){
                in.push(word.toString());
            }
            word = new StringBuilder("");
            counter++;
        }



        if(in.isEmpty())
            return "/";

        while(!in.isEmpty()){
            out.insert(0,in.pop());
            out.insert(0,"/");
        }

        return out.toString();
    }
}
