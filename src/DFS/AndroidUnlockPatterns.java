package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// backtracking:
// 1.容易忘记把 {2,1}, {-2,1}, {2,-1},{-2,-1},{1,2}, {-1,2}, {1,-2},{-1,-2} 加到里面
// 2.总是很纠结什么时候判断visited，是在dfs刚开始（如果不满足就马上返回）的时候还是在call dfs的时候
// 3. HashSet.remove(int[]) 在没有定义对int[]的comparator的时候，这个操作不成功！！！如果换成是list<int> 这个操作就会成功！！！


public class AndroidUnlockPatterns {
int[][] dirs1 = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1},
                 {2,1}, {-2,1}, {2,-1},{-2,-1},{1,2}, {-1,2}, {1,-2},{-1,-2}};
int[][] dirs2 = {{2,0},{-2,0},{0,2},{0,-2},{2,2},{-2,-2},{-2,2},{2,-2}};

public int numberOfPatterns(int m, int n) {
Set<Integer> visited = new HashSet<>();
Set<List<Integer>> test = new HashSet<>();
List<Integer> list = new ArrayList<>();
list.add(1);list.add(2);
test.add(list);
int size = test.size();
List<Integer> list2 = new ArrayList<>();
list2.add(1); list2.add(2);
test.remove(list2);
size = test.size();
int res = 0;
for(int i = 0; i < 3; i++) {
    for(int j = 0; j < 3; j++) {
        res = dfs(visited,m,n,i,j,res);
    }
}
return res;
}

int dfs(Set<Integer> visited, int m, int n, int i, int j, int res) {
if (i < 0 || i >=3 || j < 0 || j >= 3) return res;
if (visited.contains(i*3+j)) return res;

visited.add(i*3+j);
if (visited.size() == n) {
    res++;
    visited.remove(i*3+j);
    return res;
}

if (visited.size() >= m && visited.size() < n) {
    res++;
}

for(int[] dir : dirs1) {
    int x = dir[0]+i;
    int y = dir[1]+j;
    res = dfs(visited,m,n,x,y,res);
}
for(int[] dir : dirs2) {
    int x = dir[0]+i;
    int y = dir[1]+j;
    int midx = (x+i)/2;
    int midy = (y+j)/2;
    if (!visited.contains(midx*3+midy)) continue;
    res = dfs(visited,m,n,x,y,res);   
}
visited.remove(i*3+j);
return res;
}

public static void main(String[] arg) {
	int res = new AndroidUnlockPatterns().numberOfPatterns(1, 1);
	return;
	
}
}
