package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

// DP with memo
// DP 的查找Key是一个字符串，字符串的定义由两部分组成（1）青蛙现在站的位置（pos）和 青蛙上一步是从K步跳过来的
//
public class FrogJump {
	public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return true;
        Map<String,Boolean> map = new HashMap<>();
        return canCrossHelper(stones,0,0,map);    
    }
    
    boolean canCrossHelper(int[] stones, int pos, int k, Map<String,Boolean> map) {
        if (pos == stones.length - 1) return true;
        if (pos == 0) {
            if (stones[1] != 1) return false;
            if (canCrossHelper(stones,1,1,map)) return true;
            // return canCrossHelper(stones,1,1,map); 也可以这么写，因为青蛙青蛙在第二个石头上只有一个
           // 选择, 如果在递归树上，这一层就是有一个节点（whatever returned from lower levels，所以可以
            // 直接return）
        } else {
            if (map.containsKey(""+pos+k)) return map.get(""+pos+k);
            for(int i = pos+1; i < stones.length; i++) {
                if (stones[i]-stones[pos] == k-1) {
                    if (canCrossHelper(stones,i,k-1,map)) {
                        map.put(""+pos+k,true);
                        return true;
                    }
                } else if (stones[i] - stones[pos] == k) {
                    if (canCrossHelper(stones,i,k,map)) {
                        map.put(""+pos+k,true);
                        return true;
                    }
                } else if (stones[i] - stones[pos] == k+1) {
                    if (canCrossHelper(stones,i,k+1,map)) {
                        map.put(""+pos+k,true);
                        return true;
                    }
                } 
            }
            map.put(""+pos+k,false);
        }
        return false;
    }

}
