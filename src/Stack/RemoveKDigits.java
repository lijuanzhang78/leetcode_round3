package Stack;

import java.util.LinkedList;

// k keeps track of how many elements we are allowed to remove
// go through the digits from left to right, if the top element of the stack is greater than the current element, pop the element until
// (1) size of stack is zero, OR
// (2) top element is smaller or equal to the current element, OR
// (3) there is not enough k to remove
//
// need to check if k == 0 after the for loop, think about an increasing array, there is no chance to remove any element
// 
// remember to keep the element if it's equal to the top element
//
public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) return "";
        LinkedList<Character> stack = new LinkedList<>();
        char[] arr = num.toCharArray();
        for(int i = 0; i < num.length(); i++) {
            while(k > 0 && stack.size() > 0 && stack.peek() > arr[i]) { // need to be greater, NOT greater or equal, otherwise missed the case "112" and k = 1
                stack.pop();
                k--;
            }
            // just push the element if while condition is not met
            stack.push(arr[i]);    
        }
        
        while(k > 0 && stack.size() > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0) {
            sb.append(stack.pop());
        }
        String res = sb.reverse().toString();
        while(res.length() > 0 && res.charAt(0) == '0') {
            res = res.substring(1);
        }
        return res.equals("")? "0" : res;
    }
	
	public static void main(String[] args) {
		String num = "1432219";
		int k = 3;
		String res = new RemoveKDigits().removeKdigits(num, k);
		return;
	}
}
