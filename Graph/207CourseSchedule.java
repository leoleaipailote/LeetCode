class Solution {
    public class Graph {
        public int value;
        public Set<Graph> prereq;

        public Graph(int val) {
            value = val;
            prereq = new HashSet<Graph>();
        }

        public void addPrereq(Graph course) {
            prereq.add(course);
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Graph> map = new HashMap<Integer, Graph>();
        for (int[] prereq : prerequisites) {
            Graph x = map.getOrDefault(prereq[0], new Graph(prereq[0]));
            map.put(prereq[0], x);
            Graph y = map.getOrDefault(prereq[1], new Graph(prereq[1]));
            map.put(prereq[1], y);
            y.addPrereq(x);
        }
        HashSet<Graph> visited = new HashSet<Graph>();
        for (Map.Entry<Integer, Graph> entry : map.entrySet()) {
            HashSet<Graph> stack = new HashSet<Graph>();
            if (dfs(entry.getValue(), stack, visited))
                return false;
        }
        return true;
    }

    public boolean dfs(Graph x, HashSet<Graph> stack, HashSet<Graph> visited) {
        if (stack.contains(x))
            return true;
        if (visited.contains(x))
            return false;
        stack.add(x);
        visited.add(x);
        for (Graph g : x.prereq) {
            boolean flag = dfs(g, stack, visited);
            if (flag)
                return true;
        }
        stack.remove(x);
        return false;
    }
}