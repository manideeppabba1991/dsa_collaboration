import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
        String str1 = "kilo";
        String str2 = "kill";
        boolean flag = checkAnagram(str1, str2);
        System.out.println("Are both Strings anagram or not: " + flag);

        int value1 = 12340;
        int value2 = 2314;
        boolean integerFlag = checkAnagramForIntegers(value1, value2);
        System.out.println("Are both Integers anagram or not: " + integerFlag);

    }

    private static boolean checkAnagramForIntegers(int value1, int value2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        if(value1 == value2) {
            return true;
        }

        while(value2 > 0) { // TC = # of digits in integer
            int key = value2 % 10;
            int counter = 1;
            if(hashMap.containsKey(key)) {
                counter = hashMap.get(key);
                counter++;
            }
            hashMap.put(key, counter);
            value2 = value2 / 10;
        }
        System.out.println(hashMap.toString());

        while(value1 > 0) {
            int key = value1 % 10;
            if(hashMap.containsKey(key)) {
                int counter = hashMap.get(key);
                if(counter == 1) {
                    hashMap.remove(key);
                } else{
                    counter--;
                    hashMap.replace(key, counter);
                }
            } else {
                return false;
            }
            value1 = value1 / 10;
        }
        return hashMap.isEmpty();
    }

    private static boolean checkAnagram(String str1, String str2) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        if(str1.length() != str2.length()) {
            return false;
        }

        for(int i = 0; i < str2.length(); i++) { //TC = O(n)
            Character c = str2.charAt(i);
            int counter = 1;
            if(hashMap.containsKey(c)) {
                counter = hashMap.get(c);
                counter++;
            }
            hashMap.put(c,counter);
        }
        System.out.println(hashMap.toString());


        for(int i = 0; i< str1.length(); i++) {
            if(hashMap.containsKey(str1.charAt(i))) {
                int counter = hashMap.get(str1.charAt(i));
                if(counter == 1) {
                    hashMap.remove(str1.charAt(i));
                } else{
                    counter--;
                    hashMap.replace(str1.charAt(i), counter);
                }
            } else {
                return false;
            }
        }
        return hashMap.isEmpty();
    }
}
