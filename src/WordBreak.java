import java.util.*;

public class WordBreak {
    HashMap<Character,List<String>> temp;

    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        List<String> word = new ArrayList<>();
        word.add("leet");
        word.add("code");
        String s = "leetcode";
        w.wordBreak2(s,word);
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

    List<String> result = new ArrayList<>();
    public List<String> wordBreak2(String s, List<String> wordDict) {
        if(s.length() == 0)
            return result;
        if(wordDict.size() == 0)
            return result;
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        List<Integer>[] temp = new ArrayList[dp.length];
        temp[0] = new ArrayList<>();
        for(int i = 1;i < dp.length;i++){
            temp[i]  = new ArrayList<>();
            dp[i] = false;
            for(int j  = 0;j < wordDict.size();j++){
                String ss = wordDict.get(j);
                if(i - ss.length() < 0)
                    continue;
                if(dp[i - ss.length()]  && s.substring(i - ss.length(),i).equals(ss)){
                    dp[i] = true;
                    temp[i].add(j);
                }
            }
        }
        int index = dp.length;
        if(dp[index - 1])
        generate(index - 1,new LinkedList<>(),wordDict,temp);
        return result;
    }


    private void generate(int index,  List<Integer> list, List<String> word, List<Integer>[] temp){
        if(index == 0){
            StringBuilder sb = new StringBuilder();
            for(Integer i : list){
                sb.append(word.get(i) + " ");
            }
            result.add(sb.toString().trim());
            return;
        }
        for(Integer i : temp[index]){
            LinkedList<Integer> nl = new LinkedList<>(list);
            nl.addFirst(i);
            generate(index - word.get(i).length(),nl,word,temp);
        }
    }

}
