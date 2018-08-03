package Google;

public class _642_DesignAutoCompleteSystem {
	class AutocompleteSystem {
	    Map<String,Integer> map;
	    TrieNode root;
	    TrieNode curr;
	    StringBuilder currPrefix;
	    class TrieNode{
	        TrieNode[] children;
	        boolean isLeaf;
	        //List<String> prefix;
	        Set<String> prefix;
	        TrieNode(){
	            children = new TrieNode[256];
	            isLeaf = false;
	            prefix = new HashSet<String>();
	        }
	    }

	    void addToTrie(String w) {
	        TrieNode curr = root;
	        for(int i = 0; i < w.length(); i++) {
	            curr.prefix.add(w);
	            char c = w.charAt(i);
	            if (curr.children[c] == null) {
	                curr.children[c] = new TrieNode();
	            }
	            curr = curr.children[c];
	        }
	        curr.isLeaf = true;
	        curr.prefix.add(w);    
	    }
	    
	    public AutocompleteSystem(String[] sentences, int[] times) {
	        if (sentences == null || sentences.length == 0) return;
	        map = new HashMap<String,Integer>();
	        root = new TrieNode();
	        for(int i = 0; i < sentences.length; i++) {
	            addToTrie(sentences[i]);
	            map.put(sentences[i],times[i]);
	        }  
	        curr = root;
	        currPrefix = new StringBuilder();
	    }
	    
	    public List<String> input(char c) {
	        if (c == '#') {
	            String news = currPrefix.toString();
	            currPrefix = new StringBuilder();
	            curr = root;
	            if (!map.containsKey(news)) {
	                map.put(news,0);
	            }
	            map.put(news,map.get(news)+1);
	            addToTrie(news);
	            return new ArrayList<String>();
	        } else {
	            if (curr.children[c] == null) {
	                curr.children[c] = new TrieNode();
	                curr = curr.children[c];
	                currPrefix.append(c);
	                return new ArrayList<String>();
	            } else {
	                curr = curr.children[c];
	                currPrefix.append(c);
	                Set<String> prefix = curr.prefix;
	                Queue<String> pq = new PriorityQueue<>((a,b)->((map.get(b)==map.get(a)? b.compareTo(a) : map.get(a)-map.get(b))));
	                for(String pre : prefix) {
	                    pq.offer(pre);
	                    if (pq.size() > 3) pq.poll();
	                }
	                List<String> res = new ArrayList<>();
	                while(pq.size()>0) {
	                    res.add(0,pq.poll());
	                }
	                return res;
	            }    
	        }
	    }
	}

}
