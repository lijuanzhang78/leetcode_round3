package DFS;

// 总是很犹豫index的初始值是1还是0.。。
//
// 我的解法：从index = 1开始，不是很好

public class WordSearch {
	public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            if (word == null || word.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n]; 
        char first = word.charAt(0);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == first) {
                    visited[i][j] = true;
                    if(dfs(board,word,i,j,1,visited,m,n)) return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    
    boolean dfs(char[][] board, String word, int r0, int c0, int index, boolean[][] visited, int m,int n) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        if (index == word.length()) {
            return true;
        }
        for(int[] dir : dirs) {
            int r = r0+dir[0];
            int c = c0+dir[1];
            if (r >= 0 && r < m && c >= 0 && c < n && word.charAt(index) == board[r][c] && !visited[r][c]) {
                visited[r][c] = true;
                if(dfs(board,word,r,c,index+1,visited,m,n)) return true;
                visited[r][c] = false;
            } 
        }
        return false;
    }
    
    // leetcode 高票解法: 从index = 0 开始，然后判断当前元素是否合法，我的解法是判断下一步的元素是否合法
    //
    public boolean exist_2(char[][] board, String word) {
        if (board == null || board.length == 0) {
            if (word == null || word.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n]; 
        char first = word.charAt(0);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs_2(board,word,i,j,0,visited,m,n)) return true;
            }
        }
        return false;
    }
    
    boolean dfs_2(char[][] board, String word, int r0, int c0, int index, boolean[][] visited, int m,int n) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        if (index == word.length()) {
            return true;
        }
        if (r0 < 0 || r0 >= m || c0 < 0 || c0 >= n || visited[r0][c0] || board[r0][c0] != word.charAt(index)) return false;
        
        visited[r0][c0] = true;
        for(int[] dir : dirs) {
            int r = r0+dir[0];
            int c = c0+dir[1];
            if(dfs(board,word,r,c,index+1,visited,m,n)) return true;
        }
        visited[r0][c0] = false;
        return false;
    }

}
