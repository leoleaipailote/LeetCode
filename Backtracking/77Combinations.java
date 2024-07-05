class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<List<Integer>>();
        HashSet<Integer> visited = new HashSet<Integer>();
        for (int i = 1; i <= n; i++)
            visited.add(i);
        helper(n, k, visited, new ArrayList<Integer>());
        return ans;
    }

    public void helper(int n, int k, HashSet<Integer> visited, List<Integer> comb) {
        if (comb.size() == k) {
            // System.out.println(comb);
            ans.add(new ArrayList<Integer>(comb));
        } else {
            // System.out.println(comb);
            HashSet<Integer> visCopy = new HashSet<Integer>(visited);
            for (Integer i : visited) {
                visCopy.remove(i);
                comb.add(i);
                if (visCopy.size() >= k - comb.size())
                    helper(n, k, visCopy, comb);
                comb.remove(i);
            }
        }
    }
}