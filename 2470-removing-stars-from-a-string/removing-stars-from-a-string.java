class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == '*'){
                sb.deleteCharAt(sb.length()-1);
            }
            else sb.append(ch);
        }

        return sb.toString();
    }
}


/* 
Stack can be used to remove previous element from top for each *, but uses extra space of O(N)

To remove stack we can use StringBuilder and delete from end
*/