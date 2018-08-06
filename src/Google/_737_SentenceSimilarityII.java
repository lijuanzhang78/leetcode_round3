package Google;

public class _737_SentenceSimilarityII {
	Map<String,String> parents;
    Map<String,Integer> sizes;
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words2 == null) return false;
        if (words1.length != words2.length) return false;
        
        parents = new HashMap<>();
        sizes = new HashMap<>();
        for(String[] p : pairs) {
            if (!parents.containsKey(p[0])) {
                parents.put(p[0],p[0]);
                sizes.put(p[0],1);
            }
            if (!parents.containsKey(p[1])) {
                parents.put(p[1],p[1]);
                sizes.put(p[1],1);
            }
            String p0 = findParents(p[0]);
            String p1 = findParents(p[1]);
            union(p0, p1);
        }
        for(int i = 0; i < words1.length; i++) {
            if (!parents.containsKey(words1[i]) || !parents.containsKey(words2[i])) {
                if (!words1[i].equals(words2[i])) return false;
            } else {
                String p1 = findParents(words1[i]);
                String p2 = findParents(words2[i]);
                if (!p1.equals(p2)) return false;
            }
        }
        return true;
    }
    
    void union(String p0, String p1) {
        if (sizes.get(p0) >= sizes.get(p1)) {
            parents.put(p1,p0);
            sizes.put(p0,sizes.get(p0)+sizes.get(p1));    
        } else {
            parents.put(p0,p1);
            sizes.put(p1,sizes.get(p1)+sizes.get(p0));
        }
    }
    
    String findParents(String s) {
        if (parents.get(s).equals(s)) return s;
        String parent = findParents(parents.get(s));
        parents.put(s,parent);
        return parent;
    }
}
