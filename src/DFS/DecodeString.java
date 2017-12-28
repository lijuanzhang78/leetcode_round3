package DFS;

//
//用的是recursion --》 String sub = decodeString(s.substring(begin,index-1));
//每次遇到【】都把里面的substring当成一个子问题，然后返回字符串，再跟之前的digit组合成答案
//套路：大问题分解成子不同的子问题，然后somehow组合成大问题的解，就可以用递归+返回值的方法解决
//
//今天刷得shopping offers 和 nested list weight sum 都是一类题。注意体会。
//
public class DecodeString {
	public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        int index = 0;
        StringBuilder sb = new StringBuilder();
        int digit = 0;
        while(index < s.length()) {
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                digit = 0;
                while(s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    digit = digit*10 + (s.charAt(index)-'0');
                    index++;
                }
            } else if (s.charAt(index) == '[') {
                index++;
                int begin = index;
                int count = 1;
                while(index < s.length()) {
                    if (s.charAt(index) == '[') count++;
                    if (s.charAt(index) == ']') count--;
                    index++;
                    if (count == 0) break;
                }
                
                String sub = decodeString(s.substring(begin,index-1));
                while(digit > 0) {
                    sb.append(sub);
                    digit--;
                }
            } else {
                sb.append(s.charAt(index));
                index++;
            }
            //index++;
        }
        return sb.toString();    
    }

}
