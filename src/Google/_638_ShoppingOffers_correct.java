package Google;

public class _638_ShoppingOffers_correct {
	int min = Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (price == null || special == null || needs == null) return 0;
        return getMinCost(price,special,needs,0);
    }
    
    int directBuy(List<Integer> price, List<Integer> needs) {
        int res = 0;
        for(int i = 0; i < price.size(); i++) {
            res += price.get(i)*needs.get(i);
        }
        return res;
    }
    
    int getMinCost(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
        int direct = directBuy(price,needs);
        int min = direct;
        for(int j = pos; j < special.size(); j++) {
            List<Integer> offer = special.get(j);
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < needs.size(); i++) {
                if (needs.get(i)-offer.get(i) < 0) {
                    temp = null;
                    break;
                } else {
                    temp.add(needs.get(i)-offer.get(i));
                }
            }
            if (temp != null) {
                int remainMin = getMinCost(price,special,temp,j);
                min = Math.min(remainMin+offer.get(offer.size()-1), min);
            }
        }
        return min;   
    }

}
