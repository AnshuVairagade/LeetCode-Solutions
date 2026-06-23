class Solution {
    public String simplifyPath(String path) {
        int n = path.length();

        Stack<String> st = new Stack<>();
        
        for(int i=1; i<n; i++){
            StringBuilder sb = new StringBuilder();

            while(i<n && path.charAt(i) != '/'){
                sb.append(path.charAt(i)); 
                i++;
            }

            String dirName = sb.toString();

            if(dirName.isEmpty() || dirName.equals(".")){
                continue;
            }
            else if(dirName.equals("..")){
                if(!st.empty()) st.pop();
            }
            else{
                st.push(dirName);
            }
        }

        StringBuilder sb = new StringBuilder();

        // The parsing part is O(n), but the path construction makes the overall complexity O(n²).

        while(!st.isEmpty()){
            sb.insert(0, "/" + st.pop());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}

/*


Stack: 
        Pictures
        user
        home

/Pictures/user/home

user/Pictures

*/