public class MyLinkedListTest {
    public static void main(String[] args){
        MyLinkedList my = new MyLinkedList();
        my.add(1);

        my.add(2);
        my.add(3);
        System.out.println(my.size());//3
        System.out.println(my.find(2));//true
        my.remove(2);
        System.out.println(my.size());//2
        System.out.println(my.find(2));//false
        System.out.println(my.find(5));//false
    }
}
