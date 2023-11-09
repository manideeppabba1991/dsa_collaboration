import java.util.HashMap;
import java.util.Map;

public class FrequentCharInString {

    public static void main(String[] args){
        String in = "abaackkbbbcstbkkkbbkkkccc";
        
        strUsMap(in);
        strUsMyMap(in);

    }

    private static void strUsMyMap(String in) {
        TryingMap tMap = new TryingMap();

        int max =1;
        Character c = in.charAt(0);
        //int cCount =0;

        for(int i = 0;i< in.length();i++){
            Character key = in.charAt(i);
            if(tMap.containsKey(key)){
                int temp = tMap.get(key);
                tMap.put(key,temp+1);
                if(max < tMap.get(key)){
                    max = tMap.get(key);
                    c = key;
                }
            }  else{
                tMap.put(key,1);
            }
        }

        System.out.println(c+" in myMap is repeated "+max);
    }

    private static void strUsMap(String in) {
        Map<Character, Integer> op = new HashMap<>();


        int max =1;
        Character c = in.charAt(0);

        for(int i = 0; i< in.length(); i++){
            Character key = in.charAt(i);
            if(op.containsKey(key)){
                int temp = op.get(key);
                op.put(key,temp+1);
                if(max < op.get(key)){
                    max = op.get(key);
                    c = key;
                }
            }  else{
                op.put(key,1);
            }
        }

        System.out.println(c+" is repeated "+max);
    }

}
