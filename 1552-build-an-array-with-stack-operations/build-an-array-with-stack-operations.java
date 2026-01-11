class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();

        int idx = 0, stream = 1;
        while(idx < target.length){
            if(target[idx] == stream){
                res.add("Push");
                idx++;
            }
            else{
                res.add("Push");
                res.add("Pop");
            }
            stream++;
        }

        return res;
    }
}

