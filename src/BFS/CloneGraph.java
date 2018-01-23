package BFS;

// 需要建立一个map：original node 和 new node 的一一对应关系
// 然后运用BFS或者DFS对original graph 做一遍遍历，在遍历的时候，需要在新图里面也一一加入adjacency
// 
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        // mapping old node -> new node
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node,root);
        
        while(q.size() > 0) {
            UndirectedGraphNode curr = q.poll();
            for(UndirectedGraphNode adj : curr.neighbors) {
                if (!map.containsKey(adj)) {
                    UndirectedGraphNode newadj = new UndirectedGraphNode(adj.label);
                    map.put(adj,newadj);
                    map.get(curr).neighbors.add(newadj);
                    q.offer(adj);   
                } else {
                    map.get(curr).neighbors.add(map.get(adj));
                }    
            }    
        }
        return root;
    }

}
