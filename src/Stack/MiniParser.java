package Stack;

import java.util.LinkedList;

public class MiniParser {
	public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) return null;
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        LinkedList<NestedInteger> stack = new LinkedList<>();
        int start = 0;
        for(int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.push(new NestedInteger());
                i++;
            } else if (c == ',') {
                i++;
            } else if (c == ']') {
                NestedInteger top = stack.pop();
                if (!stack.isEmpty()) {
                    NestedInteger ni = stack.peek();
                    ni.getList().add(top);
                    //ni.add(top);
                } else {
                    return top;
                }
                i++;
            } else {
                start = i;
                while(i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-')) {
                    i++;
                }
                String num = s.substring(start,i);
                if (!stack.isEmpty()) {
                    NestedInteger ni = stack.peek(); 
                    ni.getList().add(new NestedInteger(Integer.parseInt(num)));
                    //ni.add(new NestedInteger(Integer.parseInt(num)));
                }
            }
        }
        return null;
    }
	
	public static void main(String[] args) {
		String s = "[-1]";
		NestedInteger res = new MiniParser().deserialize(s);
		return;
	}

}
