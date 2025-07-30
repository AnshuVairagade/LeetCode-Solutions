class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;
        long total = 0;

        int nse[] = findNextSmallerElelemt(arr);
        int pse[] = findPrevSmallerElement(arr);


        for(int i=0; i<n; i++){
            int le = i - pse[i];
            int re = nse[i] - i;
            total = (total + (re*le* (long)arr[i])%mod)%mod;
        }

        return (int)total;
    }

    private int[] findNextSmallerElelemt(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int nse[] = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!st.empty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.empty()) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        return nse;
    }

    private int[] findPrevSmallerElement(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int pse[] = new int[n];
        for(int i=0; i<n; i++){
            while(!st.empty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.empty()) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
        return pse;
    }
}