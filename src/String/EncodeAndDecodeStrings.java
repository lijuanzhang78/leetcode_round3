package String;

public class EncodeAndDecodeStrings {
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        for(int index = 0; index < s.length();) {
            int count = 0;
            while(s.charAt(index) != '/') {
                count = count*10 + (s.charAt(index) - '0');
                index++;
            }
            index++;
            int begin = index, end = begin+count;
            res.add(s.substring(begin,end));
            index = end;
        }
        return res;
    }

}
