package Google;

public class _519_RandomFlipMatrix {
	class Solution {
	    Random rand = new Random();
	    Map<Integer,Integer> map = new HashMap<>();
	    int rows, cols;
	    int max;

	    public Solution(int n_rows, int n_cols) {
	        this.rows = n_rows;
	        this.cols = n_cols;
	        this.max = n_rows*n_cols;
	    }
	    
	    public int[] flip() {
	        int index = rand.nextInt(max);
	        if (!map.containsKey(index)) {
	            int r = index/cols;
	            int c = index%cols;
	            map.put(index,map.getOrDefault(max-1,max-1));
	            max--;
	            return new int[]{r,c};
	        } else {
	            int real_pos = map.get(index);
	            int r = real_pos/cols;
	            int c = real_pos%cols;
	            map.put(index,map.getOrDefault(max-1,max-1));
	            max--;
	            return new int[]{r,c};
	        }
	    }
	    
	    public void reset() {
	        map.clear();
	        max = rows*cols;
	    }
	}


}
