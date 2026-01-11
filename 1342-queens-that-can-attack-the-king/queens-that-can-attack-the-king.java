class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int board[][] = new int[8][8];

        for(int pos[] : queens){
            board[pos[0]][pos[1]] = 1;
        }

        List<List<Integer>> cnt = new ArrayList<>();

        up(board, king, cnt);
        urd(board, king, cnt);
        right(board, king, cnt);
        lrd(board, king, cnt);
        down(board, king, cnt);
        lld(board, king, cnt);
        left(board, king, cnt);
        uld(board, king, cnt);

        return cnt;
    }

    private void up(int[][] board, int[] king, List<List<Integer>> cnt){
        int r = king[0] - 1;
        int c = king[1];

        while(r>= 0){
            if(board[r][c] == 1){
                List<Integer> list = Arrays.asList(r,c);
                cnt.add(list);
                return;
            }
            r = r-1;
        }
    }

    private void urd(int[][] board, int[] king, List<List<Integer>> cnt){
        int r = king[0] - 1;
        int c = king[1] + 1;

        while(r>=0 && c<board.length){
            if(board[r][c] == 1){
                List<Integer> list = Arrays.asList(r,c);
                cnt.add(list);
                return;
            }
            r = r-1;
            c = c+1;
        }
    }

    private void right(int[][] board, int[] king, List<List<Integer>> cnt){
        int r = king[0];
        int c = king[1] + 1;

        while(c<8){
            if(board[r][c] == 1){
                List<Integer> list = Arrays.asList(r,c);
                cnt.add(list);
                return;
            }
            c = c+1;
        }
    }

    private void lrd(int[][] board, int[] king, List<List<Integer>> cnt){
        int r = king[0] + 1;
        int c = king[1] + 1;

        while(r<8 && c<8){
            if(board[r][c] == 1){
                List<Integer> list = Arrays.asList(r,c);
                cnt.add(list);
                return;
            }
            r = r+1;
            c = c+1;
        }
    }

    private void down(int[][] board, int[] king, List<List<Integer>> cnt){
        int r = king[0] + 1;
        int c = king[1];

        while(r<8){
            if(board[r][c] == 1){
                List<Integer> list = Arrays.asList(r,c);
                cnt.add(list);
                return;
            }
            r = r+1;
        }
    }

    private void lld(int[][] board, int[] king, List<List<Integer>> cnt){
        int r = king[0] + 1;
        int c = king[1] - 1;

        while(r<8 && c>=0){
            if(board[r][c] == 1){
                List<Integer> list = Arrays.asList(r,c);
                cnt.add(list);
                return;
            }
            r = r+1;
            c = c-1;
        }
    }

    private void left(int[][] board, int[] king, List<List<Integer>> cnt){
        int r = king[0];
        int c = king[1] - 1;

        while(c>=0){
            if(board[r][c] == 1){
                List<Integer> list = Arrays.asList(r,c);
                cnt.add(list);
                return;
            }
            c = c-1;
        }
    }

    private void uld(int[][] board, int[] king, List<List<Integer>> cnt){
        int r = king[0] - 1;
        int c = king[1] - 1;

        while(r>=0 && c>=0){
            if(board[r][c] == 1){
                List<Integer> list = Arrays.asList(r,c);
                cnt.add(list);
                return;
            }
            r = r-1;
            c = c-1;
        }
    }
}