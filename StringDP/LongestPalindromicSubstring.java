package StringDP;

public class LongestPalindromicSubstring {
    private static int longestPalindromicSubstring(String str1, int[][] memoization){
        for(int i=0;i<str1.length();i++){
            for(int j=0;j<str1.length();j++){
                if(i==j) memoization[i][j]=1;
            }
        }
        for(int i=1;i<str1.length();i++){
            for(int j=0;j<str1.length();j++){
                int start = j;
                int end=start+i;
                if(end<str1.length()){
                    if(str1.charAt(start)==str1.charAt(end)){
                        memoization[start][end]=2+memoization[start+1][end-1];
                    }
                    else{
                        memoization[start][end]=Math.max(memoization[start+1][end],memoization[start][end-1]);
                    }
                }
            }
        }
        return memoization[0][str1.length()-1];
    }
    public static void main(String[] args) {
        String str1 = "cbbd";
        int[][] memoization = new int[str1.length()][str1.length()];
        int res = longestPalindromicSubstring(str1,memoization);
        System.out.println(res);
    }
}
