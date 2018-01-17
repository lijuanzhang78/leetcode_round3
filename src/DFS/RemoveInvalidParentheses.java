package DFS;

// DFS + Backtracking
// 首先找出左括号和右括号unmatched的个数，如果s是“）（”，那么左括号和右括号unmatched的个数都是1. 如果是左括号，
// 那么left++， 如果是右括号，如果有多余的左括号，那么left--，否则right++
// 对于每个s的每个字符，如果
// (1) 是左括号，那么可以保存也可以去掉，当然满足的条件是去掉的个数不能超过left，而且到最后left必须是0，不能多保留
//     也不能少去掉。
// (2) 是右括号，可以去掉，也可以保留，如果保留的话，要满足当前是不是有多余的unmatched的左括号
// (3) 其他字符，保留
// count代表open 左括号，最后必须为0
// 迭代的终止条件是字符串的末尾，而且left，right，count都为0
//
public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        //if (s == null || s.length() == 0) return res;
        
        // get the number of unmatched left and right
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }    
        }
        
        // purpose is to make (1) left and right equal to zero and (2) count equal to zero
        // firstly satisfy count
        Set<String> set = new HashSet<>();
        dfs(s,0,left,right,0,set, new StringBuilder());
        res.addAll(set);
        return res;   
    }
    
    void dfs(String s, int pos, int left, int right, int count, Set<String> set, StringBuilder sb) {
        if (pos == s.length()) {
            if (left == 0 && right == 0 && count == 0) {
                set.add(sb.toString());
                return;
            } else {
                return;
            }
        }
        
        char c = s.charAt(pos);
        int len = sb.length();
        if (c == '(') {
            dfs(s,pos+1,left-1,right,count,set,sb); // remove
            dfs(s,pos+1,left,right,count+1,set,sb.append("(")); // keep
        } else if (c == ')') {
            dfs(s,pos+1,left,right-1,count,set,sb); // remove
            if (count > 0) {
                dfs(s,pos+1,left,right,count-1,set,sb.append(")")); // keep
            }
        } else {
            dfs(s,pos+1,left,right,count,set,sb.append(c));
        }
        sb.setLength(len);
    }

}
