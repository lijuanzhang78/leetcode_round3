package Google;

public class _482_LicenseKeyFormatting {
	public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0) return "";
        int i = S.length()-1, count = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0) {
            char c = S.charAt(i);
            if (c == '-') continue;
            sb.append(convert(S.charAt(i)));
            count++;
            if (count == K) {
                sb.append('-');
                count = 0;
            }
            i--;
        }
        String res = sb.toString();
        if (res.charAt(0) == '-') return res.substring(1);
        return res;
    }
                      
    char convert(char c) {
        if (c >= 'a' && c <= 'z') return (char)('A'+c-'a');
        return c;
    }
    
    public static void main(String[] args) {
    	String S = "5F3Z-2e-9-w";
    	int K = 4;
    	String res = new _482_LicenseKeyFormatting().licenseKeyFormatting(S, K);
    	return;
    }

}
