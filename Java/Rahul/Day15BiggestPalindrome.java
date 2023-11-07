//TC= O(n), SC =O(n)

import java.util.HashMap;
import java.util.Map;

public class BiggestPalindromePossible {

    public static void main(String[] args){
        String in = "aabbccddeeffgghhiii";//abcdddcba

        System.out.println(checkHighestPalind(in));
    }

    private static int checkHighestPalind(String in) {
        Map<Character, Integer> stMap = new HashMap<>();

        for(int i =0;i<in.length();i++){
            Character c = in.charAt(i);
            if(stMap.containsKey(c)){
                int exist=stMap.get(c);
                stMap.put(c,exist+1);
            }else{
                stMap.put(c,1);
            }
        }
        int maxVal=0;
        boolean oddAvail = false;
        for(Map.Entry<Character, Integer> elem: stMap.entrySet() ){
            int val = elem.getValue();
            if(val%2 == 0){
                maxVal = maxVal+val;
            }else{
                maxVal = maxVal+(val-1);
                oddAvail = true;
            }
        }
        if(oddAvail)
            return maxVal+1;

        return maxVal;
    }

}

