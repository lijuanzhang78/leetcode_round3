package UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _830_PositionsOfLargeGroups {
	public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        char prev = S.charAt(0);
        int count = 1, start = 0;
        for(int i = 1; i <= S.length(); i++) {
            if (i == S.length()) {
                if (count >= 3) {
                    res.add(Arrays.asList(start,i-1));
                }
                break;
            }
            char c = S.charAt(i);
            if (c == prev) {
                count++;
            } else {
                if (count >= 3) {
                    res.add(Arrays.asList(start,i-1));
                }
                res.add(Arrays.asList(start,i-1));
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		String S = "abbxxxxzzy";
		List<List<Integer>> res = new _830_PositionsOfLargeGroups().largeGroupPositions(S);
		return;
	}

}
