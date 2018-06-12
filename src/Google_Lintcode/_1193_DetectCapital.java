package Google_Lintcode;

public class _1193_DetectCapital {
	if (word == null || word.length() == 0) return false;
    boolean firstCapital = false;
    boolean allCapital = false;
    boolean allsmall = false;
    char first = word.charAt(0);
    if (word.length() == 1) {
        if(first >= 'A' && first <= 'Z') {
            return false;
        } else {
            return true;
        }
    }
    char second = word.charAt(1);
    if (first >= 'A' && first <= 'Z') {
        if (second >= 'A' && second <= 'Z') {
            allCapital = true;
        } else {
            firstCapital = true;
        }
    } else {
        if (second >= 'a' && second <= 'z') {
            allsmall = true;
        } else {
            return false;
        }
    }
    for(int i = 2; i < word.length(); i++) {
        char c = word.charAt(i);
        if (allCapital) {
            if (c >= 'a' && c <= 'z') return false;
        } else if (allsmall) {
            if (c >= 'A' && c <= 'Z') return false;
        } else if (firstCapital) {
            if (c >= 'A' && c <= 'Z') return false;
        }
    }
    return true;
}

}
