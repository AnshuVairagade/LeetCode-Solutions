class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Integer.MIN_VALUE;
        List<Boolean> list = new ArrayList<>();

        int n = candies.length;
        for(int candy : candies){
            maxCandies = Math.max(candy, maxCandies);
        }

        for(int candy : candies){
            int curr = candy + extraCandies;

            if(curr >= maxCandies){
                list.add(true);
            }
            else list.add(false);
        }        

        return list;
    }
}