class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();
        
        int n = senate.length();
        for(int i=0; i<n; i++){
            char ch = senate.charAt(i);
            if(ch == 'R') rq.add(i);
            else dq.add(i);
        }

        while(!rq.isEmpty() && !dq.isEmpty()){
            int ridx = rq.poll();
            int didx = dq.poll();

            if(ridx < didx) rq.add(ridx+n);
            else dq.add(didx+n);
        }

        return rq.isEmpty() ? "Dire" : "Radiant";
    }
}

/* Brute force : Find the next one to kill & repeat until one of count goes zero

class Solution {
    public String predictPartyVictory(String senate) {
        char[] votes = senate.toCharArray();
        int n = votes.length;

        int rcnt = 0, dcnt = 0;
        for (char c : votes) {
            if (c == 'R') rcnt++;
            else dcnt++;
        }

        int i = 0;
        while (rcnt > 0 && dcnt > 0) {
            char curr = votes[i % n];

            // skip banned senators
            if (curr == 'K') {
                i++;
                continue;
            }

            int j = (i + 1) % n;
            int steps = 0;

            if (curr == 'R') {
                while (steps < n) {
                    if (votes[j] == 'D') {
                        votes[j] = 'K';
                        dcnt--;
                        break;
                    }
                    j = (j + 1) % n;
                    steps++;
                }
            } else { // curr == 'D'
                while (steps < n) {
                    if (votes[j] == 'R') {
                        votes[j] = 'K';
                        rcnt--;
                        break;
                    }
                    j = (j + 1) % n;
                    steps++;
                }
            }

            i++;
        }

        return rcnt > 0 ? "Radiant" : "Dire";
    }
}
*/