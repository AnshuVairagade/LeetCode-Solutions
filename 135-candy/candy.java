class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int maxRating = 0;
        for(int i=0; i<ratings.length; i++){
            List<Integer> list = map.getOrDefault(ratings[i], new ArrayList<>());
            list.add(i);
            map.put(ratings[i], list);

            maxRating = Math.max(maxRating, ratings[i]);
        }

        int[] candies = new int[n];
        for(int rating=0; rating<=maxRating; rating++){
            if(!map.containsKey(rating)) continue;
            
            List<Integer> list = map.get(rating);
            for(int i : list){
                int pr = i>0 ? ratings[i-1] : 0;
                int nr = i+1<n ? ratings[i+1] : 0;
                int pc = i>0 ? candies[i-1] : 0;
                int nc = i+1<n ? candies[i+1] : 0;
                int cr = ratings[i];

                if(pr<cr && cr>nr){
                    candies[i] = Math.max(pc, nc) + 1;
                }
                else if(pr < cr){
                    candies[i] = pc + 1;
                }
                else if(nr < cr){
                    candies[i] = nc + 1;
                }
                else candies[i] =  1;
            }
        }

        int totalCandies = 0;
        for(int cnt : candies) totalCandies += cnt;

        return totalCandies;
    }
}

/*

Approach : 
1) Distribute candies from lower rating to higher rating
2) To assign candies check previous and next rating conditions


TC = O( n + max)
SC = O(n + n)

Edge Cases:

Test case 1
[1,2,87,4,3,2,1]


Test case 2
[1,2,87,87,87,2,1]


Test case 3
[1,2,3,1,3,2,1]


Test case 4
[1,2,5,4,3,2,1]


Test case 5
[1,2,4,4,3]


Test case 6
[1,2,5,4,3,2]


 */