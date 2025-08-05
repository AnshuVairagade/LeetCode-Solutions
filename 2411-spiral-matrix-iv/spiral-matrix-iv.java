
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int mat[][] = new int[m][n];

        ListNode temp = head;
        int left = 0, top = 0;
        int right = n-1, bottom = m-1;
        while(top<=bottom && left<=right){
            // top row : left -> right
            for(int j=left; j<=right; j++){
                mat[top][j] = (temp == null) ? -1 : temp.val;
                if(temp != null) temp = temp.next; 
            }
            top++;
            
            // right column : top -> bottom
            for(int i=top; i<=bottom; i++){
                mat[i][right] = (temp == null) ? -1 : temp.val;
                if(temp != null) temp = temp.next; 
            }
            right--;

            // bottom row : right -> left
            if(top <= bottom){
                for(int j=right; j>=left; j--){
                    mat[bottom][j] = (temp == null) ? -1 : temp.val;
                    if(temp != null) temp = temp.next; 
                }
                bottom--;
            }

            // left column : bottom -> top
            if(left <= right){
                for(int i=bottom; i>=top; i--){
                    mat[i][left] = (temp == null) ? -1 : temp.val;
                    if(temp != null) temp = temp.next; 
                }   
                left++;
            }
        }
        

        return mat;
    }
}