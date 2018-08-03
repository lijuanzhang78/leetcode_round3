package Google;

public class _273_IntegerToEnglishWords {
	String[] thousands = {"", "Thousand","Million","Billion"};
    String[] lessThan20 = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] twenties = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int i = 0;
        String res = "";
        while(num != 0) {
            if (num % 1000 != 0) {
                res = helper(num%1000) + " " + thousands[i] + " " + res;
            }
            num = num/1000;
            i++;
        }
        return res.trim();
    }
    
    String helper(int num) {
        String res = "";
        if (num == 0) return res;
        if (num >= 100) {
            res = lessThan20[num/100] + " " + "Hundred" + " " + helper(num%100);
        } else if (num >= 20) {
            res = twenties[num/10] + " " + helper(num%10);
        } else {
            res = lessThan20[num];
        }
        return res.trim();
    }

}
