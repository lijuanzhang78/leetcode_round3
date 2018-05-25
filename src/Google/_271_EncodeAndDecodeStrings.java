package Google;

public class _271_EncodeAndDecodeStrings {
	public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int start = 0, slash = 0;
        List<String> res = new ArrayList<>();
        while(start < s.length()) {
            slash = s.indexOf("/",start);
            int len = Integer.parseInt(s.substring(start,slash));
            res.add(s.substring(slash+1,slash+len+1));
            start = slash+len+1;
        }
        return res;    
    }

}
