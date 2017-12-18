package DFS;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) return image;
        
        int m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        helper(image,sr,sc,image[sr][sc],newColor,m,n,visited);
        return image;
    }
    
    void helper(int[][] image, int sr, int sc, int start, int newColor, int m, int n, boolean[][] visited) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        
        for(int[] dir : dirs) {
            int x = sr + dir[0];
            int y = sc + dir[1];
            if (x >= 0 && x < m && y >=0 && y < n && !visited[x][y] && image[x][y] == start) {
              helper(image,x,y,start,newColor,m,n,visited);     
            }    
        }
        return;    
    }

}
