package Google;

public class _753_CrackingTheSafe {
	public String crackSafe(int n, int k) {
        if (n <= 0 || k <= 0) return ""; // password n digits, k options
        StringBuilder sb = new StringBuilder();
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < n; i++) sb.append('0');
        visited.add(sb.toString());
        int total = (int)Math.pow(k,n);
        dfs(sb,visited,total,k,n);
        return sb.toString();
    }
    
    boolean dfs(StringBuilder sb, Set<String> visited, int total, int k, int n) {
        if (visited.size() == total) {
            return true;
        }
        String prev = sb.substring(sb.length()-n+1);
        for(int i = 0; i < k; i++) {
            String news = prev+i;
            if (visited.contains(news)) continue;
            visited.add(news);
            sb.append(i);
            if(dfs(sb,visited,total,k,n)) return true;
            visited.remove(news);
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }

}
