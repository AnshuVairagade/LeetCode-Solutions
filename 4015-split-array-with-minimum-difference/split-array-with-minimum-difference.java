
class Solution {
    public long splitArray(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        long lsum = 0, rsum = 0;

        while (l < n - 1 && arr[l] < arr[l + 1]) {
            lsum += arr[l];
            l++;
        }

        while (r > 0 && arr[r - 1] > arr[r]) {
            rsum += arr[r];
            r--;
        }
      
        if (l==r){
        long option1 = Math.abs((lsum + arr[l]) - rsum);
        long option2 = Math.abs(lsum - (rsum + arr[l]));

        return Math.min(option1, option2);
        }
      
        else if(arr[l]==arr[r]&&r-l==1){
              long option1 = Math.abs((lsum  - rsum));
      return option1;
        }
     
        else  return -1;
    }
}