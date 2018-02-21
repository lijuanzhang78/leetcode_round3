package String;

public class StringComrpession {
	public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int res = 0, num = 0;
        char curr = chars[0];
        int start = 0;
    
        for(int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != curr) {
                num = i-start;
                String nums = new String(""+num);
                char[] arr = nums.toCharArray();
                if (num == 1) {
                    chars[res] = curr;
                    res++;
                } else {
                    chars[res] = curr;
                    res++;
                    for(int j = 0; j < arr.length; j++) {
                        chars[res] = arr[j];
                        res++;
                    }
                }
                
                start = i;
                if (i != chars.length) curr = chars[i];
            }
        }
        return res;
    }
	
	public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int res = 0, num = 0;
        char curr = chars[0];
        int start = 0;
    
        for(int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != curr) {
                num = i-start;
                String nums = new String(""+num);
                char[] arr = nums.toCharArray();
                if (num == 1) {
                    chars[res++] = curr;
                } else {
                    chars[res++] = curr;
                    for(int j = 0; j < arr.length; j++) {
                        chars[res++] = arr[j];
                    }
                }
                
                start = i;
                if (i != chars.length) curr = chars[i];
            }
        }
        return res;
    }

}
