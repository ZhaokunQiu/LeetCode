import java.util.*;

public class WordBreak {
    HashMap<Character,List<String>> temp;

    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        List<String> word = new ArrayList<>();
        word.add("leet");
        word.add("code");
        String s = "leetcode";
        w.wordBreak(s,word);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0)
            return true;
        if(wordDict.size() == 0)
            return false;
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1;i < dp.length;i++){
            dp[i] = false;
            for(String ss : wordDict){
                if(i - ss.length() < 0)
                    continue;
                if(dp[i - ss.length()] && s.substring(i - ss.length(),i).equals(ss)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }



}
