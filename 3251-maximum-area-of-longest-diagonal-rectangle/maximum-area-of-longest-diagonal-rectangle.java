class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int maxArea = Integer.MIN_VALUE;
        int maxDaig = Integer.MIN_VALUE;

        for(int dim[] : dimensions){
            int diagonal = dim[0]*dim[0] + dim[1]*dim[1];
            int area = dim[0] * dim[1];
            if(diagonal > maxDaig){
                maxDaig = diagonal;
                maxArea = area;
            }
            else if(diagonal == maxDaig){
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}