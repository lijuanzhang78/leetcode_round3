package BFS;

// BFS,每一位加一减一都是当前字符串的adjacency
// 对于deadends，在poll之后才check
// 记得记得对于每次加入queue的字符串，把他们加入visited!!!!
//
public class OpenTheLock {
	public int openLock(String[] deadends, String target) {
        if (target == null || target.length() == 0) return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        Set<String> dead = new HashSet<>();
        for(String s : deadends) {
            dead.add(s);
        }
        q.offer("0000");
        visited.add("0000");
        
        int level = 0;
        while(q.size() > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String curr = q.poll();
                if (dead.contains(curr)) continue;
                if (curr.equals(target)) return level;
                for(int j = 0; j < 4; j++) {
                   for(int k = 0; k < 2; k++) {
                       char[] arr = curr.toCharArray();
                       if(k == 0) {
                           arr[j] = (char)((arr[j] - '0' + 1) % 10 + '0');
                           String s = new String(arr);
                           if (!visited.contains(s)) {
                               q.offer(s);
                               visited.add(s);
                           }
                       } else {
                           arr[j] = arr[j] == '0'? '9' : (char)(arr[j] - 1);
                           String s = new String(arr);
                           if (!visited.contains(s)) {
                               q.offer(s);
                                visited.add(s);
                           }
                       }
                   }    
                }
            }
            level++;   
        }
        return -1;
    }

}
