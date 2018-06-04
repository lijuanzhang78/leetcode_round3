package Google;

public class _408_ValidWordAbbreviation {
	public boolean validWordAbbreviation(String word, String abbr) {
        if ((word == null || word.length() == 0) && (abbr == null || abbr.length() == 0)) return true;
        if ((word == null || word.length() == 0) || (abbr == null || abbr.length() == 0)) return false;
        int iword = 0, iabbr = 0;
        while(iword < word.length()  && iabbr < abbr.length()) {
            int num = 0;
            while (iabbr < abbr.length() && abbr.charAt(iabbr)>= '0' && abbr.charAt(iabbr)<='9') {
                if (num == 0 && abbr.charAt(iabbr) == '0') return false; // 错误
                num = num*10 + abbr.charAt(iabbr)-'0';
                iabbr++;
            }
            iword += num;
            if (iword == word.length() && iabbr == abbr.length()) return true;
            if (iword == word.length() || iabbr == abbr.length()) return false;
            if (word.charAt(iword) == abbr.charAt(iabbr)) {
                iword++;iabbr++;
            } else {
                return false;
            }    
        }
        return iword == word.length() && iabbr == abbr.length();
    }

}
