public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/home//foo//yoo";
        path = pathSimplify(path);
        System.out.println(path);
    }
    //Method to simplifyPath based on certain given constraints to return canonical path
    private static String pathSimplify(String path) {
        String homePath = "/../";
        String directoryPath = "//";
        if(path.contains(homePath)) {
            path = path.replace(homePath, "/");
        }
        if(path.contains(directoryPath)) {
            path = path.replace(directoryPath, "/");
        }
        if(path.length() > 1 && path.charAt(path.length() - 1) == '/') {
            path = path.substring(0, path.length() - 1);
        }
        return path;
    }
}
