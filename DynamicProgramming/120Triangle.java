class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        List<List<Integer>> dp = new ArrayList<List<Integer>>();
        for (int i = 0; i < length - 1; i++)
            dp.add(new ArrayList<Integer>());
        dp.add(triangle.get(length - 1));
        for (int i = length - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            List<Integer> nextRow = dp.get(i + 1);
            List<Integer> dpRow = dp.get(i);
            for (int j = 0; j < row.size(); j++) {
                int min = Math.min(row.get(j) + nextRow.get(j), row.get(j) + nextRow.get(j + 1));
                dpRow.add(j, min);
            }
        }
        return dp.get(0).get(0);
    }
}