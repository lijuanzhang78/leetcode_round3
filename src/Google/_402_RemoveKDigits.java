package Google;

public class _402_RemoveKDigits {
	public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) return "";
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while(stack.size() > 0 && stack.peek() > c && k > 0) {
                k--;
                stack.pop();
            }
            stack.push(c);
        }
        
        while(k > 0 && stack.size() > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0) {
            sb.append(stack.pop());
        }
        String s = sb.reverse().toString();
        int i = 0;
        while(i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        return i == s.length()? "0" : s.substring(i);    
    }

}
