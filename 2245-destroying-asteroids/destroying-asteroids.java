class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n = asteroids.length;
        Arrays.sort(asteroids);

        long pm = mass;
        for(int i=0; i<n; i++){
            long am = 1L*asteroids[i];
            if(am > pm) return false;
            pm = pm + am;
        }

        return true;
    }
}


// mp = 4
// am = [7]