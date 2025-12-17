class Pair{
    long val;
    int row; 
    int col;

    Pair(int val, int r, int c){
        this.val = val;
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public long maxSpending(int[][] values) {
        int n = values.length;
        int m = values[0].length;

        // PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.val, b.val));
        for(int i=0; i<n; i++){
            pq.offer(new Pair(values[i][m-1], i, m-1));
        }

        int day = 1;
        long res = 0;
        while(!pq.isEmpty()){
            Pair min = pq.poll();
            long mul = (day * min.val);
            res += mul;
            if(min.col > 0){
                pq.offer(new Pair(values[min.row][min.col-1],min.row, min.col-1));
            }
            day++;
        }

        return res;
    }
    
}





/*
Optimized : Merge K sorted list logic

Approach : Use pair with row and col to simulate node selection like linkedlist

TC = O((m*n)log(m*n));
Sc = O(m)

*/



/* Brute force : 

class Solution {
    public long maxSpending(int[][] values) {
        int n = values.length;
        int m = values[0].length;

        int nums[] = new int[m*n];
        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                nums[idx++] = values[i][j];
            }
        }

        Arrays.sort(nums);
        long res = 0;
        for(int i=0; i<m*n; i++){
            res += ((i+1) * nums[i]);
        }

        return res;
    }
}

TC = O((m*n)Log(m*n))
SC = O(m*n)

*/