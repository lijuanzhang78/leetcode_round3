package Google;

public class _282_ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(res,num,"",target,0,0,0);
        return res;
    }
    
    void helper(List<String> res, String num, String currStr, int target, int pos, long currres, long multi) {
        if (pos == num.length()) {
            if (currres == target) {
                res.add(currStr);
            }
            return;
        }
        
        if (pos == 0) {
            for(int i = 0; i < num.length(); i++) {
                if (num.charAt(pos) == '0' && i != pos) continue;
                long number = Long.parseLong(num.substring(pos,i+1));
                helper(res,num,currStr+number,target,i+1,currres+number,number);
            }
        } else {
            for(int i = pos; i < num.length(); i++) {
                if (num.charAt(pos) == '0' && i != pos) continue;
                long number = Long.parseLong(num.substring(pos,i+1));
                
                helper(res,num,currStr+"+"+number, target, i+1, currres+number,number);
                helper(res,num,currStr+"-"+number, target, i+1, currres-number,-number);
                helper(res,num,currStr+"*"+number, target, i+1, currres-multi+multi*number,multi*number);   
            }
        }
    }

}
