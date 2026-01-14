// Code Documentation are given below

class TimeMap {
    HashMap<String, List<Pair>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());

        Pair pair = new Pair(timestamp, value);
        list.add(pair);

        map.put(key, list);        
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if(list == null) return "";

        int low = 0, high = list.size() - 1;
        while(low<=high){
            int mid = (low + high) / 2;

            int timeMid =  list.get(mid).timestamp;
            
            if(timeMid == timestamp){
                low = mid + 1;
            }
            else if(timeMid > timestamp){
                high = mid - 1;
            }
            else low = mid + 1;
        }

        String val = low > 0 ? list.get(low-1).value : "";

        return val;
    }

    class Pair{
        int timestamp;
        String value;

        public Pair(int t, String v){
            this.timestamp = t;
            this.value = v;
        }
    }
}

/*

Appraoch : 
Binary Search can be used as the pairs are sorted by timestamp
Find the UpperBound of timestamp and return value of idx-1 th pair

TC = O(calls * log(timestamp)) => 2 * 10^5 * lgo(10^7) ~ 10^6 - 10^7
This will pass TLE

*/


/*
 Brute force : 
Linear Search for get method


class TimeMap {
    HashMap<String, List<Pair>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());

        Pair pair = new Pair(timestamp, value);
        list.add(pair);

        map.put(key, list);        
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if(list == null) return "";

        String val = "";
        for(Pair pair : list){
            if(pair.timestamp > timestamp) break;
            val = pair.value;
        }

        return val;
    }

    class Pair{
        int timestamp;
        String value;

        public Pair(int t, String v){
            this.timestamp = t;
            this.value = v;
        }
    }
}

TC = O(n * t) => (2 * 10^5 * 10^7)  ? TLE
n = number of calls and t = timestamp
 
*/

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */