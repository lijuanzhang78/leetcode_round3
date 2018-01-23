package Array;

public class LonelyPixelI {
	public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0) return 0;
        int m = picture.length, n = picture[0].length;
        int[] rowCount = new int[m], colCount = new int[n];
        
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    if (rowCount[i] == 1 && colCount[j] == 1) res++;
                }
            }
        }
        return res;    
    }
}
