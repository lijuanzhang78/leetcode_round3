package Tree;

public class ConstructBinaryTreeFromString {
	public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        boolean hasleft = false;
        TreeNode left = null, right = null, root = null;
        int sign = 1;
        for(int i = 0; i < s.length();) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int num = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num*10 + (s.charAt(i)-'0');
                    i++;
                }
                root = new TreeNode(num*sign);
                sign = 1;
            } else if (c == '-') {
                sign = -1;
                i++;
            } else if (c == '(') {
                int start = i+1;
                int count = 1;
                i++;
                while(count != 0) {
                    if (s.charAt(i) == '(') count++;
                    if (s.charAt(i) == ')') count--;
                    i++;
                }
                int end = i-2;
            
                if (!hasleft) {
                    left = str2tree(s.substring(start,end+1));
                    hasleft = true;
                } else {
                    right = str2tree(s.substring(start,end+1));
                }
            }
        }
        
        root.left = left;
        root.right = right;
        return root;
    }
	
	public static void main(String[] args) {
		String s = "51(232)(434)";
		TreeNode root = new ConstructBinaryTreeFromString().str2tree(s);
		
	}

}
