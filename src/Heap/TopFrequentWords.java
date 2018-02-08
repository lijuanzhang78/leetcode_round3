package Heap;

// need to use minHeap here to keep a k size window
// 注意priorityQueue里面comparator的用法
// (a,b) -> (a.getValue() == b.getValue()? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue())
//
public class TopFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) return new ArrayList<String>();
        Map<String,Integer> map = new HashMap<>();
        for(String w : words) {
            if (!map.containsKey(w)) map.put(w,0);
            map.put(w,map.get(w)+1);
        }
        Queue<Map.Entry<String,Integer>> q = new PriorityQueue<>(
            (a,b) -> (a.getValue() == b.getValue()? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()));
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            q.offer(entry);
            if(q.size() > k) q.poll();
        }
        List<String> res = new ArrayList<>();
        while(q.size() > 0) {
            res.add(0,q.poll().getKey());
        }
        return res;
    }

}
