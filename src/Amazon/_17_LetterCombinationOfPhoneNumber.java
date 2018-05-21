package Amazon;

public class _17_LetterCombinationOfPhoneNumber {
	String[] letters;
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<String>();
        letters = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        generateHelper(res,new StringBuilder(),digits,0);
        return res;
    }
    
    void generateHelper(List<String> res, StringBuilder sb, String digits,int currLevel) {
        if (currLevel == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String currstr = letters[digits.charAt(currLevel)-'0'];
        for(int i = 0; i < currstr.length(); i++) {
            sb.append(currstr.charAt(i));
            generateHelper(res,sb,digits,currLevel+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
