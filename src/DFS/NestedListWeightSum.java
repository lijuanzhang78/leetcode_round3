package DFS;

// 递归写法一,比第二种写法好
//
public class NestedListWeightSum {
	public int depthSum_1(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        return helper(nestedList,1); 
    }
    
    int helper(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for(NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += level * ni.getInteger();
            } else {
                sum += helper(ni.getList(), level+1);                
            }            
        }  
        return sum;
    } 
//   
// 递归写法二:
//
    public int depthSum_2(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        return helper(nestedList,0,1); 
    }
    
    int helper(List<NestedInteger> nestedList, int sum, int level) {
        for(NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += level * ni.getInteger();
            } else {
                sum = helper(ni.getList(), sum, level+1);                
            }            
        }  
        return sum;
    }
    
// BFS:类似binary tree level order traversal
//
    public int depthSum_3(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        Queue<NestedInteger> q = new LinkedList<>();
        for(NestedInteger ni : nestedList) {
            q.offer(ni);
        }
        int sum = 0, level = 0;
        while(q.size() > 0) {
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++) {
                NestedInteger ni = q.poll();
                if (ni.isInteger()) {
                    sum += ni.getInteger()*level;
                } else {
                    List<NestedInteger> list = ni.getList();
                    q.addAll(list);
                }
            }
        }
        return sum;
    }   
}
