public class MyHashSetDriver {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add("Apple");
        myHashSet.add("Beets");
        myHashSet.add("Carrots");
        myHashSet.add("DragonFruit");
        myHashSet.add("Apple");
        myHashSet.add("DragonFruit");

        myHashSet.remove("DragonFruit");
        System.out.println(myHashSet);

        System.out.println(myHashSet.contains("DragonFly"));
        System.out.println(myHashSet.contains("Apple"));
        System.out.println(myHashSet.contains("DragonFruit"));

        System.out.println(myHashSet.isEmpty());
        System.out.println(myHashSet.size());

        myHashSet.clear();
        System.out.println(myHashSet.size());
        
    }
    
}
