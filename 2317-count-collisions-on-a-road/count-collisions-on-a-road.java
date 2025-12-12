// https://www.youtube.com/watch?v=epv_QKu-P5E

class Solution {
    public int countCollisions(String dir) {
        int n = dir.length();
        
        int left = 0;
        while(left < n && dir.charAt(left)=='L') left++;

        int right = n-1;
        while(right >=0 && dir.charAt(right) == 'R') right--;

        int cnt = 0;
        for(int i=left; i<=right; i++){
            if(dir.charAt(i) == 'S') continue;
            cnt++;
        }

        return cnt;
    }
}

/* 
class Solution {
    public int countCollisions(String dir) {
        int n = dir.length();
        int pnt = 0;

        char prev = dir.charAt(0);
        for(int i=1; i<n; i++){
            char ch = dir.charAt(i);

            while(!st.empty() && check(st, ch)){

            }

            if( prev == 'S' && ch == 'R' || 
                prev == 'L' && ch == 'S' || 
                prev == 'S' && ch == 'S' || 
                prev == 'L' && ch == 'R' ){
                    prev = ch;
            }
            if(prev == 'R' && ch == 'S' || prev == 'S' && ch == 'L'){
                prev = 'S'; pnt++;
            } 
            if(prev == 'R' && ch == 'L') {
                prev = 'S' ; pnt+=2;
            }
        }
        return pnt;
    }
}
*/

// Hint : Direction matters alot

/* Explanation

S R -> R ; 0
R S -> S ; +1
S L -> S ; +1;
L S -> S ; 0
S S -> S ; 0
R L -> S ; +2
L R -> R ; 0

*/


/*
class Solution {
    public int countCollisions(String dir) {
        Stack<Character> st = new Stack<>();
        int n = dir.length();
        int pnt = 0;

        st.push(dir.charAt(0));
        for(int i=1; i<n; i++){
            char ch = dir.charAt(i);
            if(st.peek() == 'S' && ch == 'R') st.push('R');
            if(st.peek() == 'R' && ch == 'S'){
                st.pop(); st.push('S'); pnt++;
            } 
            if(st.peek() == 'S' && ch == 'L'){
                st.pop(); st.push('S'); pnt++;
            }
            if(st.peek() == 'L' && ch == 'S') st.push('S');
            if(st.peek() == 'S' && ch == 'S') st.push('S');
            if(st.peek() == 'L' && ch == 'R') st.push('R');
            if(st.peek() == 'R' && ch == 'L') {
                st.pop(); st.push('S'); pnt+=2;
            }
        }
        return pnt;
    }
}










*/