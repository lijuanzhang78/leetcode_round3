package DFS;

import java.util.List;

// 这道题递归解决，应该可以用DP
// 对于当前need，对所有valid的offer做选择,选定一个offer，update needs，然后再对新的needs做递归
// 递归的感想：给定level的结果只受它下面做有的递归层影响
// 对于每层递归，需要比较有offer和没有offer的情况
//
public class ShoppingOffers_improved {
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return helper(price,special,needs);
    }
    
    int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int local_min = 0;
        for(int i = 0; i < needs.size(); i++) {
            local_min += price.get(i)*needs.get(i);
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
                int choose_min = offer.get(needs.size())+helper(price,special,needs);
                local_min = Math.min(local_min,choose_min);
                
                for(int i = 0; i < needs.size(); i++) {
                    int curr = needs.get(i) + offer.get(i);
                    needs.set(i,curr);
                }
            }
        }
        return local_min;
    }
}
