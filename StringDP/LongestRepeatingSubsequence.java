package StringDP;

public class LongestRepeatingSubsequence {
    private static String longestRepeatingSubsequence(String str1, String[][] memoization){
        for(int i=0;i<str1.length();i++){
            for(int j=0;j<str1.length();j++){
                if(i==0||j==0 && str1.charAt(i)==str1.charAt(j)) memoization[i][j]=""+str1.charAt(i);
                else memoization[i][j]="";
            }
        }
        for(int i=1;i<str1.length();i++){
            for(int j=1;j<str1.length();j++){
                if(str1.charAt(i)==str1.charAt(j) && i!=j) memoization[i][j]=memoization[i-1][j-1]+str1.charAt(i);
                else{
                    if(memoization[i-1][j].length()>=memoization[i][j-1].length()) memoization[i][j]=memoization[i-1][j];
                    else memoization[i][j]=memoization[i][j-1];
                }
            }
        }
        return memoization[str1.length()-1][str1.length()-1];
    }
    public static void main(String[] args) {
        String str1 = "ATACTCGGA";
        String[][] memoization = new String[str1.length()][str1.length()];
        String res = longestRepeatingSubsequence(str1,memoization);
        System.out.println(res);
    }
}
