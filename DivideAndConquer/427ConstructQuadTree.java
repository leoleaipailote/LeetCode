/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, grid.length - 1, 0, grid.length - 1);
    }

    public Node helper(int[][] grid, int sRow, int eRow, int sCol, int eCol) {
        boolean allSame = true;
        int val = grid[sRow][sCol];
        for (int i = sRow; i <= eRow; i++) {
            for (int j = sCol; j <= eCol; j++) {
                if (grid[i][j] != val) {
                    allSame = false;
                    break;
                }
            }
            if (!(allSame))
                break;
        }
        if (allSame)
            return new Node(grid[sRow][sCol] == 1, true);

        Node x = new Node();
        int midRow = sRow + (eRow - sRow) / 2 + 1;
        int midCol = sCol + (eCol - sCol) / 2 + 1;

        x.topLeft = helper(grid, sRow, midRow - 1, sCol, midCol - 1);
        x.topRight = helper(grid, sRow, midRow - 1, midCol, eCol);
        x.bottomLeft = helper(grid, midRow, eRow, sCol, midCol - 1);
        x.bottomRight = helper(grid, midRow, eRow, midCol, eCol);
        return x;
    }
}
