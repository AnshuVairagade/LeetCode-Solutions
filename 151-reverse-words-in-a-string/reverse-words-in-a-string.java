class Solution {
    public String reverseWords(String s) {
        String words[] = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>=0; i--){
            if(words[i].length() == 0 || words[i].equals(" ")) continue;

            sb.append(words[i]);
            if(i > 0) sb.append(" ");
        }

        // return sb.toString()  --> Bug of trailing space 

        String str = sb.toString();
        
        return str.trim();  
    }
}

/* 

Bug: Extra space at the end 
    Input: "  hello world  " 
    Output: ["", "hello", "world"]

edge cases :

1) Leading & Trailing Space
    Input: "  hello world  "
    Output: "world hello"


2) Multiple Spaces Between Words
    Input: "a   good   example"
    Output: "example good a"


3) Only Spaces
    Input:  "     "
    Output: ""


4) Spaces Everywhere
    Input:  "   the   sky   is   blue   "
    Output: "blue is sky the"

*/
