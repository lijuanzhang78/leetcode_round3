package Google;

public class _844_BackspaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
        StringBuilder ss = new StringBuilder();
        StringBuilder st = new StringBuilder();
        
        getFinalString(S,ss);
        getFinalString(T,st);
        return ss.reverse().toString().equals(st.reverse().toString());
    }
    
    void getFinalString(String s, StringBuilder sb) {
        char[] arr = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != '#') {
                stack.push(arr[i]);
            } else {
                if (stack.size() > 0) stack.pop();
            }   
        }
        
        while(stack.size() > 0) {
            sb.append(stack.pop());
        }    
    }

}
