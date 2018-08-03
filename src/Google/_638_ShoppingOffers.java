package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _638_ShoppingOffers {
	int min = Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> list, List<List<Integer>> special, List<Integer> list2) {
        if (list == null || special == null || list2 == null) return 0;
        return getMinCost(list,special,list2);
    }
    
    int directBuy(List<Integer> price, List<Integer> needs) {
        int res = 0;
        for(int i = 0; i < price.size(); i++) {
            res += price.get(i)*needs.get(i);
        }
        return res;
    }
    
    int getMinCost(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int sum = 0;
        for(int i = 0; i < needs.size(); i++) {
            sum += needs.get(i);
        }
        if (sum == 0) {
            return 0;
        }
    
        int direct = directBuy(price,needs);
        int min = direct;
        for(List<Integer> offer : special) {
            boolean valid = true;
            for(int i = 0; i < needs.size(); i++) {
                if (needs.get(i)-offer.get(i) < 0) {
                    valid = false;
                    break;
                } else {
                    needs.set(i,needs.get(i)-offer.get(i));
                }
            }
            if (!valid) continue;
            int remainMin = getMinCost(price,special,needs);
            min = Math.min(remainMin+offer.get(offer.size()-1), min);
            for(int i = 0; i < needs.size(); i++) {
                needs.set(i,needs.get(i)+offer.get(i));
            }
        }
        return min;    
    }
    
    public static void main(String[] args) {
    	List<Integer> price = new ArrayList<>();
    	price.add(3); price.add(4);
    	List<List<Integer>> offer = new ArrayList<>();
    	List<Integer> offer1 = new ArrayList<>(); offer1.add(1); offer1.add(2); offer1.add(3);
    	List<Integer> offer2 = new ArrayList<>(); offer2.add(1); offer2.add(2); offer2.add(5);
    	offer.add(offer1); offer.add(offer2);
    	List<Integer> needs = new ArrayList<>();
    	needs.add(2); needs.add(2);
    	int res = new _638_ShoppingOffers().shoppingOffers(price, offer, needs);
    	return;
    }

}
