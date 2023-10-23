import java.util.ArrayList;
import java.util.List;

public class FlattenNestedArray {
    public static void main(String[] args) {
        Object[] deeplyNestedArray = {  // I initially thought it as multi-dimensional array but donno about this deeply nested arrays. Learnt info online
                1,
                2,
                3,
                new Object[]{
                        4,
                        new Object[]{
                                5,
                                new Object[]{6}
                        }
                },
                7
        };

        System.out.println(flattenNestedArr(deeplyNestedArray));
    }

    private static List<Integer> flattenNestedArr(Object[] deeplyNestedArray) {
        List<Integer> output = new ArrayList<Integer>();
        for(Object obj : deeplyNestedArray) {
            if(obj instanceof Integer) {
                output.add((Integer) obj);
            }
            else {
                output.addAll(flattenNestedArr((Object[])obj));
            }
        }
        return output;
    }
}
