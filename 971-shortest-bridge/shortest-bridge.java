class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;

        int vis[][] = new int[n][n];
        Queue<Pair> queue = new LinkedList<>();

        // breaking outer and inner loop 
        boolean found = false;
        for(int i=0; i<n && !found; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, vis, queue);
                    found = true;
                    break;
                } 
            }
        }

        int flips = bfs(grid, vis, queue);
        return flips;
    }

    private void dfs(int[][] grid, int r, int c, int vis[][], Queue<Pair> queue){
        int n = grid.length;
        
        vis[r][c] = 1;
        if(grid[r][c] == 0){
            queue.offer(new Pair(r, c, 1));
            return;
        }

        for(int d=0; d<4; d++){
            int nr = r + dir[d];
            int nc = c + dir[d+1];

            if(nr<0 || nr>=n || nc<0 || nc>=n || vis[nr][nc] == 1){
                continue;
            }

            dfs(grid, nr, nc, vis, queue);
        }
    }

    private int bfs(int[][] grid, int[][] vis, Queue<Pair> queue){
        int n = grid.length;

        while(!queue.isEmpty()){
            Pair node = queue.poll();
            int r = node.r;
            int c = node.c;
            int d = node.d;

            if(grid[r][c] == 1){
                return d-1;
            }

            for(int k=0; k<4; k++){
                int nr = r + dir[k];
                int nc = c + dir[k+1];

                if(nr<0 || nr>=n || nc<0 || nc>=n || vis[nr][nc] == 1){
                    continue;
                }

                vis[nr][nc] = 1;
                queue.offer(new Pair(nr, nc, d+1));
            }
        }

        return -1;
    }

    int dir[] = {-1, 0, 1, 0, -1};

    class Pair{
        int r;
        int c;
        int d;

        public Pair(int row, int col, int distance){
            this.r = row;
            this.c = col;
            this.d = distance;
        }
    }
}

/*

Intuition
----------
Use DFS for traversing the first island (BFS can also be used).
Use BFS to find the shortest path to the second island.

Approach
---------
Traverse the first island using DFS.
While performing DFS, add all the water boundaries (i, j) where grid[i][j] = 0 of the first island to the queue.
Utilize a multi-source BFS to determine the shortest path to the second island.

*/