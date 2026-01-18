// Documentation given below

class Solution {
    public int repeatedStringMatch(String a, String b) {
        int cnt = 0;
        String ans = "";
        
        while(ans.length() < b.length()){
            ans = ans + a;
            cnt++;
        }

        if(ans.contains(b)) return cnt;

        ans = ans + a;
        cnt++;

        if(ans.contains(b)) return cnt;
    
        return -1;
    }
}


/*
TC = O(m + m + )

Solution : https://www.youtube.com/watch?v=tfLuxPI-q8g


For better solution use KMP:
https://youtu.be/TClogJNShFk?si=1x7jk0xi9WEdRMUg

*/