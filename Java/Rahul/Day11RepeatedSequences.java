//https://www.educative.io/courses/grokking-coding-interview-patterns-java/repeated-dna-sequences
// time = o(n)
// space = o(n)

import java.util.HashSet;
import java.util.Set;

public class RepeatedDNASequence {
    public static void main(String[] args){
        String in = "ATATATATATATATAT";
        System.out.println(findRepeatedSequences(in,6));
    }

    public static Set<String> findRepeatedSequences(String s, int k) {

        Set<String> allSets= new HashSet<>();
        Set<String> repeatedSets= new HashSet<>();
        for(int i=0;i<s.length()-(k-1);i++){
            if(allSets.contains(s.substring(i,i+k)))
                repeatedSets.add(s.substring(i,i+k));
            allSets.add(s.substring(i,i+k));
        }
        return repeatedSets;
    }
}
