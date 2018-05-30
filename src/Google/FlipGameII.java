package Google;

public class FlipGameII {
	public boolean canWin(String s) {
        if (s == null || s.length() == 0) return false;
        return canWinHelper(s.toCharArray());
    }
    
    boolean canWinHelper(char[] s) {
        for(int i = 0; i < s.length - 1; i++) {
            if (s[i] == '+' && s[i+1] == '+') {
                s[i] = '-'; s[i+1] = '-';
                boolean nextPlayer = canWinHelper(s);
                s[i] = '+'; s[i+1] = '+';
                if (!nextPlayer) return true;
            }
        }
        return false;
    }

}
