class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String token : tokens){
            if(token.equals("*")){
                int num2 = st.peek(); st.pop();
                int num1 = st.peek(); st.pop();
                int val = num1 * num2;
                st.push(val);
            }
            else if(token.equals("/")){
                int num2 = st.peek(); st.pop();
                int num1 = st.peek(); st.pop();
                int val = num1 / num2;
                st.push(val);
            }
            else if(token.equals("+")){
                int num2 = st.peek(); st.pop();
                int num1 = st.peek(); st.pop();
                int val = num1 + num2;
                st.push(val);
            }
            else if(token.equals("-")){
                int num2 = st.peek(); st.pop();
                int num1 = st.peek(); st.pop();
                int val = num1 - num2;
                st.push(val);
            }
            else{
                int num = Integer.parseInt(token);
                st.push(num);
            }
        }

        return st.peek();
    }
}