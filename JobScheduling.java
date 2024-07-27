import java.util.*;

public class JobScheduling {
    public int getMinimumOperations(int[] executionTime, int x, int y) {
        int minOps = 0;
        int diff = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        for (int time : executionTime)
            pq.add(time);
        while (pq.peek() > diff) {
            int time = pq.poll();
            time -= x - y;
            diff += x - y;
            minOps++;
            pq.add(time);
        }
        return minOps;
    }

    public static void main(String[] args) {
        JobScheduling x = new JobScheduling();
        int[] executionTime = { 1, 1, 1, 20, 20 };
        System.out.println(x.getMinimumOperations(executionTime, 4, 2));
    }
}
