import java.util.HashSet;

public class RepeatedDNASequence {
    public static void main(String[] args) {
        String dnaSequence = "AAAAACCCCCAAAAACCCCCC";
        int k = 8;
        HashSet<String> repeatedSubStrings = findRepeatedSequence(dnaSequence, k);
        System.out.println("Contents of Hashset: " + repeatedSubStrings);
    }

    //My code passed for test cases, but to improve code quality and readability ---> modified accordingly
    private static HashSet<String> findRepeatedSequence(String dnaSequence, int k) {
        HashSet<String> uniqueSubStrings = new HashSet<>();
        HashSet<String> repeatedSubStrings = new HashSet<>();
        String stringWindow = dnaSequence.substring(0, k);
        uniqueSubStrings.add(stringWindow);
        for(int j = k; j < dnaSequence.length(); j++) { // TC = O(n) and SC = O(2n) ==> O(n) if we consider output, if not it is O(1)
            stringWindow = stringWindow.substring(1) + dnaSequence.charAt(j);
            if(!uniqueSubStrings.add(stringWindow)) {
                repeatedSubStrings.add(stringWindow);
            }
        }
        return repeatedSubStrings;
    }
}
