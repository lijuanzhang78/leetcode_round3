package Google;

public class _299_BullsAndCows {
	public String getHint(String secret, String guess) {
        if (secret == null || guess == null) return "";
        int[] count_s = new int[10];
        int[] count_g = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            count_s[c-'0']++;
        }
        for(int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            count_g[c-'0']++;
        }
        int match = 0;
        for(int i = 0; i < 10; i++) {
            match += Math.min(count_s[i],count_g[i]);
        }
        int cows = 0;
        for(int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
              cows++;  
            }
        }
        return cows+"A"+(match-cows)+"B";
        
    }

}
