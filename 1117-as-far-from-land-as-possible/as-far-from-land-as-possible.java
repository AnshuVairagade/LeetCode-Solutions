
/* This solution is O(N^4) as it makes call for each land cell to perform BFS

There are m*n land cells then BFS will be called
and each BFS checks for m*n cells

*/

class Solution {
    int dir[] = {-1, 0, 1, 0, -1,};

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int dist[][] = new int[n][n];

        for(int row[] : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    bfs(grid, i, j, dist);
                }
            }
        }

        int cntLand = 0;
        int maxDis = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0) cntLand++;
                maxDis = Math.max(dist[i][j], maxDis);
            }
        }

        if(cntLand == n*n || cntLand == 0) return -1;

        return maxDis;
    }

    private void bfs(int[][] grid, int r, int c, int[][] dist){
        int n = grid.length;
        Queue<Pair> queue = new LinkedList<>();

        dist[r][c] = 0;
        queue.offer(new Pair(r,c));
        while(!queue.isEmpty()){
            Pair node = queue.poll();

            // Possible bug chance of using r and c without reinitalization
            r = node.r;
            c = node.c;
            
            for(int d=0; d<4; d++){
                int nr = r + dir[d];
                int nc = c + dir[d+1];

                if(nr < 0 || nr>=n || nc < 0 || nc>=n || grid[nr][nc] == 1){
                    continue;
                }

                if(dist[nr][nc] > dist[r][c]+1){
                    dist[nr][nc] = dist[r][c]+1;
                    queue.offer(new Pair(nr, nc));
                }
            }
        }
    }

    class Pair{
        int r;
        int c;

        public Pair(int row, int col){
            this.r = row;
            this.c = col;
        }
    }
}