class DisjointSet{
    int parent[];
    int size[];

    public DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; 
            size[i] = 1; 
        }
    }

    public int findParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    public void union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv) return;
        if(size[pu] > size[pv]){
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
    public int parentCnt(){
        int cnt = 0;
        for(int i=0; i<parent.length; i++){
            if(parent[i] == i) cnt++;
        }
        return cnt;
    }
}


class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 0) continue;

                ds.union(i, j);
            }
        }

        return ds.parentCnt();
    }
}