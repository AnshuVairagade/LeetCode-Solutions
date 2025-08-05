class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        // Map: distance -> index(smallest)
        // If distance already present no need to calculate;

        HashSet<Integer> set = new HashSet<>();
        int idx = -1;
        int minDis = Integer.MAX_VALUE;

        for(int i=0; i<points.length; i++){
            int point[] = points[i];
            if(point[0] == x || point[1] == y){
                int dis = ((int)Math.abs(x-point[0]) + (int)Math.abs(y-point[1]));
                if(!set.contains(dis) && dis < minDis){
                    minDis = dis;
                    idx = i;
                    set.add(dis);
                }
            }
        } 

        return idx;
    }
}