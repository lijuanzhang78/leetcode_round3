package Stack;

// 不要忘记最后需要check stack是否为空
//
public class ValidParentheses {
	public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.size() == 0) return false;
                if (stack.poll() != '(') return false;
            } else if (c == ']') {
                if (stack.size() == 0) return false;
                if (stack.poll() != '[') return false;
            } else if (c == '}') {
                if (stack.size() == 0) return false;
                if (stack.poll() != '{') return false;
            }
        }
        return stack.size() == 0;
    }

}
