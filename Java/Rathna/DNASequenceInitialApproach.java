import java.util.HashSet;

public class DNASequenceInitialApproach {
    public static void main(String[] args) {
        String dnaSequence = "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT";
        int k = 10;
        HashSet<String> hashSet = findRepeatedSequence(dnaSequence, k);
        System.out.println("Contents of Hashset: " + hashSet);
    }

    //My initial code changes for DNASeq program
    private static HashSet<String> findRepeatedSequence(String dnaSequence, int k) {

        StringBuilder stringBuilder = new StringBuilder();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> output = new HashSet<>();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(dnaSequence.charAt(i));
        }
        boolean flag = hashSet.add(String.valueOf(stringBuilder));
        StringBuffer temp = new StringBuffer(stringBuilder);
        for (int j = k; j < dnaSequence.length(); j++) {  // TC = O(n) and SC = O(2n) ==> O(n) if we consider output, if not it is O(1)
            temp = temp.deleteCharAt(0);
            temp = temp.append(dnaSequence.charAt(j));
            flag = hashSet.add(String.valueOf(temp));
            if (!flag) {
                output.add(String.valueOf(temp));
            }
        }
        return output;
    }
}


