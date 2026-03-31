class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();

        int fact = 1;   // initialization
        for(int i=1; i<=n; i++){
            nums.add(i);
            if(i==n) continue;
            fact = fact * i;
        }

        StringBuilder sb = new StringBuilder();
        k = k-1; // 0 based indexing

        while(true){
            sb.append(nums.get(k/fact));  // }  step 1
            nums.remove(k/fact);          // }
            if(nums.size() == 0) break;   // }  stoppage
            k = k%fact;                   // }  
            fact = fact/nums.size();      // }  step 2
        }

        return sb.toString();
    }
}