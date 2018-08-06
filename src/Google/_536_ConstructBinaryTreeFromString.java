package Google;

public class _536_ConstructBinaryTreeFromString {
	public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        if (s.indexOf("(") == -1) {
            TreeNode root = new TreeNode(Integer.parseInt(s));
            return root;
        } else {
            int pos = s.indexOf("(");
            TreeNode root = new TreeNode(Integer.parseInt(s.substring(0,pos)));
            int count = 1;
            int i = pos+1;
            for(i = pos+1; i < s.length();i++) {
                if (s.charAt(i) == '(') {
                    count++;
                } else if (s.charAt(i) == ')') {
                    count--;
                }
                if (count == 0) {
                    break;
                }
            }
            root.left = str2tree(s.substring(pos+1,i));
            if (s.indexOf("(",i) != -1) {
                int left = s.indexOf("(",i);
                root.right = str2tree(s.substring(left+1,s.length()-1));
            }
            return root;
        }
    }

}
