package Google;

public class _399_EvaluateDivision_UF {
	class Solution {
	    Map<String,Double> ratios;
	    Map<String,String> parents;
	    
	    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
	        if (queries == null || queries.length == 0) return new double[0];
	        parents = new HashMap<>();
	        ratios = new HashMap<>();
	        double[] res = new double[queries.length];
	        
	        for(int i = 0; i < equations.length; i++) {
	            String[] e = equations[i];
	            if (!parents.containsKey(e[0])) {
	                parents.put(e[0],e[0]);
	                ratios.put(e[0],1.0);
	            }
	            if (!parents.containsKey(e[1])) {
	                parents.put(e[1],e[1]);
	                ratios.put(e[1],1.0);
	            }
	            String p0 = findParent(e[0]);
	            String p1 = findParent(e[1]);
	            if (!p0.equals(p1)) unite(p0,p1,ratios.get(e[0])/ratios.get(e[1])*values[i]);    
	        } 
	        
	        for(int i = 0; i < queries.length; i++) {
	            String[] q = queries[i];
	            if (!parents.containsKey(q[0]) || !parents.containsKey(q[1])) {
	                res[i] = -1.0; continue;
	            }
	            if (q[0].equals(q[1])) {
	                res[i] = 1.0; continue;
	            }
	            String p0 = findParent(q[0]);
	            String p1 = findParent(q[1]);
	            if (!p1.equals(p0)) {
	                res[i] = -1.0;
	            } else {
	                res[i] = ratios.get(q[1])/ratios.get(q[0]);
	            }
	        }
	        return res;
	    }
	    
	    String findParent(String s) {
	        if (s.equals(parents.get(s))) return s;
	        String p = findParent(parents.get(s));
	        double newratio = ratios.get(parents.get(s))*ratios.get(s);
	        parents.put(s,p);
	        ratios.put(s,newratio);
	        return p;
	    }
	    
	    void unite(String p0, String p1, double val) {
	        parents.put(p1,p0);
	        ratios.put(p1,val);
	    }
	}

}
