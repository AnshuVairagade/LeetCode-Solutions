// https://www.youtube.com/watch?v=xEdI2qT4OOU

class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(row[i], i);
        }

        int cnt = 0;
        for(int i=0; i<n-1; i+=2){
            int next = row[i+1];
            if(row[i] %2 == 0){
                if(row[i+1] == row[i]+1) continue;
                
                int idx = map.get(row[i]+1);
                swap(row, i+1, idx);
                map.put(next, idx);
                cnt++;
            }
            if(row[i] %2 == 1){
                if(row[i+1] == row[i]-1) continue;
                
                int idx = map.get(row[i]-1);
                swap(row, i+1, idx);
                map.put(next, idx);
                cnt++;
            }
        }

        return cnt;
    }

    private void swap(int[] row, int i, int j){
        int temp = row[j];
        row[j] = row[i];
        row[i] = row[j];
    }
}