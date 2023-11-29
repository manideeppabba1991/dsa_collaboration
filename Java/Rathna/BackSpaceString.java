public class BackSpaceString {
    public static void main(String[] args) {
        String str1 = "bxj##tw";
        String str2 = "bxj###tw";
        boolean compare = comparingString(str1, str2);
        if (compare) {
            System.out.println("Both strings are equal");
        } else {
            System.out.println("Both strings are not equal");
        }
    }

    private static boolean backSpaceComparing(String str1, String str2) {
        int counter1 = 0;
        int counter2 = 0;

        int length1 = str1.length() - 1;
        int length2 = str2.length() - 1;

        //String str1 = "bxj##tw";
        //String str2 = "bxj###tw";
        //l1 = 6
        //l2 = 7

        // traverse from end, count backspaces
        //traverse
        while (length1 >= 0 && length2 >= 0) {
            if (str1.charAt(length1) == str2.charAt(length2)) {
                length1--;
                length2--;
                continue;
            }
            if (length1 >= 0 && str1.charAt(length1) == '#') {
                counter1++;
                length1 = length1 - 2;
            }
            if (length2 >= 0 && str2.charAt(length2) == '#') {
                counter2++;
                length2 = length2 - 2;
            }
        }

        if (length1 == length2) {
            return true;
        }
        return false;
    }

    private static boolean comparingString(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;

        //String str1 = "bxj##tw";
        //String str2 = "bxj###tw";
        //l1 = 6
        //l2 = 7

        while (i >= 0 || j >= 0) {
            //Find the next non-backspace character in s
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }

            //Find the next non-backspace character in t
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }

            //compare current characters in s and t
            if ((i >= 0 && j >= 0) && s.charAt(i) != t.charAt(j)) return false;

            if ((i >= 0) != (j >= 0)) return false; // One string has ended, but the other hasn't

            i--;
            j--; // Continue for the remaining characters
        }
        return true;
    }
}