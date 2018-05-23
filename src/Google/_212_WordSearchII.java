package Google;

public class _212_WordSearchII {
	class TrieNode {
        TrieNode[] children;
        boolean isWord;
        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    TrieNode root;
    
    public void buildTrie(String[] words) {
        for(String w : words) {
            TrieNode curr = root;
            for(int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (curr.children[c-'a'] == null) {
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isWord = true;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        buildTrie(words);
        Set<String> added = new HashSet<>();
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                helper(board,m,n,i,j,added,root,"");
            }
        }
        return new ArrayList<String>(added);
        
    }
    
    void helper(char[][] board, int m, int n, int i, int j, Set<String> added, TrieNode root, String res) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '#') return;
        //if (root == null) return;
        char curr = board[i][j]; // current char
        if (root.children[curr-'a'] == null) {
            return;
        } else {
            root = root.children[curr-'a'];
            if (root.isWord) {
                added.add(res+curr);
            }
        }
        
        board[i][j] = '#';
        helper(board,m,n,i+1,j,added,root,res+curr);
        helper(board,m,n,i-1,j,added,root,res+curr);
        helper(board,m,n,i,j+1,added,root,res+curr);
        helper(board,m,n,i,j-1,added,root,res+curr);
        board[i][j] = curr;
    }

}
