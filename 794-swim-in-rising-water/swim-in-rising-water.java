// https://leetcode.com/problems/swim-in-rising-water/solutions/6952942/swim-in-rising-water-dijkstra-s-with-min-heap-java-beats-100

class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid.length;
        int dir[] = {-1, 0, 1 , 0, -1};
        int vis[][] = new int[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.add(new int[]{grid[0][0], 0, 0});
        vis[0][0] = 1;
        int ans = 0;

        while(!pq.isEmpty()){
            int node[] = pq.poll();
            int r = node[1], c = node[2], w = node[0];
            ans = Math.max(ans, w);

            if(r==m-1 && c==n-1) return ans;

            for(int i=0; i<4; i++){
                int nr = r+dir[i];
                int nc = c+dir[i+1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && vis[nr][nc] == 0){
                    vis[nr][nc] = 1;
                    pq.add(new int[]{grid[nr][nc], nr, nc});
                }
            }
        }

        return ans;
    }
}