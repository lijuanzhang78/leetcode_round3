package Stack;

public class VerifyPreorderSerilizationOfABinaryTree {
	public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) return false;
        LinkedList<String> stack = new LinkedList<>();
        String[] arr = preorder.split(",");
        for(String node : arr) {
            if (!node.equals("#")) {
                stack.push(node);
            } else { // node.equals("#")
                while(stack.size() > 0 && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.size() == 0) return false;
                    stack.pop();
                }
                stack.push("#");    
            }
        }
        return stack.size() == 1 && stack.pop().equals("#");
    } 

}
