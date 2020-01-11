package StringDP;

public class LongestCommonSubstring {
    private static String longestCommonSubstring(String str1, String str2, String[][] memoization){
        int max = 0;
        String result = "";
        if(str1.charAt(0)==str2.charAt(0)) memoization[0][0]=String.valueOf(str1.charAt(0));
        else memoization[0][0]="";
        for(int i=1;i<str1.length();i++){
            if(str1.charAt(i)==str2.charAt(0)) memoization[i][0]=String.valueOf(str1.charAt(i));
            else memoization[i][0]="";
            if(memoization[i][0].length()>max) {
                max=memoization[i][0].length();
                result=memoization[i][0];
            }
        }
        for(int i=1;i<str2.length();i++){
            if(str2.charAt(i)==str1.charAt(0)) memoization[0][i]=String.valueOf(str2.charAt(i));
            else memoization[0][i]="";
            if(memoization[0][i].length()>max) {
                max=memoization[0][i].length();
                result=memoization[0][i];
            }
        }
        for(int i=1;i<str1.length();i++){
            for(int j=1;j<str2.length();j++){
                if(str2.charAt(j)==str1.charAt(i)) {
                    memoization[i][j] = memoization[i-1][j-1]+str1.charAt(i);
                }
                else memoization[i][j]="";
                if(memoization[i][j].length()>max) {
                    max=memoization[i][j].length();
                    result=memoization[i][j];
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String str1 = "abad";
        String str2 = "daba";
        String[][] memoization = new String[str1.length()][str2.length()];
        String res = longestCommonSubstring(str1,str2,memoization);
        System.out.println(res);
    }
}
