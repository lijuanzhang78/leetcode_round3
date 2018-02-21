package Tree;

// usage of Integer.parseInt()
// this way is much better than previous one
// easy and less error-prone
//
public class ConstructBinaryTreeFromString_better {
	public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        int firstParen = s.indexOf("(");
        if (firstParen == -1) {
            return new TreeNode(Integer.parseInt(s));
        } 
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0,firstParen)));
        root.left = null; root.right = null;
        int count = 0;
        int start = firstParen + 1;
        boolean hasleft = false;
        for(int i = firstParen; i < s.length();i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count == 0) {
                if (!hasleft) {
                    String leftTree = s.substring(start,i);
                    TreeNode left =  str2tree(leftTree);
                    root.left = left;
                    hasleft = true;
                    start = i + 2;
                } else {
                    String rightTree = s.substring(start,i);
                    TreeNode right = str2tree(rightTree);
                    root.right = right;
                }
            }
        }
        return root;
    }

}
