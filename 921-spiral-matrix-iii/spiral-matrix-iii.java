class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int nr, int nc) {
        List<int[]> ans = new ArrayList<>();
        int dir[][] = {{0,1}, {1,0}, {0,-1},{-1,0}};
        int cells = rows * cols;
        int steps = 0;        
        int k = 0;

        if(nr>=0 && nc>=0 && nr<rows && nc<cols){
            ans.add(new int[]{nr, nc});
        }

        while(ans.size() < cells){
            if(k == 0 || k == 2){
                steps++;
            }
            // Take the number of steps in one direction
            for(int i=0; i<steps; i++){
                nr = nr + dir[k][0];
                nc = nc + dir[k][1];
                if(nr>=0 && nc>=0 && nr<rows && nc<cols){
                    ans.add(new int[]{nr, nc});
                } 
            }
            // Change the direction
            k = (k+1)%4;
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}