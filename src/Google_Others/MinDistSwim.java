package Google_Others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinDistSwim {
	int m, n;
	public int minDistSwim(int[][] matrix, int[] begin, int[] end) {
		Map<Integer,Integer> map = new HashMap<>();
		m = matrix.length; n = matrix[0].length;
		Set<Integer> visited = new HashSet<>();
		visited.add(begin[0]*n+begin[1]);
		helper(matrix,map,begin,end,visited);
		return map.get(begin[0]*n+begin[1]);	
	}
	
	int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
	
	int helper(int[][] matrix, Map<Integer,Integer> map, int[] begin, int[] end, Set<Integer> visited) {
		if (map.containsKey(begin[0]*n+begin[1])) {
			return map.get(begin[0]*n+begin[1]);
		} else if (begin[0] == end[0] && begin[1] == end[1]) {
			map.put(begin[0]*n+begin[1], matrix[begin[0]][begin[1]]);
			return map.get(begin[0]*n+begin[1]);
		} else {
			int min = Integer.MAX_VALUE;
			for(int[] d : dirs) {
				int x = begin[0] + d[0];
				int y = begin[1] + d[1];
				if (x < 0 || x >= m || y < 0 || y >= n || visited.contains(x*n+y)) continue;
				visited.add(x*n+y);
				min = Math.min(helper(matrix,map,new int[]{x,y}, end, visited), min);	
				visited.remove(x*n+y);
			}
			min = Math.max(matrix[begin[0]][begin[1]], min);
			map.put(begin[0]*n+begin[1], min);
			return min;
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},
				{2,3,3},
				{1,3,2}};
		int[] begin = {0,0}, end = {2,2};
		int res = new MinDistSwim().minDistSwim(matrix, begin, end);
		return;
	}

}
