class Solution {
    int n;
    int total;

    public int totalNQueens(int n) {
        this.n = n;
        this.total = 0;
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++)
            helper(0, board, 0, i);
        return total;
    }

    public boolean helper(int count, int[][] board, int row, int col) {
        if (count == n - 1 && board[row][col] != -1) {
            total += 1;
            return true;
        }
        if (board[row][col] == -1)
            return false;

        int[][] boardCopy = copyBoard(board);
        fillGrid(boardCopy, row, col);
        for (int i = row; i < n; i++) {
            for (int j = col; j < n; j++) {
                if (i == n - 1 && j == n - 1)
                    break;
                else if (j == n - 1)
                    helper(count + 1, boardCopy, i + 1, 0);
                else
                    helper(count + 1, boardCopy, i, j + 1);
            }
            col = 0;
        }
        return true;
    }

    public int[][] copyBoard(int[][] board) {
        int[][] boardCopy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                boardCopy[i][j] = board[i][j];
        }
        return boardCopy;
    }

    public void fillGrid(int[][] board, int row, int col) {
        for (int i = 0; i < n; i++) {
            board[row][i] = -1;
            board[i][col] = -1;
        }
        for (int i = row; i < n; i++) {
            if (col + i - row < n)
                board[i][col + i - row] = -1;
            if (col - i + row >= 0)
                board[i][col - i + row] = -1;
        }
        for (int i = row; i >= 0; i--) {
            if (col + i - row >= 0)
                board[i][col + i - row] = -1;
            if (col - i + row < n)
                board[i][col - i + row] = -1;
        }
    }
}