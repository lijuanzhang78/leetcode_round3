package BackTracking;

// 这道题非常容易出错
// 这道题需要建一个TrieTree，Trie Tree的root是一个成员变量，因为别的函数需要直接用它。
// TrieNode的定义： (1) TrieNode[] children = new TrieNode[26]
//                (2) 当前object是不是一个word的末尾，如果是末尾，那么isWord为true
// 思路：从矩阵的每一个点出发，同时也从Trie tree的root出发，如果root的children里面对应的位置不为null，
//      说明矩阵当前的字符match，那么可以进一步（当前点的上下左右）检查。
// 容易出错的地方：由于isWord的检查是在递归调用的下一步（也就是当前点的上下左右调用）才知道，需要引入去重。
//              每次找到了一个word，就把isWord设置为false，而且不能马上返回，因为在这条search path
//              上面，可能还会有其他的word
//              同样的原因，isWord只有在下一次调用的时候才知道，也就是说要确保有下一次调用，所以对isWord
//              的判断，要在对i，j是否越界之前。否则，不能通过以下的例子
//              board = {{'a'}}, words = {"a"}
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
