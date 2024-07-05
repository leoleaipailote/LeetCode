class Solution {
    List<List<String>> ans;
    int n;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<List<String>>();
        this.n = n;
        backTrack(0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), new ArrayList<Pair>());
        return ans;
    }

    public void backTrack(int row, HashSet<Integer> columns, HashSet<Integer> diag, HashSet<Integer> antiDiag,
            List<Pair> comb) {
        if (row == n) {
            ans.add(buildList(comb));
            return;
        }

        for (int i = 0; i < n; i++) {

            if (columns.contains(i) || diag.contains(i - row) || antiDiag.contains(i + row))
                continue;

            columns.add(i);
            diag.add(i - row);
            antiDiag.add(i + row);
            comb.add(new Pair(row, i));

            backTrack(row + 1, columns, diag, antiDiag, comb);

            columns.remove(i);
            diag.remove(i - row);
            antiDiag.remove(i + row);
            comb.remove(comb.size() - 1);
        }

    }

    public List<String> buildList(List<Pair> queens) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                Pair newPair = new Pair(i, j);
                if (queens.contains(newPair))
                    sb.append('Q');
                else
                    sb.append('.');
            }
            res.add(sb.toString());
        }
        return res;
    }
}