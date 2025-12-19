class Solution {
    public int countPrimes(int n) {
        boolean primes[] = new boolean[n];

        for(int i=2;i<n; i++){
            primes[i] = true;
        }

        // Sieve of Erastothenes
        for(int i=2; i*i<n; i++){
            if(!primes[i]) continue;

            // mark all multiple
            for(int j=i*i; j<n; j+=i){
                if(j%i == 0) primes[j] = false;
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            if(primes[i]) cnt++;
        }

        return cnt;
    }
}