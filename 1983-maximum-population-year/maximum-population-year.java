class Solution {
    public int maximumPopulation(int[][] logs) {
        int maxCnt = 0;
        int ans = 0;

        for(int year=1950; year<=2050; year++){
            int cnt = 0;
            for(int i=0; i<logs.length; i++){
                if(logs[i][0] <= year && logs[i][1] > year){
                    cnt++;
                }
            }
            if(cnt > maxCnt){
                maxCnt = cnt;
                ans = year;
            }
        }

        return ans;
    }
}