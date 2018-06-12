package Google;

public class _526_BeautifulArrangement {
	int res = 0;
    public int countArrangement(int N) {
        if (N == 0) return 0;
        boolean[] visited = new boolean[N+1];
        dfs(1,visited, N);
        return res;
    }
    
    void dfs(int pos, boolean[] visited, int N) {
        if (pos == N+1) {
            res++;
            return;
        }
        for(int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            if (i%pos == 0 || pos%i == 0) {
                visited[i] = true;
                dfs(pos+1,visited,N);
                visited[i] = false;
            }
            //if (pos%i == 0) { 错误
            //    visited[i] = true;
            //    dfs(pos+1,visited,N);
            //    visited[i] = false;
            //}    
        }
    }
    
    public static void main(String[] args) {
    	int N = 2;
    	int res = new _526_BeautifulArrangement().countArrangement(N);
    	return;
    }
}
