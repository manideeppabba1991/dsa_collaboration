import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args){
        /*String st1 = "abcxde";
        String st2 = "edebac";

        System.out.println( checkAnagram(st1,st2));*/

        int num1 = 345167;
        int num2 = 74653;
        System.out.println( checkAnagramNum(num1,num2));


    }

    private static boolean checkAnagramNum(int num1, int num2) {

        if(num1 == num2)
            return true;

        Map<Integer,Integer> intMp = new HashMap<>();
        while(num1>0){
            int rem = num1%10;
            num1 = num1/10;
            if(intMp.containsKey(rem)){
                int ex = intMp.get(rem);
                intMp.put(rem,ex+1);
            }else{
                intMp.put(rem,1);
            }
        }
        while(num2>0){
            int rem = num2%10;
            num2 = num2/10;
            if(intMp.containsKey(rem)){
                if(intMp.get(rem) != 1){
                    int exist=intMp.get(rem);
                    intMp.put(rem,exist-1);
                }else{
                    intMp.remove(rem);
                }
            }else{
                return false;
            }
        }

        return intMp.isEmpty();
    }

    private static boolean checkAnagram(String st1, String st2) {
        if(st1.length() != st2.length())
            return false;

        HashMap<Character, Integer> stMap = new HashMap<>();

        for(int i =0;i<st1.length();i++){
            Character c = st1.charAt(i);
            if(stMap.containsKey(c)){
                int exist=stMap.get(c);
                stMap.put(c,exist+1);
            }else{
                stMap.put(c,1);
            }
        }

        for(int i=0; i<st2.length();i++){
            Character c = st2.charAt(i);
            if(stMap.containsKey(c)){
                if(stMap.get(c) != 1){
                    int exist=stMap.get(c);
                    stMap.put(c,exist-1);
                }else{
                    stMap.remove(c);
                }
            }else{
                return false;
            }
        }

        return stMap.isEmpty();
    }

}
