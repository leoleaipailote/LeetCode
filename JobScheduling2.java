import java.util.*;

public class JobScheduling2 {

    public int getMaximumThroughput(int[] throughput, int[] scaling_cost, int budget) {
        int[] copy = Arrays.copyOf(throughput, throughput.length);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            else
                return Integer.compare(a[1], b[1]);
        });
        for (int i = 0; i < throughput.length; i++) {
            pq.add(new int[] { throughput[i], scaling_cost[i], i });
        }
        while (budget > 0) {
            int[] arr = pq.poll();
            int cost = arr[1];
            int idx = arr[2];
            copy[idx] += throughput[idx];
            budget -= cost;
            pq.add(new int[] { copy[idx], cost, idx });
        }
        int min = Integer.MAX_VALUE;
        for (int num : copy)
            min = Math.min(min, num);
        return min;
    }

    public static void main(String[] args) {
        JobScheduling2 js = new JobScheduling2();
        int[] throughput = { 4, 2, 7 };
        int[] scaling_cost = { 3, 5, 6 };
        int budget = 32;

        int result = js.getMaximumThroughput(throughput, scaling_cost, budget);
        System.out.println(result);
    }
}
