class Solution {
    public String largestNumber(int[] nums) {
        Integer[] numsAsInteger = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(numsAsInteger, (a,b)->{
            String s1 = Integer.toString(a);
            String s2 = Integer.toString(b);
            return (s2+s1).compareTo(s1+s2);
        });

        if(numsAsInteger[0] == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(int num : numsAsInteger){
            sb.append(num);
        }

        return sb.toString();
    }
}


/*

Brute Force : 
-----------------

Intuition : Generate all possible number permutation 
Approach : DP
TC = O(n!)
SC = O(n!)


Optimal Solution :
Intuition : Using custom comparator to build the number 
Approach : Build number digit by digit
TC = O()
SC = O()

 */