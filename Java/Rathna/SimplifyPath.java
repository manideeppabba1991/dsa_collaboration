import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/home/..//foo//../../yoo/"; // after splitting = "", home, .., foo, .., .., yoo
        path = pathSimplify(path);
        System.out.println(path);
    }

    //Method to simplifyPath based on certain given constraints to return canonical path
    private static String pathSimplify(String path) {
        Stack<String> stack = new Stack<>();
        String[] folderArray = path.split("/+");
        for (String fold : folderArray) {
            System.out.println("Contents of folderArray is: " + fold);
            if (fold.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!(fold.equals("..") || fold.equals(".") || fold.equals(""))) {
                stack.add(fold);
            }
        }
        String result = "";
        for (String dir : stack) {
            result += "/" + dir;
        }
        return result.isEmpty() ? "/" : result;
    }
}
