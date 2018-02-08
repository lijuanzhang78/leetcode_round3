package TwoPointers;

// 解法很巧妙

public class PartitionLabels {
	public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) return new ArrayList<Integer>();
        char[] arr = S.toCharArray();
        int[] lastpos = new int[26];
        for(int i = 0; i < arr.length; i++) {
            lastpos[arr[i]-'a'] = i;
        }
        List<Integer> res = new ArrayList<Integer>();
        int start = 0, last = 0;
        for(int i = 0; i < arr.length; i++) {
            last = Math.max(last,lastpos[arr[i]-'a']);
            if (i == last) {
                res.add(i-start+1);
                start = i+1;
            }
        }
        return res;
    }

}
