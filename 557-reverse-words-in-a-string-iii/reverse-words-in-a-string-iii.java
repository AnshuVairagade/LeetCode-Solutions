class Solution {
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        
        for(int i=0; i<words.length; i++){
            char[] word = words[i].toCharArray();
            int l=0, r = word.length-1;
            while(l<r){
                char temp = word[l];
                word[l] = word[r];
                word[r] = temp;
                l++; r--;
            }
            words[i] = new String(word);
        }

        String ans = String.join(" ",words);
        return ans;
    }
}