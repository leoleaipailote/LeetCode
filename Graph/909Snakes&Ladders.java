class Solution {
    public class Graph {
        public int value;
        public int snake;
        public Set<Graph> adj;

        public Graph(int val, int snake) {
            value = val;
            this.snake = snake;
            adj = new HashSet<Graph>();
        }

        public void addAdj(Graph g) {
            adj.add(g);
        }
    }

    public int snakesAndLadders(int[][] board) {
        int rows = board.length;
        int cols = board.length;
        int total = (int) Math.pow(rows, 2);
        boolean left = true;
        HashMap<Integer, Graph> map = new HashMap<Integer, Graph>();
        for (int i = rows - 1; i >= 0; i--) {
            if (left) {
                for (int j = 0; j < cols; j++) {
                    int val = (rows - 1 - i) * cols + j + 1;
                    Graph g = new Graph(val, board[i][j]);
                    map.put(val, g);
                }
                left = false;
            } else {
                for (int j = cols - 1; j >= 0; j--) {
                    int val = (rows - 1 - i) * cols + cols - j;
                    Graph g = new Graph(val, board[i][j]);
                    map.put(val, g);
                }
                left = true;
            }
        }
        for (Map.Entry<Integer, Graph> entry : map.entrySet()) {
            int key = entry.getKey();
            Graph g = entry.getValue();
            for (int i = key + 1; i <= key + 6 && i <= total; i++) {
                Graph x = map.get(i);
                if (x.snake != -1)
                    g.addAdj(map.get(x.snake));
                else
                    g.addAdj(x);
            }
        }

        Queue<Pair> bfs = new LinkedList<Pair>();
        HashSet<Graph> visited = new HashSet<Graph>();
        Pair start = new Pair(map.get(1), 0);
        bfs.add(start);
        visited.add(map.get(1));
        while (!(bfs.isEmpty())) {
            Pair p = bfs.poll();
            Graph g = (Graph) p.getKey();
            int moves = (int) p.getValue();
            if (g.value == total)
                return moves;
            for (Graph x : g.adj) {
                if (!(visited.contains(x))) {
                    visited.add(x);
                    Pair neighbour = new Pair(x, moves + 1);
                    bfs.add(neighbour);
                }
            }
        }
        return -1;
    }
}