public class CapacityToShipWeights {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int capacityAllowed = shipWeights(weights, days);
        System.out.println("Minimum allowed capacity for the ship is " + capacityAllowed + " within given days " + days);
    }

    private static int shipWeights(int[] weights, int days) {
        int sumOfWeights = 0;
        int maxWeight = 0;

        for(int weight: weights) {
            sumOfWeights = sumOfWeights + weight;

            if(maxWeight < weight) {
                maxWeight = weight;
            }
        }
        System.out.println("Sum of all weights on the conveyor belt: " + sumOfWeights);
        System.out.println("Max weight on the conveyor belt: " + maxWeight);

        int left = maxWeight;
        int right = sumOfWeights;
        int capacity = right;
        System.out.println("Left = " + left + " Right = " + right + " Capacity = " + capacity);

        while(left < right) {
            int mid = (int) Math.floor((left + right)/2);
            System.out.println("Left = " + left + " Right = " + right + " Capacity = " + capacity + " Mid = " + mid);
            if(IsCorrectCapacity(weights, days, mid)) {
                right = mid - 1;
                capacity = mid;
                System.out.println("Left = " + left + " Right = " + right + " Capacity = " + capacity + " Mid = " + mid);
            } else {
                left = mid + 1;
                System.out.println("Left = " + left + " Right = " + right + " Capacity = " + capacity + " Mid = " + mid);
            }
        }
        return capacity;
    }

    private static boolean IsCorrectCapacity(int[] weights, int days, int capacity) {
        int countDays = 1;
        int initialWeight = 0;
        for(int weight : weights) {
            if(initialWeight + weight > capacity) {
                countDays++;
                initialWeight = 0;
                System.out.println("CountDays = " + countDays + " ExactDays = " + days + " InitialWeight = " + initialWeight + " Capacity = " + capacity);
            }
            initialWeight = initialWeight + weight;
            System.out.println("CountDays = " + countDays + " ExactDays = " + days + " InitialWeight = " + initialWeight + " Capacity = " + capacity);
        }

        return days >= countDays;
    }
}
