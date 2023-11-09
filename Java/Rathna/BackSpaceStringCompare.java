public class BackSpaceStringCompare {
    public static void main(String[] args) {
        String str1 = "ab#c";
        String str2 = "ad#c";
        boolean compare = backSpaceCompare(str1, str2);
        if (compare) {
            System.out.println("Both strings are equal");
        } else {
            System.out.println("Both strings are not equal");
        }
    }

    private static boolean backSpaceCompare(String str1, String str2) {
        String s1 = traverseString(str1);
        String s2 = traverseString(str2);
        System.out.println("String 1 after loading: " + s1);
        System.out.println("String 2 after loading: " + s2);
        return s1.equals(s2);
    }

    private static String traverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (c.equals('#')) {
                stringBuilder.delete(i - 1, stringBuilder.length());
            } else {
                stringBuilder.append(c);
            }
        }
        return String.valueOf(stringBuilder);
    }
}

