class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int grid[][] = new int[m][n];

        for(int guard[] : guards){
            grid[guard[0]][guard[1]] = 1;
        }

        for(int wall[] : walls){
            grid[wall[0]][wall[1]] = -1;
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 2;
                    traverse(m, n, grid, i, j);
                    grid[i][j] = 1;
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void traverse(int m, int n, int[][] grid, int i, int j){
        int r = i;
        int c = j;

        // up 
        while(r >= 0){
            if(grid[r][c] == -1 || grid[r][c] == 1){
                break;
            }
            grid[r][c] = 2;
            r = r-1;
        }

        // down
        r = i;
        c = j;
        while(r<m){
            if(grid[r][c] == -1 || grid[r][c] == 1){
                break;
            }
            grid[r][c] = 2;
            r = r+1;
        }

        // left 
        r = i;
        c = j;
        while(c>=0){
            if(grid[r][c] == -1 || grid[r][c] == 1){
                break;
            }
            grid[r][c] = 2;
            c = c-1;
        }
    
        // right
        r = i;
        c = j;
        while(c<n){
            if(grid[r][c] == -1 || grid[r][c] == 1){
                break;
            }
            grid[r][c] = 2;
            c = c+1;
        }
    }
}


/*

TC = O(m*n) as once visted node is not called further

TC = O(m*n * (m+n)) => O(N*N*N) if m = n and will cause TLE


unvisted = 0
Guard = 1
Wall = -1
visited = 2;

*/