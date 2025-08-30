class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.' && !valid(board, i, j)) return false;
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int row, int col) {
        char num = board[row][col];
        // Check row
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == num) return false;
        }
        // Check column
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == num) return false;
        }
        // Check subgrid
        int subgridStartRow = 3 * (row / 3);
        int subgridStartCol = 3 * (col / 3);
        for (int i = subgridStartRow; i < subgridStartRow + 3; i++) {
            for (int j = subgridStartCol; j < subgridStartCol + 3; j++) {
                if (i != row && j != col && board[i][j] == num) return false;
            }
        }
        return true;
    }
}