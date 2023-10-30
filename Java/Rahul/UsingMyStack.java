import java.util.Stack;

public class Day7Problem3UsingMyStack {
    public static  void main(String[] args){
        String input = "/a//b//c/d/../.../e/../";
        System.out.println(simplifyMyStack(input));
    }

    private static String simplifyMyStack(String input) {
        MyStackLinked in = new MyStackLinked();

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
