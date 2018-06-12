package Google_Lintcode;

public class _1401_TwitchWords {
	public int[][] twitchWords(String str) {
        if (str == null || str.length() == 0) return new int[0][0];
        List<int[]> res = new ArrayList<>();
        int count = 0;
        int start = -1;
        for(int i = 0; i < str.length(); i++) {
            if (i == 0 || str.charAt(i) != str.charAt(i-1)) {
                if (count >= 3) {
                    res.add(new int[]{start,i-1});
                } 
                start = i; count = 1;
            } else {
                count++;
            }
        }
        if (count >= 3) res.add(new int[]{start,str.length()-1});
        int[][] resarr = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) {
            resarr[i] = res.get(i);
        }
        return resarr;
    }

}
