package String;

//A的substring都可能以A的任何一个字符开头
public class RepeatedStringMatch {
	public int repeatedStringMatch(String A, String B) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if (sb.indexOf(B) >= 0) return count;
        if (sb.append(A).indexOf(B) >= 0) return ++count;
        return -1;
    }

}
