import java.util.*;
public class Solution {
    public int minimumMoves(int[][] grid) {
        
        int moves = Integer.MAX_VALUE;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(grid[i][j] == 0){

                    for(int r=0; r<3; r++){
                        for(int c=0; c<3; c++){
                            // steps between two cells
                            int d = Math.abs(r-i) + Math.abs(c-j);
                            if(grid[r][c] > 1){
                                grid[r][c]--;
                                grid[i][j]++;
                                moves = Math.min(moves, d + minimumMoves(grid));
                                grid[r][c]++;
                                grid[i][j]--;
                            }
                        }
                    }
                }
            }
        }

        return moves == Integer.MAX_VALUE ? 0 : moves;
    }
}


/* 
To solve this problem try out all possible way mapping extra stone to empty space
TC = O(D!)
where D = number of zeros

See previous submission for understanding


Test Case that fails due to local minima of BFS
[[3,2,0],[0,1,0],[0,3,0]]

*/