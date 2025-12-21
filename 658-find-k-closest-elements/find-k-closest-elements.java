class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        List<Integer> list = new ArrayList<>();
        
        int idx = findPosition(arr, x);
        int left = idx -1, right = idx;

        while(k > 0 && left>=0 && right <n){
            if(Math.abs(arr[left]-x) > Math.abs(arr[right]-x)){
                list.add(arr[right]);
                right++;
            }
            else{
                list.add(arr[left]);
                left--;
            }

            k--;
        }
        while(k> 0 && left >= 0){
            list.add(arr[left--]);
            k--;
        }
        while(k> 0 && right < n){
            list.add(arr[right++]);
            k--;
        }

        Collections.sort(list);
        return list;
    }

    private int findPosition(int[] nums, int x){
        int low = 0, high = nums.length-1;

        while(low < high){
            int mid = (low + high)/2;

            if(nums[mid] >= x){
                high = mid;
            }
            else low = mid + 1;
        }

        return low;
    }
}




/*
Since the X do not lies inside array as shown in example testcase 2
hence it is invalid solution
Entire logic of binary search fails

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        int idx = findPosition(arr, x);
        List<Integer> list = new ArrayList<>();
        list.add(x); k--;
        int left = idx -1, right = idx+1;

        while(k > 0 && left>=0 && right <n){
            if(arr[left] > arr[right]){
                list.add(arr[right]);
                right++;
            }
            else{
                list.add(arr[left]);
                left--;
            }

            k--;
        }
        while(k> 0 && left >= 0){
            list.add(arr[left--]);
            k--;
        }
        while(k> 0 && right < n){
            list.add(arr[right++]);
            k--;
        }

        Collections.sort(list);
        return list;
    }

    private int findPosition(int[] nums, int x){
        int low = 0, high = nums.length-1;

        while(low < high){
            int mid = (low + high)/2;

            if(nums[mid] == x){
                return mid;
            }
            else if(nums[mid] > x){
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return -1;
    }
}

*/


/* 

Brute force : 
-------------
1) Build the pair and sort on the basis of distance from the point
2) Use maxHeap of size k

Optimal Solution :
------------------
Intuition : Binary Seach + Two pointer

Approach:
1) Find the position of x -> i
2) start two pointer from i-1 to i+1
3) Add lesser element to ans

TC = O(log(n) + k)

*/