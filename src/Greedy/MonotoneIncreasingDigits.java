package Greedy;

public class MonotoneIncreasingDigits {
	public int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        if (s.length() == 1) return N;
        char prev = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(prev);
        for(int i = 1; i < s.length(); i++) {
            if (s.charAt(i) >= prev) {
                sb.append(s.charAt(i));
                prev = s.charAt(i);
            } else {
                int j = i-1;
                for(; j >= 0; j--) {
                    if (s.charAt(j) < prev) break;
                }
                int smaller = s.charAt(j+1) - '0' - 1;
                sb.setLength(j+1);
                sb.append(smaller);
                for(int k = j+2; k < s.length(); k++) {
                    sb.append('9');
                }
                break;
            }    
        }
        String news = sb.charAt(0) == '0' ? sb.toString().substring(1) : sb.toString();
        return Integer.parseInt(news);
    }

}
