package String;

// ‘|| i == s.length() -1’ 因为需要把最后一个num push到stack里面
// 2+3-4*2: 每遇到一个operator或者是字符串末尾，需要push数字到stack
// +或者-看成是数字的正负号
// 这类题需要特别注意最后一个num!!!
// 可以用string.trim().replaceAll(" ","")去掉空格
//
public class BasicCalculatorII {
	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        char sign = '+';
        int num = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num*10 + (c-'0');
            } 
            
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() -1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop()*num);
                } else if (sign == '/') {
                    stack.push(stack.pop()/num);
                }
                num = 0;
                sign = c;
            }    
        }
        
        int res = 0;
        while(stack.size() > 0) {
            res += stack.pop();
        }
        return res;
    }
	
	// 第二版
	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim().replaceAll(" ","");
        LinkedList<Integer> stack = new LinkedList<>();
        char sign = '+';
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num*10 + (c-'0');
            } 
            
            if (i == s.length() - 1 || c == '+' || c == '-' || c == '*' || c == '/') {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop()*num);
                } else if (sign == '/') {
                    stack.push(stack.pop()/num);
                }
                num = 0;
                sign = c;
            }
        }
        
        int res = 0;
        while(stack.size() > 0) {
            res += stack.pop();
        }
        return res;
    }

}
