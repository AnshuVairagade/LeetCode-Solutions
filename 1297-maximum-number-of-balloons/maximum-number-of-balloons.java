class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();

        int hash[] = new int[26];
        int cnt = 0;

       for(int i=0; i<n; i++){
            hash[text.charAt(i)-'a']++;

            if(isValid(hash)){
                System.out.println(i);
                cnt++;
                reduce(hash);
            }
        }

        return cnt;
    }

    private boolean isValid(int[] hash){
        int cnt = 0;
        cnt += hash['a'-'a'] > 0 ? 1 : 0;
        cnt += hash['b'-'a'] > 0 ? 1 : 0;
        cnt += hash['l'-'a'] > 1 ? 1 : 0;
        cnt += hash['o'-'a'] > 1 ? 1 : 0;
        cnt += hash['n'-'a'] > 0 ? 1 : 0;

        return cnt == 5;
    }

    private void reduce(int[] hash){
        int cnt = 0;
        hash['a'-'a']--;
        hash['b'-'a']--;
        hash['l'-'a'] -= 2;
        hash['o'-'a'] -= 2;
        hash['n'-'a'] -= 1;
    }
}

/*

    ['a','b','l','o','n'] -> only check for valid frequencies

    check:
    if balloon -> delete character -> increment count 

Edge Case: 
"looonbalxballpoonballon" -> Extra Character in previous section, can we use 
    ^             ^    ^        it in futue???
    |             |____| 
  extra           needed

*/