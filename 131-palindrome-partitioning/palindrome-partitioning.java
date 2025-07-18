// Typo : Extracting the substring(i, j+1); as j = i start of the loop

class Solution {
    private void solve(int i, String s, List<List<String>> ans, List<String> res){
        if(i==s.length()){
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int j=i; j<s.length(); j++){
            String substr = s.substring(i, j+1);
            if(isPalindrome(substr)){
                res.add(substr);
                solve(j+1, s, ans, res);
                res.remove(res.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        solve(0, s, ans, res);
        return ans;
    }

    private boolean isPalindrome(String s){
        int n = s.length();
        int l=0, r=n-1;
        while(l<=r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}


// Go to each index and try all the possible valid palndrome substring formed by partitioning the original string at all the index i+1.
// Base case : If reach the end of string cannot make partition further