class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        int hash[] = new int[26];
        for(char ch : s.toCharArray()){
            hash[ch-'a']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.cnt - a.cnt);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<26; i++){
            if(hash[i] == 0) continue;
            pq.offer(new Pair(i, hash[i]));
        }

        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            int ch1 = p1.ch;

            sb.append((char)(ch1+'a'));

            if(pq.isEmpty()){
                if(p1.cnt>1) return "";
                break;
            }

            Pair p2 = pq.poll();
            int ch2 = p2.ch;

            sb.append((char)(ch2+'a'));
            
            if(p1.cnt > 1) pq.offer(new Pair(ch1, p1.cnt-1));
            if(p2.cnt > 1) pq.offer(new Pair(ch2, p2.cnt-1));
        }

        return sb.toString();
    }
}

class Pair{
    int ch;
    int cnt;

    public Pair(int ch, int cnt){
        this.ch = ch;
        this.cnt = cnt;
    }
}