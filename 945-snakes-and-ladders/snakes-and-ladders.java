class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        boolean[][] vis = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        vis[n - 1][0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) return steps;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) break;

                    int[] pos = getCoordinates(next, n);
                    int r = pos[0], c = pos[1];

                    if (vis[r][c]) continue;
                    vis[r][c] = true;

                    if (board[r][c] != -1) {
                        queue.offer(board[r][c]);
                    } else {
                        queue.offer(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private int[] getCoordinates(int val, int n) {
        int row = n - 1 - (val - 1) / n;
        int col = (val - 1) % n;

        if ((n - row) % 2 == 0) {
            col = n - 1 - col;
        }
        return new int[]{row, col};
    }
}
