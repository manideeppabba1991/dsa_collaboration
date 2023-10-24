public class SortColors {
    public static void main(String[] args) {
        int[] colors = {2, 1, 1, 0, 0};
        int[] sortedColors = sortColorsBasedOnCriteria(colors);
        System.out.print("Sorted colors: ");
        for(int i: sortedColors){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] sortColorsBasedOnCriteria(int[] colors) {
        int red = 0;
        int white = 0;
        int blue = colors.length - 1;
        while(white <= blue) { //TC = O(n) and SC = O(1)
            if(colors[white] == 0) {
                int temp = colors[red];
                colors[red] = colors[white];
                colors[white] = temp;
                red++;
                white++;
            } else if (colors[white] == 1) {
                white++;
            } else {
                int temp = colors[blue];
                colors[blue] = colors[white];
                colors[white] = temp;
                blue--;
            }
        }
        return colors;
    }
}
