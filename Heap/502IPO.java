class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int ans = w;
        int idx = 0;
        int count = 0;
        int[][] test = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            test[i][0] = capital[i];
            test[i][1] = profits[i];
        }
        Arrays.sort(test, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));

        for (int i = 0; i < test.length; i++) {
            if (test[i][0] > w)
                break;
            pq.add(new int[] { test[i][0], test[i][1] });
            idx++;
        }
        while (count < k && !(pq.isEmpty())) {
            int[] project = pq.poll();
            ans += project[1];
            count++;
            if (project[1] == 0)
                break;
            for (int i = idx; i < test.length; i++) {
                if (test[i][0] > ans)
                    break;
                pq.add(new int[] { test[i][0], test[i][1] });
                idx++;
            }
        }
        return ans;
    }
}