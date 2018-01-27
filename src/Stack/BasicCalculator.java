package Stack;

// 注意的问题
// (1) 遇到数字的时候，需要用一个while来看后面是不是还有数字, 但是需要判断是不是到了字符串末尾 （line 17）
// (2) 把+号-号看成是数字的正负号，并且用sign存起来，用来跟后面的数字结合
// (3) 遇到左括号的时候，需要找到与之对应的右括号，然后括号中间的部分看成是子问题，再递归调用，注意此时i的值应该移动到右括号的下一位。（line j+1）
//
public class BasicCalculator {
	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int sign = 1;
        int res = 0;
        int num = 0;
        for(int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            } else if (c >= '0' && c <= '9') {
                while(i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == ' ')) {
                    if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        num = num*10 + (s.charAt(i)-'0');
                    }
                    i++; // now point to the next position
                }
                res += sign*num;
                sign = 1;
                num = 0;
                continue;
            } else if (c == '+') {
                sign = 1;
                i++;
            } else if (c == '-') {
                sign = -1;
                i++;
            } else if (c == '(') { // i -> (
                int count = 1;
                int j = i + 1;
                for(; j < s.length();j++) {
                    if (s.charAt(j) == '(') {
                        count++;
                    } else if (s.charAt(j) == ')') {
                        count --;
                    }
                    if (count == 0) {
                        int subres = calculate(s.substring(i+1,j));
                        res += sign*subres;
                        break;
                    }
                }
                sign = 1;
                i = j+1;
            }    
        }
        return res;
    }

	public static void main(String[] args) {
		String s = "(1+(4+5+2)-3)+(6+8)";
		int res = new BasicCalculator().calculate(s);
		return;
	}
}
