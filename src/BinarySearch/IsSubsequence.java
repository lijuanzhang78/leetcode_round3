package BinarySearch;

// 给两个字符串，求其中一个是不是另外一个的subsequence
// s = "abc", t = "tsanrbkkce", 返回true
//
// 解法一：two pointer O(N)
// 先初始化指针：两个指针分别指向两个字符串开始
// 如果两个指针所指向的字符相同，那么指向s的指针往前move，然后继续往前找与s的下一个字符相同的字符。
//
// 解法二：dynamic programming
// 使用二维dp[i][j], dp[t.length()+1][s.length()+1]
// dp[i][j]的意思是：长度为i的字符串t是否为长度为j的字符串s的subsequence
// 
// follow-up: If there are lots of incoming S, say S1, S2, ... , Sk 
// where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
//
// 先对t字符串做一个预处理，对于每个t的字符，找到他们的index，可以用一个Map<Character,List>来做
// 然后对于字符i+1， 需要找到他所在的位置list里面第一个大于字符i所在的位置(binary search)
//
public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        int indexs = 0, indext = 0;
        while(indext < t.length()) {
            if (s.charAt(indexs) == t.charAt(indext)) {
                indexs++;
                if (indexs == s.length()) return true;
            }
            indext++;
        }
        return false;
    }
}
