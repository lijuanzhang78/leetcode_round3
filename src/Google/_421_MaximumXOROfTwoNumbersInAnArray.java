package Google;

public class _421_MaximumXOROfTwoNumbersInAnArray {
	class TrieNode{
        int val;
        TrieNode[] children;
        TrieNode(){
            this.val = val;
            children = new TrieNode[2];
        }
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for(int num : nums) {
            TrieNode curr = root;
            for(int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (curr.children[bit] == null) {
                    curr.children[bit] = new TrieNode();
                }
                curr = curr.children[bit];
            }   
        }
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            TrieNode curr = root;
            int currSum = 0;
            for(int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (curr.children[bit ^ 1] != null) {
                    currSum += 1 << i;
                    curr = curr.children[bit ^ 1];
                } else {
                    curr = curr.children[bit];
                }
            }
            max = Math.max(max,currSum);
        }
        return max;
    }
}
