package DFS;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n,0,0,sb,res);
        return res;
    } 
    
    void dfs(int n, int left, int right, StringBuilder sb, List<String> res) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        
        if (left < n) {
            dfs(n,left+1,right,sb.append("("),res);
            sb.setLength(sb.length()-1);
        }
        if (right < n && right < left) {
            dfs(n,left,right+1,sb.append(")"),res);
            sb.setLength(sb.length()-1);
        }
    }

}
