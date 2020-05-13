class Solution {
    public boolean exist(char[][] board, String word) {
        //dfs
        //Find the first letter of the word in the board, for this letter, check if there is a path which constructs the word
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int idx, int i, int j) {
        //Exit
        if(idx == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)) return false;
        //Recursion body
        board[i][j] = '0';
        boolean res = dfs(board, word, idx + 1, i, j - 1) ||
                      dfs(board, word, idx + 1, i, j + 1) ||
                      dfs(board, word, idx + 1, i - 1, j) ||
                      dfs(board, word, idx + 1, i + 1, j);
        board[i][j] = word.charAt(idx);
        return res;
    }
}