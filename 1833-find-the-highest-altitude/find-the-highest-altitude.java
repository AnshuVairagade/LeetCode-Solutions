class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;

        int maxAltitude = 0;
        for(int val : gain){
            altitude += val;
            maxAltitude = Math.max(maxAltitude, altitude);
        }

        return maxAltitude;
    }
}