class Solution {
    private void solve(int i, int cnt, String ip, String s, List<String> ans){
        if(cnt > 4) return;
        if(i == s.length()){
            if(cnt == 4) {
                ans.add(ip.substring(0, ip.length() -1));
            }
            return;
        }

        if(s.charAt(i) == '0'){
            solve(i+1, cnt+1, ip+"0.", s, ans);
        }
        else{
            for(int j=1; j<=3 && j+i<=s.length(); j++){
                int num = Integer.parseInt(s.substring(i, i+j));
                if(num > 255) break;
                solve(i+j, cnt+1, ip+num+'.', s, ans);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if(s.isEmpty()) return ans;
        if(s.length() < 4 || s.length() > 12) return ans;
        solve(0, 0, "", s, ans);
        return ans;
    }
}