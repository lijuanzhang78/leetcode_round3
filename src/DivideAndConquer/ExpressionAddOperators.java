package DivideAndConquer;

public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(num,target,0,res,0,new StringBuilder(),' ',0);
        return res;
    }
    
    void helper(String num, int target, int pos, List<String> res, long curr, StringBuilder sb, char preop, long prevnum) {
        if (pos == num.length()) {
            if (curr == target) {
                res.add(sb.toString());
            }
            return;
        }
        
        for(int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long currnum = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            if(pos == 0) {
                sb.append(currnum);
                helper(num,target,pos+1,res,currnum,sb,'+',currnum);
                sb.setLength(len);
            } else {
                helper(num,target,pos+1,res,curr+currnum,sb.append("+"+currnum),'+',currnum);
                sb.setLength(len);
                
                helper(num,target,pos+1,res,curr-currnum,sb.append("-"+currnum),'-',currnum);
                sb.setLength(len);
                
                if (preop == '+') {
                    helper(num,target,pos+1,res,(curr-prevnum)+prevnum*currnum,sb.append("*"+currnum),'*',currnum);
                    sb.setLength(len);
                } else if (preop == '-') {
                    helper(num,target,pos+1,res,(curr+prevnum)-prevnum*currnum,sb.append("*"+currnum),'*',currnum);
                    sb.setLength(len);
                } else {
                    helper(num,target,pos+1,res,curr*currnum,sb.append("*"+currnum),'*',currnum);
                    sb.setLength(len);
                }
            }
        }
    }

}
