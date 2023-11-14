import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        int max = totalFruit(fruits);
        System.out.println("Maximum Fruits: " + max);
    }

    private static int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxFruits = 0;

        for(right = 0; right < fruits.length; right++) { // TC = O(n), SC = O(n)
            // Add current fruit to basket
            int currentCount = basket.getOrDefault(fruits[right], 0);
            basket.put(fruits[right], currentCount + 1);

            // If basket has more than 2 types of fruits, start emptying from left until a position is free.
            while(basket.size() > 2) {
                int fruitCount = basket.get(fruits[left]);
                if(fruitCount == 1) {
                    basket.remove(fruits[left]);
                }
                else {
                    basket.put(fruits[left], fruitCount - 1);
                }
                left++;

            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
