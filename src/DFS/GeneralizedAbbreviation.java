package DFS;

public class GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        //if (word == null || word.length() == 0) return res;
        char[] arr = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        dfs(arr,sb,0,res);
        return res;
    }
    
    void dfs(char[] arr, StringBuilder sb, int pos, List<String> res) {
        if (pos == arr.length) {
            res.add(sb.toString());
            return;
        }
        
        // to omit
        if (sb.length() > 0) {
           if (sb.charAt(sb.length()-1) >= '0' && sb.charAt(sb.length()-1) <= '9') {
                int prevnum = getPrevNum(sb);
                int currnum = prevnum+1;
                String prevS = new String(""+prevnum);
                sb.setLength(sb.length()-prevS.length());
                String newS = new String(""+currnum);
                sb.append(newS);
                dfs(arr,sb,pos+1,res);
                sb.setLength(sb.length()-newS.length());
                sb.append(prevS);
            } else {
                sb.append("1");
                dfs(arr,sb,pos+1,res);
                sb.setLength(sb.length() - 1);
            }
        } else {
            sb.append("1");
            dfs(arr,sb,pos+1,res);
            sb.setLength(sb.length() - 1);
        }
        
        // to keep
        sb.append(arr[pos]);
        dfs(arr,sb,pos+1,res);
        sb.setLength(sb.length() - 1);    
    }
    
    int getPrevNum(StringBuilder sb) {
        int res = 0;
        int base = 1;
        for(int i = sb.length()-1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if (ch < '0' || ch > '9') break;
            res += base*(ch-'0');
            base *= 10;
        }
        return res;
    }

}
