package Stack;

// there could be negative numbers
//
public class EvaluteReversePolishNotation {
	public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for(String curr : tokens) {
            if (curr.charAt(0) >= '0' && curr.charAt(0) <= '9' || curr.length() > 1 && curr.charAt(1) >= '0' && curr.charAt(1) <= '9') {
                stack.push(Integer.valueOf(curr));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (curr.equals("+")) {
                    stack.push(num1 + num2);
                } else if (curr.equals("-")) {
                    stack.push(num2 - num1);
                } else if (curr.equals("*")) {
                    stack.push(num1*num2);
                } else {
                    stack.push(num2/num1);
                }    
            }
        }
        
        return stack.pop();
    }

}
