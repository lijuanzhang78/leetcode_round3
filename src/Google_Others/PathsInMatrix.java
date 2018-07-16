package Google_Others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PathsInMatrix {
	int m, n;
	List<String> getPathsInMatrix(int[][] matrix, int[] source, int[] end) {
		List<String> res = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		m = matrix.length;
		n = matrix[0].length;
		visited.add(source[0]*n+source[1]);
		printHelper(res,source,matrix,end,visited,""+matrix[source[0]][source[1]]+"->");
		return res;
	}
	
	int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
	void printHelper(List<String> res, int[] curr, int[][] matrix, int[] end, Set<Integer> visited, String temp) {
		if (curr[0] == end[0] && curr[1] == end[1]) {
			temp = temp.substring(0,temp.length()-2);
			res.add(temp);
			return;
		} else {
			for(int[] d : dirs) {
				int x = d[0]+curr[0];
				int y = d[1]+curr[1];
				if (x < 0 || x >= m || y < 0 || y >= n || visited.contains(x*n+y)) continue;
				visited.add(x*n+y);
				printHelper(res,new int[]{x,y},matrix,end,visited,temp+matrix[x][y]+"->");
				visited.remove(x*n+y);
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},
				{4,5,6},
				{7,8,9}};
		int[] source = {0,0}, end = {2,2};
		List<String> res = new PathsInMatrix().getPathsInMatrix(matrix, source, end);
		return;
	}
	
	

}
