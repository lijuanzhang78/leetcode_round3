package Google;

public class _529_MineSweeper {
	int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
    int m,n;
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        m = board.length; n = board[0].length;
        dfs(board,click); // curr to be processed
        return board;
    }
    
    void dfs(char[][] board, int[] curr) {
        // check # of mines
        int count_M = 0;
        for(int[] d : dirs) {
            int x = d[0] + curr[0];
            int y = d[1] + curr[1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            if (board[x][y] == 'M') count_M++;
        }
        if (count_M == 0) {
            board[curr[0]][curr[1]] = 'B';
            for(int[] d : dirs) {
                int x = d[0] + curr[0];
                int y = d[1] + curr[1];
                if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'E') continue;
                dfs(board, new int[]{x,y});
            }
            
        } else {
            board[curr[0]][curr[1]] = (char)(count_M+'0');
            return;
        }    
    }

}
