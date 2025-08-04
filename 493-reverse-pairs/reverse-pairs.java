// Merge Sort Pattern : i < j && nums[i] > 2 * nums[j].

class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n-1);
    }

    private int countPairs(int nums[], int low, int mid, int high){
        int cnt = 0;
        int j = mid+1;
        for(int i=low; i<=mid; i++){
            while(j<=high && (long)nums[i] > 2L * nums[j]){
                j++;
            }
            cnt += (j - (mid+1));
        }
        return cnt;
    }

    private int mergeSort(int nums[], int low, int high){
        if(low >= high) return 0;
        int mid = (low+high)/2;
        int left = mergeSort(nums, low, mid);
        int right = mergeSort(nums, mid+1, high);
        int curr = countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

        return left + right + curr;
    }

    private void merge(int nums[], int low, int mid, int high){
        int n1 = mid-low+1;
        int n2 = high-mid;
        int left[] = new int[n1];
        int right[] = new int[n2];

        for(int i=0; i<n1; i++) left[i] = nums[i+low];
        for(int j=0; j<n2; j++) right[j] = nums[j+mid+1];

        int i = 0, j = 0, idx = low;
        while( i<n1 && j<n2){
            if(left[i] > right[j]){
                /* Wrong logic to calculate pairs
                if(left[i] > (2 * right[j])){
                    cnt += (n1-i);
                } */
                nums[idx++] = right[j++];
            }
            else nums[idx++] = left[i++];
        }
        while(i < n1)  nums[idx++] = left[i++];
        while(j < n2) nums[idx++] = right[j++];

    }
}