class Solution {
    public int candy(int[] rating) {
        int n = rating.length;
        int[] count = new int[n];
        
        for(int i = 0; i< n ; i++){
            count[i]=1;
        }
        for(int i = 1; i < n;i++){
            if(rating[i]>rating[i-1]){
                count[i]=count[i-1]+1;
            }
        }
        for(int i = n-2; i>=0;i--){
            if(rating[i]>rating[i+1]){
                count[i]=Math.max(count[i],count[i+1]+1);
            }
        }
        
        int ans = 0; 
        for(int i = 0; i< n ;i++){
            ans+=count[i];
        }
        
        return ans;
    }
}