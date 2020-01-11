package StringDP;

public class LongestCommonSubsequencePrint {
    private static String longestSubsequence(String str1, String str2, String[][] memoization){
        if(str1.charAt(0)==str2.charAt(0)) memoization[0][0]=String.valueOf(str1.charAt(0));
        else memoization[0][0]="";
        for(int i=1;i<str1.length();i++){
            if(str1.charAt(i)==str2.charAt(0)) memoization[i][0]=String.valueOf(str1.charAt(i));
            else memoization[i][0]=memoization[i-1][0];
        }
        for(int i=1;i<str2.length();i++){
            if(str2.charAt(i)==str1.charAt(0)) memoization[0][i]=String.valueOf(str2.charAt(i));
            else memoization[0][i]=memoization[0][i-1];
        }
        for(int i=1;i<str1.length();i++){
            for(int j=1;j<str2.length();j++){
                if(str2.charAt(j)==str1.charAt(i)) {
                    memoization[i][j] = memoization[i-1][j-1]+str1.charAt(i);
                }
                else{
                    if(memoization[i-1][j].length()>=memoization[i][j-1].length()) memoization[i][j]=
                            memoization[i-1][j];
                    else memoization[i][j]=memoization[i][j-1];
                }
            }
        }
        return memoization[str1.length()-1][str2.length()-1];
    }
    public static void main(String[] args) {
        String str1 = "XMJYAUZ";
        String str2 = "MZJAWXU";
        String[][] memoization = new String[str1.length()][str2.length()];
        String res = longestSubsequence(str1,str2,memoization);
        System.out.println(res);
    }
}
