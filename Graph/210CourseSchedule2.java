class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Kahn's algorithm
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<Integer>());
        for(int[] prereq: prerequisites){
            int courseA = prereq[0];
            int courseB = prereq[1];
            adj.get(courseB).add(courseA);
            inDegree[courseA] += 1;
        }
        Queue<Integer> bfs = new LinkedList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                bfs.add(i);
                ans.add(i);
            }
        }

        while(!(bfs.isEmpty())){
            int x = bfs.poll();
            for(int i: adj.get(x)){
                System.out.println(i);
                inDegree[i] -= 1;
                if(inDegree[i] == 0){
                    bfs.add(i);
                    ans.add(i);
                }
            }
        }
        if(ans.size() != numCourses) return new int[]{};
        for(int i = 0; i < numCourses; i++) inDegree[i] = ans.get(i);
        return inDegree;
    }
    
}