package Google;

import java.util.Map;
import java.util.TreeMap;

public class _726_NumberOfAtoms {
	private int i = 0;
    public String countOfAtoms(String formula) {
        if (formula == null || formula.length() == 0) return "";
        Map<String,Integer> map = countAtomsHelper(formula);
        StringBuilder sb = new StringBuilder();
        for(String key : map.keySet()) {
            sb.append(key);
            if (map.get(key) > 1) sb.append(map.get(key));
        }
        return sb.toString();
    }
    
    Map<String,Integer> countAtomsHelper(String formula) {
        Map<String, Integer> map = new TreeMap<>();
        while(i < formula.length()) {
            char c = formula.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                String name = getName(formula);
                int count = getCount(formula);
                if (!map.containsKey(name)) {
                    map.put(name,0);
                }
                map.put(name, map.get(name)+count);
            } else if (c == '(') {
                int leftc = 0, start = i+1;
                for(; i < formula.length(); i++) {
                    if (formula.charAt(i) == '(') {
                        leftc++;
                    } 
                    if (formula.charAt(i) == ')') {
                        leftc--;
                    }
                    if (leftc == 0) {
                        Map<String, Integer> temp = new _726_NumberOfAtoms().countAtomsHelper(formula.substring(start,i));
                        i++;
                        int count = getCount(formula);
                        for(String key : temp.keySet()) {
                            if (!map.containsKey(key)) {
                                map.put(key,temp.get(key)*count);
                            } else {
                                map.put(key, map.get(key)+temp.get(key)*count);
                            }    
                        }
                        break;
                    }
                }
                i++;
            }
        }
        return map;
    }
    
    String getName(String formula) {
        StringBuilder sb = new StringBuilder();
        sb.append(formula.charAt(i));
        i++;
        while(i < formula.length()) {
            char c = formula.charAt(i);
            if (formula.charAt(i) >= 'a' && formula.charAt(i) <= 'z') {
                sb.append(formula.charAt(i));
            } else {
                break;
            }
            i++;
        }
        return sb.toString();
    }
    
    int getCount(String formula) {
        int num = 0;
        while(i < formula.length()) {
            char c = formula.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num*10 + c-'0';
                i++;
            } else {
            	break;
            }
            
        }
        return num == 0? 1 : num;
    }
    
    public static void main(String[] args) {
    	String formula = "K4(ON(SO3)2)2";
    	String res = new _726_NumberOfAtoms().countOfAtoms(formula);
    	return;
    }
}
