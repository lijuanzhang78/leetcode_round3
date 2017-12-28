package String;

// 最后一行需要验证 if (sb.length() > 0 && count == 0)， 否则“---”的case通不过
// Character.toUppdercase(char c);
// StringBuilder sb.setLength();
// StringBuilder sb.reverse() 返回值仍然是stringbuilder
//
public class LicenseKeyFormatting {
	public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int i = S.length() - 1, count = 0;
        while(i >= 0) {
            char c = S.charAt(i);
            if (c != '-') {
                sb.append(Character.toUpperCase(c));
                count++;
                if (count == K) {
                    sb.append("-");
                    count = 0;
                }
            } 
            i--;
        }
        if (sb.length() > 0 && count == 0) sb.setLength(sb.length()-1);
        return sb.reverse().toString();
    }

}
