import java.util.HashMap;
import java.util.Map;

//https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-longest-substring-without-repeating-characters

public class StringRepeat {
    public static void main(String[] args){

        String in = "abcdbea";
        int wndStrt =0;
        int max = 0;
        Map<Character,Integer> alphas = new HashMap<>();

        for(int wndEdn=0;wndEdn<in.length();wndEdn++){
            if(alphas.containsKey(in.charAt(wndEdn))){
                wndStrt = Math.max(alphas.get(in.charAt(wndEdn))+1,wndStrt);
            }
            alphas.put(in.charAt(wndEdn),wndEdn);
            max = Math.max(max,(wndEdn-wndStrt)+1);

        }
        System.out.println(max);
    }
}
