class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Sorting daigonals starting from row
        for(int i=0; i<n; i++) sortDaigonal(i, 0, mat);

        // Sorting daigonals starting from column
        for(int j=1; j<m; j++) sortDaigonal(0, j, mat);

        return mat;
    }

    private void sortDaigonal(int s, int e, int[][] mat){
        List<Integer> list = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length; 

        int r = s, c = e;
        while(r<n && c<m) list.add(mat[r++][c++]);

        Collections.sort(list);

        r = s; c = e;
        int idx = 0;
        while(r<n && c<m) mat[r++][c++] = list.get(idx++);
    }
}