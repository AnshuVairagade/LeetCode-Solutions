/*

Core concept: 
-------------
While traversing if one path decrements the value of k globally then it affects the other path as k value is decremented globally.
We need to revert back the change k value if path fails.
For that purpose, k value should be separately used for each path

Bug catching:
-------------

In this problem, state is not just (row, col).
State is (row, col, remaining k).

Reaching the same cell with:

more remaining obstacle eliminations
fewer remaining obstacle eliminations

are completely different states.

Your grid has long alternating rows of obstacles and empty rows.
The optimal path requires revisiting the same cell multiple times with different k values.

By using vis[m][n], you prematurely block valid paths that have a better remaining k.

Visited must track remaining eliminations:
boolean vis[m][n][k+1];

*/

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        boolean vis[][][] = new boolean[m][n][k+1];
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(0, 0, 0, k));
        vis[0][0][k] = true;
        while(!queue.isEmpty()){
            Pair node = queue.poll();
            int r = node.r;
            int c = node.c;
            int s = node.s;
            int o = node.k;

            if(r== m-1 && c == n-1){
                return s;
            }

            for(int d=0; d<4; d++){
                int nr = r + dir[d];
                int nc = c + dir[d+1];

                if(nr<0 || nr>=m || nc<0 || nc>=n ){
                    continue;
                }

                int nextK = o - grid[nr][nc];

                if(nextK < 0) continue;

                if(vis[nr][nc][nextK]) continue;

                vis[nr][nc][nextK] = true;
                queue.offer(new Pair(nr, nc, s+1, nextK));
            }
        }

        return -1;
    }

    int dir[] = {-1, 0, 1, 0, -1};

    class Pair{
        int r;
        int c;
        int s;
        int k;  // obstacle can be destroyed in future path;

        public Pair(int row, int col, int steps, int k){
            this.r = row;
            this.c = col;
            this.s = steps;
            this.k = k;
        }
    }
}