/* 
Previous solution of O(N^4) is wring BFS as it can be treated using multisource BFS instead of calling BFS for each land node

Overall time complexity will be O(N*N)
*/

class Solution {
    int dir[] = {-1, 0, 1, 0, -1,};

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int dist[][] = new int[n][n];
        Queue<Pair> queue = new LinkedList<>();

        for(int row[] : dist){
            Arrays.fill(row, -1);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    dist[i][j] = 0;
                    queue.offer(new Pair(i,j));
                }
            }
        }

        int maxDis = bfs(grid, queue, dist);

        return maxDis;
    }

    private int bfs(int[][] grid, Queue<Pair> queue, int[][] dist){
        int n = grid.length;
        
        int maxDistance = -1;
        while(!queue.isEmpty()){
            Pair node = queue.poll();

            int r = node.r;
            int c = node.c;
            
            for(int d=0; d<4; d++){
                int nr = r + dir[d];
                int nc = c + dir[d+1];

                if(nr < 0 || nr>=n || nc < 0 || nc>=n || grid[nr][nc] == 1){
                    continue;
                }

                if(dist[nr][nc] != -1)  continue;

                dist[nr][nc] = dist[r][c]+1;
                queue.offer(new Pair(nr, nc));
                maxDistance = Math.max(maxDistance, dist[nr][nc]);
            }
        }

        return maxDistance;
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