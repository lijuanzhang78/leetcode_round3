package Google;

public class _133_CloneGraph {
	public class Solution {
	    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if (node == null) return null;
	        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>(); // old to new
	        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
	        map.put(node, newnode);
	        dfs(node,map);
	        return newnode;
	    }
	    
	    void dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
	        for (UndirectedGraphNode adj : node.neighbors) {
	            if (map.containsKey(adj)) {
	                map.get(node).neighbors.add(map.get(adj));
	            } else {
	                UndirectedGraphNode newnode = new UndirectedGraphNode(adj.label);
	                map.put(adj,newnode);
	                map.get(node).neighbors.add(newnode);
	                dfs(adj,map);
	            }
	        }
	    }
	}
}
