import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> regularQueue = new LinkedList<>();
        regularQueue.add(5);
        regularQueue.add(1);
        regularQueue.add(3);

        System.out.print("Regular queue: ");
        while (!regularQueue.isEmpty()) {
            System.out.print(regularQueue.remove() + " ");
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(3);

        System.out.print("\nPriority queue: ");
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.remove() + " ");
        }
    }
}
