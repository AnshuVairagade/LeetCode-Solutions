class Solution {
    private int solve(int i, int[][] board){
        if(i == board.length) return 1;

        int cnt = 0;
        for(int j=0; j<board.length; j++){
            if(isSafe(i, j, board)){
                board[i][j] = 1;
                cnt += solve(i+1, board);
                board[i][j] = 0;
            }
        }
        return cnt;
    }

    public int totalNQueens(int n) {
        int board[][] = new int[n][n];
        return solve(0, board);
    }

    private boolean isSafe(int r, int c, int[][] board){
        int n  = board.length;
        // Checking the row and column
        for(int i=0; i<n; i++){
            if(board[i][c] == 1 || board[r][i] == 1) return false;
        }
        // checking the left daigonal
        for(int i = r, j = c; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 1)return false;
        }
        // Checking the right daigonal
        for(int i = r, j = c; i>=0 && j<board[0].length; i--, j++){
            if(board[i][j] == 1) return false;
        }
        return true;
    }
}