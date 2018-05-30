package Google;

public class _293_FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        for(int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                String before = i >= 1? s.substring(0,i) : "";
                String after = i+2 > s.length()-1? "" : s.substring(i+2);
                res.add(before+"--"+after);
            }
        }
        return res;
    }

}
