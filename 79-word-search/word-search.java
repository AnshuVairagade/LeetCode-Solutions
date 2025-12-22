/*

BackTracking -> TO avoid use of previously visited state use vis[][] or simply replace the current cell value with '.' and then replace back with original value
It reduces space complexity


Follow up: (Pruning)
1) Do not proceed if current character do not matches

2) If freq[word[0]] > freq[word[1]] then reverse the string then perform the search it will reduce number of recursive calls made.

 */


class Solution {
    private boolean backtrack(int i, int j, char[][] board, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // Mark as visited

        boolean found = backtrack(i + 1, j, board, word, idx + 1) ||
                        backtrack(i - 1, j, board, word, idx + 1) ||
                        backtrack(i, j + 1, board, word, idx + 1) ||
                        backtrack(i, j - 1, board, word, idx + 1);

        board[i][j] = temp; // Restore
        return found;
    }

    public boolean exist(char[][] board, String word) {
        int freqFirst=0, freqLast=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) freqFirst++;
                if(board[i][j] == word.charAt(word.length()-1)) freqLast++;
            }
        }

        if(freqFirst > freqLast){
            StringBuilder sb = new StringBuilder(word);
            word = sb.reverse().toString();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && backtrack(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}