import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(1000));
            Student value = new Student("Student " + i, 20);
            table.put(key, value);
            //table.get(key);
            //table.remove(key);
        }

        List<LinkedList<MyHashTable.HashNode<MyTestingClass, Student>>> buckets = table.getBuckets();
        for (int i = 0; i < buckets.size(); i++) {
            LinkedList<MyHashTable.HashNode<MyTestingClass, Student>> bucket = buckets.get(i);
            System.out.println("Bucket " + i + ": " + bucket.size() + " elements");
        }

        BST<Integer, String> tree = new BST<>();
        tree.put(3, "Three");
        tree.put(1, "One");
        tree.put(5, "Five");
    }
}