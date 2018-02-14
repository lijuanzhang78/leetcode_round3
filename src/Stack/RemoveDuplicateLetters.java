package Stack;

public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return "";
        LinkedList<Character> stack = new LinkedList<>();
        char[] arr = s.toCharArray();
        boolean[] visited = new boolean[26];
        int[] count = new int[26];
        for(char c : arr) {
            count[c-'a']++;
        }
        for(char c : arr) {
            if (visited[c-'a']) {
                count[c-'a']--; // this line is important! always play safe
                continue;
            }
            while (stack.size() > 0 && stack.peek() > c && count[stack.peek()-'a'] > 0) {
                char prev = stack.pop();
                visited[prev-'a'] = false;
            }
            stack.push(c);
            visited[c-'a'] = true;
            count[c-'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
