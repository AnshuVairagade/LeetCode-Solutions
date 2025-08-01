// Hint : Solve the 

class Solution {
    public String decodeString(String s) {
        if(s.isEmpty() || s.length() == 0) return "";
        Stack<String> st = new Stack<>();
        String open = "[";
        
        for(int i=0; i<s.length(); i++){
            // When digit appears it means you have to count it complete not a character.
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                String num = "";
                while(Character.isDigit(s.charAt(i))){
                    num += s.charAt(i);
                    i++;
                }
                st.push(num);
                i--;
            } // Push every character and '[' onto the stack
            else if(s.charAt(i) != ']'){
                String t = s.charAt(i)+"";
                st.push(t);
            }
            else{
                StringBuilder sb = new StringBuilder();
                while(! (open.equals(st.peek()))){
                    sb.insert(0, st.peek());
                    st.pop();
                }
                st.pop(); // Remove opening brakcet
                String rev = sb.toString();
                int rep = Integer.parseInt(st.peek()); // Number of occurrence
                st.pop();
                String sub = "";
                for(int j=0; j<rep; j++){
                    sub += rev;
                }
                st.push(sub);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.empty()){
            sb.insert(0, st.peek());
            st.pop();
        }
        return sb.toString();
    }
}