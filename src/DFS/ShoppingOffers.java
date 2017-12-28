package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 这个版本有错误，虽然OJ通过

public class ShoppingOffers {
	int result = Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int nooffer = 0;
        for(int i = 0; i < needs.size(); i++) {
            nooffer += needs.get(i)*price.get(i);
        }
        helper(price,special,needs,0);
        return Math.min(nooffer,result);
    }
    
    void helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int currRes) {
        boolean cango = checkIfcango(special,needs);
        if (!cango) {
            for(int i = 0; i < needs.size(); i++) {
                currRes += needs.get(i)*price.get(i);
            }
            result = Math.min(result,currRes);
            return;
        }
        
        for(List<Integer> offer : special) {
            boolean isValid = true;
            for(int i = 0; i < needs.size(); i++) {
                if(needs.get(i) < offer.get(i)) {
                    isValid = false;
                    break;
                }                
            }
            if(isValid) {
                for(int i = 0; i < needs.size(); i++) {
                    int curr = needs.get(i) - offer.get(i);
                    needs.set(i,curr);
                }
                currRes += offer.get(needs.size());
                
                helper(price,special,needs,currRes);
                for(int i = 0; i < needs.size(); i++) {
                    int curr = needs.get(i) + offer.get(i);
                    needs.set(i,curr);
                }
                currRes -= offer.get(needs.size());
            }
        }    
    }
    
    boolean checkIfcango (List<List<Integer>> special, List<Integer> needs) {
        boolean cango = true;
        for(int i = 0; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            cango = true;
            for(int j = 0; j < offer.size()-1; j++) {
                if (needs.get(j) < offer.get(j)) {
                    cango = false;
                    break;
                }
            }
            if (cango) break;
        }
        return cango;
    }
    
    public static void main(String[] args) {
    	List<Integer> price = Arrays.asList(2,5);
    	List<Integer> s1 = Arrays.asList(3,0,5);
    	List<Integer> s2 = Arrays.asList(1,2,10);
    	List<List<Integer>> special = new ArrayList<>();
    	special.add(s1); special.add(s2);
    	List<Integer> needs = Arrays.asList(3,2);
    	
    	int res = new ShoppingOffers().shoppingOffers(price, special, needs);
    	return;	
    }

}
