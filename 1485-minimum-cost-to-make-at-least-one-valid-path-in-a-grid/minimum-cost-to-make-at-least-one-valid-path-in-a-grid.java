class Solution {
    int dir[][] = {{-1,-1}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        int costFromSource[][] = new int[m][n];
        for(int row[] : costFromSource){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.offer(new int[]{0, 0, 0});
        
        while(!pq.isEmpty()){
            int cell[] = pq.poll();

            int r = cell[0];
            int c = cell[1];
            int cost = cell[2];

            if(r<0 || r>=m || c<0 || c>= n){
                continue;
            }

            if(cost >= costFromSource[r][c]){
                continue;
            }
            // System.out.println(r+" "+c+" "+cost);

            if(r == m-1 && c == n-1){
                return cost;
            }

            costFromSource[r][c] = cost;

            for(int d=1; d<=4; d++){
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];
                int newCost = cost;  // bug point

                if(d != grid[r][c]) newCost += 1 ;
                pq.offer(new int[]{nr, nc, newCost});
            }
        }

        return -1;
    }
}