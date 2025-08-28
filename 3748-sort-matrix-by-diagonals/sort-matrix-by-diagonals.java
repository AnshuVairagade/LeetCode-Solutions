class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Sorting daigonals starting with row
        for(int i=0; i<n; i++){
            sortDaigonal(i, 0, grid, false);
        }

        // Sorting daigonals starting with column
        for(int j=1; j<m; j++){
            sortDaigonal(0, j, grid, true);
        }

        return grid;
    }
    
    private void sortDaigonal(int s, int e, int[][] grid, boolean order){
        List<Integer> list = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;

        int r = s, c = e;
        while(r <n && c<m){
            list.add(grid[r++][c++]);
        }

        if(order == true) Collections.sort(list);
        else Collections.sort(list, Collections.reverseOrder());

        r = s; c = e;
        int idx = 0;
        while(r <n && c<m){
            grid[r++][c++] = list.get(idx++);
        }
    }
}