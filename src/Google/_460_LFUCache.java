package Google;

public class _460_LFUCache {
	class LFUCache {    
	    int max;
	    int min;
	    Map<Integer,Integer> vals = new HashMap<>();
	    Map<Integer,Integer> counts = new HashMap<>();
	    Map<Integer,LinkedHashSet<Integer>> lenLists = new HashMap<>();

	    public LFUCache(int capacity) {
	        this.max = capacity;
	        this.min = Integer.MAX_VALUE;
	    }
	    
	    public int get(int key) {
	        if (!vals.containsKey(key)) return -1;
	        int res = vals.get(key);
	        int count = counts.get(key);
	        LinkedHashSet<Integer> small = lenLists.get(count);
	        small.remove(key);
	        if (small.size() == 0) {
	            lenLists.remove(count);
	            if (min == count) {
	                min++;
	            }
	        }
	        counts.put(key,count+1);
	        if (!lenLists.containsKey(count+1)) {
	            lenLists.put(count+1,new LinkedHashSet<Integer>());
	        }
	        lenLists.get(count+1).add(key);
	        return res;
	    }

	    public void put(int key, int value) {
	        if (max <= 0) return;
	        if (!vals.containsKey(key)) {
	            if (vals.size() == max) {
	                LinkedHashSet<Integer> minList = lenLists.get(min);
	                int minkey = minList.iterator().next();
	                minList.remove(minkey);
	                if (minList.size() == 0) lenLists.remove(min);
	                vals.remove(minkey);
	                counts.remove(minkey);    
	            }
	            vals.put(key,value);
	            counts.put(key,1);
	            min = 1;
	            if (!lenLists.containsKey(1)) {
	                lenLists.put(1,new LinkedHashSet<Integer>());
	            }
	            lenLists.get(1).add(key);
	        }  else {
	            vals.put(key,value);
	            get(key);
	        }
	    }
	}


}
