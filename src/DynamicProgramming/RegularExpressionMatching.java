package DynamicProgramming;

// DFS暴力搜索，也可以AC
//   1）s为空，p为空，返回true
//   2）s不为空，p为空，返回false
//   3）s为空，p不为空，不能立即返回，比如s = “”， p = a*, 因为*可以把前面的数字吸收掉
//   4）因为需要判断p.charAt(1)是不是为‘*’，要求p至少长度为2，所以需要把p长度为1的情况单独讨论
//   5）当p的长度为1，如果首字符相等，或者p首字符为".", 返回true，否则false
//   6）当p的长度等于或者大于2，分两种情况：
//      -(1) 当p的第二个字母不为“*”，那么如果s和p的首字母相同，或者p的首字母为“.”,那么可以进一步递归
//      -(2) 当p的第二个字母为“*”， 那么首先s可能会跟p.substring(2) match, 所以先调用递归，如果成功，
//           则返回true；如果s的首字母和p的首字母相同，以a为例，那么a*可以代表s的一个a，所以可以进一步递归，
//           如果成功，则返回true；如果s的第二个，第三个，。。。和p的首字母相同，那么a*可以代表两个a，三个a，
//           直到字符不相等。
//      -(3) 如果p的首字符为“.”， 那么“.*”可以与任何字符相匹配

// 细节：s.substring(i), 当i = s.length(), 返回的是空


public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        if (s.length() > 0 && p.length() == 0) return false;
        
        if (p.length() == 1) {
            if (s.length() == 1) {
                return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
            } else {
                return false;
            }
        }
        
        // p.length() >= 2
        if (p.charAt(1) != '*') {
            if (s.length() == 0) return false;
            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }    
        } else {
            if(isMatch(s,p.substring(2))) return true;
            int i = 0;
            for(; i < s.length(); ) {
                if (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.') {
                    if (isMatch(s.substring(i+1), p.substring(2))) return true;
                    i++;
                } else {
                    break;
                }
                //return isMatch(s.substring(i),p.substring(2));
            }
            return isMatch(s.substring(i),p.substring(2));
        }
    }
	
	public static void main(String[] args) {
		String s = "aa";
		String p = "a*";
		
		boolean res = new RegularExpressionMatching().isMatch(s, p);
	}

}
