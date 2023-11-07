import java.util.HashMap;

public class MaxNonRepeatedChars {
    public static void main(String[] args) {
        String str = "abcdbea";
        int windowStart = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int maxSize = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            if (hashMap.containsKey(str.charAt(windowEnd))) {
                windowStart = Math.max(windowStart, hashMap.get(str.charAt(windowEnd)) + 1);
                System.out.println("IF windowStart: " + windowStart);
                System.out.println("IF windowEnd: " + windowEnd);
                System.out.println("IF Max: " + maxSize);
            }
            hashMap.put(str.charAt(windowEnd), windowEnd);
            System.out.println(hashMap);
            maxSize = Math.max(maxSize, (windowEnd - windowStart + 1));
            System.out.println("Else windowStart: " + windowStart);
            System.out.println("Else windowEnd: " + windowEnd);
            System.out.println("Else Max: " + maxSize);
        }
        System.out.println("Max size: " + maxSize); // Also find the substring
    }
}
