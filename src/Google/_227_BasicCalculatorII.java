package Google;

public class _227_BasicCalculatorII {
	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        s = s.trim();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num*10 + (c-'0');
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length()-1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop()*num);
                } else if (sign == '/') {
                    stack.push(stack.pop()/num);
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while(stack.size() > 0) {
            res += stack.pop();
        }
        return res;
    }

}
