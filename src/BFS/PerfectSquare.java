package BFS;

// 解法一： BFS
// n的adjacency是n-j*j(j*j <= n),0最先出现的层数即为答案。
//
public class PerfectSquare {
	public int numSquares(int n) {
        if (n < 0) return 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(n);
        set.add(n);
        int level = 0;
        while(q.size() > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == 0 ) return level;
                for(int j = 1; j*j <= curr; j++) {
                    if (!set.contains(curr-j*j)) {
                        q.offer(curr-j*j);
                        set.add(curr-j*j);
                    }
                }
            }
            level++;
        }
        return level;
    }
}

// DP
//
