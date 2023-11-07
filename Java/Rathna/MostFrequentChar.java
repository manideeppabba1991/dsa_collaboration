import java.util.HashMap;

public class MostFrequentChar {
    public static void main(String[] args) {
        String str = "abababb";
        HashMap<Character, Integer> myMapCounter = new HashMap<>();
        Character mostRepeated = null;
        int max = 0;

        for(int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            int counter = 0;
            if(myMapCounter.containsKey(c)) {
                counter = myMapCounter.get(c);
                counter++;
                System.out.println("Character value: " + c + " counter value: " + counter  + " char  position: " + i);
            } else {
                System.out.println("Character value: " + c + " counter value: " + counter  + " char  position: " + i);
                myMapCounter.put(c, ++counter);
            }
            myMapCounter.put(c, counter);
        }
        for(int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            max = 0;
            mostRepeated = null;
            if(myMapCounter.get(c) > max) {
                max = myMapCounter.get(c);
                mostRepeated = c;
            }
        }
        System.out.println("Most Repeated Char: " + mostRepeated + " count: " + max);
     }
}
