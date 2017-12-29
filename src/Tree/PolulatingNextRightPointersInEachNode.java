package Tree;

public class PolulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            if (root.next != null) {
                root.right.next = root.next.left;
            } else {
                root.right.next = null;
            }
        }
        connect(root.left);
        connect(root.right);
    }

}
