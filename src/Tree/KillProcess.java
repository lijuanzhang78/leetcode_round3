package Tree;

// 不要忘记加上 line 22： if (map.containsKey(kill)) {
//
public class KillProcess {
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        Map<Integer,Integer> pidmap = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++) {
            if (!map.containsKey(ppid.get(i))) {
                map.put(ppid.get(i), new ArrayList<Integer>());
            }
            map.get(ppid.get(i)).add(pid.get(i));
        }
        
        res.add(kill);
        dfs(kill,map,res);
        return res;
    }
    
    void dfs(int kill, Map<Integer,List<Integer>> map, List<Integer> res) {
        if (map.containsKey(kill)) {
            for(int adj : map.get(kill)) {
                res.add(adj);
                dfs(adj,map,res);
            }
        }
    }

}
