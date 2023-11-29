public class MyHashMapDriver {
    public static void main(String[] args) {
        MyHashMap<String, Integer> myMap = new MyHashMap<>();
        myMap.put("ten", 10);
        myMap.put("twenty", 20);
        myMap.put("thirty", 30);

        System.out.println(myMap.get("ten")); // Output: 10

        myMap.remove("thirty");
        System.out.println(myMap.get("thirty")); // Output: null
    }
}
