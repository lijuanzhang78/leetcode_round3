package Google;

public class _320_GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        //if (word == null || word.length() == 0) return res;
        generateHelper(word,0,"",res,0);
        return res;
    }
    
    void generateHelper(String word, int pos, String curr, List<String> res, int count) {
        if (pos == word.length()) {
            if (count != 0) {
                res.add(curr + count);
            } else {
                res.add(curr);
            }
            return;
        }
        generateHelper(word,pos+1,curr+ (count == 0? "" : ""+count) + word.charAt(pos),res,0);
        generateHelper(word,pos+1,curr,res,count+1);
    }

}
