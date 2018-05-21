package Google;

import java.util.ArrayList;
import java.util.List;

public class _834_SumOfDistancesInTree {
	public int[] sumOfDistancesInTree(int N, int[][] edges) {
        //if (edges == null || edges.length == 0) return new int[0];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] count = new int[N]; // count of nodes in the subtree rooted at i (include i)
        int[] rtsum = new int[N]; 
        
        dfs_post(count,rtsum,0,-1,adjList);
        dfs_pre(count,rtsum,0,-1,adjList,N);
        return rtsum;
    }
    
    void dfs_post(int[] count, int[] rtsum, int curr, int parent,List<List<Integer>> adjList) {
        count[curr] = 1;
        for(int adj : adjList.get(curr)) {
            if (adj != parent) {
                dfs_post(count,rtsum,adj,curr,adjList);
                count[curr] += count[adj];
                rtsum[curr] += rtsum[adj] + count[adj];
            }    
        }    
    }
    
    void dfs_pre(int[] count, int[] rtsum, int curr, int parent, List<List<Integer>> adjList, int N) {
        for(int adj : adjList.get(curr)) {
            if (adj != parent) {
                rtsum[adj] = rtsum[curr] - count[adj] + N - count[adj];
                dfs_pre(count,rtsum,adj,curr,adjList, N);
            }
        }
    }

}
