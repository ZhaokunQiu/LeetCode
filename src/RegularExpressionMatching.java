import javax.sound.midi.Soundbank;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        String temp="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        long middle =0;
        int nums = 100000000;
        char a=' ';
        long start =System.currentTimeMillis();
        for(int i=0;i<nums;++i){
            int length = temp.length();
            for(int j=0;j<length;++j)
                a=temp.charAt(j);
        }
        System.out.println(System.currentTimeMillis()-start);
        start =System.currentTimeMillis();
        for(int i=0;i<nums;++i){
            char ad[] = temp.toCharArray();
            int length = temp.length();
            for(int j=0;j<length;++j)
                a=ad[j];
        }
        System.out.println(System.currentTimeMillis()-start);
        RegularExpressionMatching r = new RegularExpressionMatching();
        System.out.println(r.isMatch("aab","s*a*b*."));
    }
    public boolean isMatch(String text, String pattern) {
        //如果都为空则匹配成功
        if (pattern.isEmpty()) return text.isEmpty();

        //第一个是否匹配上
        boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            //看有没有可能,剩下的pattern匹配上全部的text
            //看有没有可能,剩下的text匹配整个pattern
            //isMatch(text, pattern.substring(2)) 指当p第二个为*时，前面的字符不影响匹配所以可以忽略，所以将*以及*之前的一个字符删除后匹配之后的字符，这就是为什么用pattern.substring(2)
            //如果第一个已经匹配成功，并且第二个字符为*时，这是我们就要判断之后的需要匹配的字符串是否是多个前面的元素（*的功能），这就是first_match && isMatch(text.substring(1), pattern))的意义
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            //没有星星的情况:第一个字符相等,而且剩下的text,匹配上剩下的pattern，没有星星且第一个匹配成功，那么s和p同时向右移动一位看是否仍然能匹配成功
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }


    //更高效的实现

    public boolean isMatch2(String s, String p) {
        int m=s.length();
        int n=p.length();
        boolean[][] dp=new boolean[m+1][n+1];

        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]=dp[0][i-2];
            }
        }

        char[] str=s.toCharArray();
        char[] patt=p.toCharArray();

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(patt[j-1]=='.'||str[i-1]==patt[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    if(patt[j-1]=='*'){
                        dp[i][j]=dp[i][j-2];
                        if(patt[j-2]==str[i-1]||patt[j-2]=='.'){
                            dp[i][j]=dp[i][j]||dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }
}
