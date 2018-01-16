package BackTracking;

// 这道题非常容易出错
//
public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0) return res;
        int m = board.length, n = board[0].length;
        buildTrieTree(words);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                StringBuilder sb = new StringBuilder();
                TrieNode curr = root;
                dfs(board,visited,res,sb, i, j, curr, m,n); // every position could be beginning 
            }
        }
        return res;
    }
    
    void dfs(char[][] board, boolean[][] visited, List<String> res, StringBuilder sb, int i, int j, TrieNode curr,int m,int n) {
        if (curr.isWord) {
            res.add(sb.toString());
            curr.isWord = false;// no return here as there could be more words on the search path
        }
        if (i >= m || i < 0 || j >= n || j < 0) return;
        if (visited[i][j]) return;

        //if (curr.isWord) {
        //    res.add(sb.toString());
        //    curr.isWord = false;// no return here as there could be more words on the search path
        //}
        
        char c = board[i][j];
        if (curr.children[c-'a'] != null) {
            sb.append(c);
            visited[i][j] = true; // add (i,j) to the current search path
            
            // for all directions
            dfs(board,visited,res,sb,i+1,j,curr.children[c-'a'],m,n);
            dfs(board,visited,res,sb,i-1,j,curr.children[c-'a'],m,n);
            dfs(board,visited,res,sb,i,j+1,curr.children[c-'a'],m,n);
            dfs(board,visited,res,sb,i,j-1,curr.children[c-'a'],m,n);
            
            visited[i][j] = false;
            sb.setLength(sb.length()-1);
                
        } else {
            return; //
        }    
    }

    TrieNode root = new TrieNode(); // build the trie tree for the given words
    
    void buildTrieTree(String[] words) {
        for(String w : words) {
            TrieNode curr = root;   // point to the root of the trie tree
            for(int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (curr.children[c-'a'] == null) {
                    curr.children[c-'a'] = new TrieNode(); // add the new trienode for current char
                }
                curr = curr.children[c-'a'];
            }
            curr.isWord = true;
        }
    }
    
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

}
