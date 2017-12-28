package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingOffers_discuss {
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
	    int result = Integer.MAX_VALUE;
	    //apply each offer to the needs, and recurse
	    for(int i = 0; i < special.size(); i++) {
	        List<Integer> offer = special.get(i);
	        boolean invalidOffer = false;
	        for(int j = 0; j < needs.size(); j++) { // subtract offer items from needs
	            int remain = needs.get(j) - offer.get(j);
	            needs.set(j, remain);
	            if(!invalidOffer && remain < 0) invalidOffer = true; // if offer has more items than needs
	        }
	        if(!invalidOffer) { //if valid offer, add offer price and recurse remaining needs
	            result = Math.min(result, shoppingOffers(price, special, needs) + offer.get(needs.size()));
	        }
	        for(int j = 0; j < needs.size(); j++) { // reset the needs
	            int remain = needs.get(j) + offer.get(j);
	            needs.set(j, remain);
	        }
	    }
	    // choose b/w offer and non offer
	    int nonOfferPrice = 0;
	    for(int i = 0; i < needs.size(); i++) {
	        nonOfferPrice += price.get(i) * needs.get(i);
	    }
	    return Math.min(result, nonOfferPrice);
	}
	
	public static void main(String[] args) {
    	List<Integer> price = Arrays.asList(2,5);
    	List<Integer> s1 = Arrays.asList(3,0,5);
    	List<Integer> s2 = Arrays.asList(1,2,10);
    	List<List<Integer>> special = new ArrayList<>();
    	special.add(s1); special.add(s2);
    	List<Integer> needs = Arrays.asList(3,2);
    	
    	int res = new ShoppingOffers_discuss().shoppingOffers(price, special, needs);
    	return;	
    }

}
