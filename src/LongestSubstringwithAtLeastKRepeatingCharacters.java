public class LongestSubstringwithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringwithAtLeastKRepeatingCharacters l = new LongestSubstringwithAtLeastKRepeatingCharacters();
        System.out.println(l.longestSubstring("aaabb",3));
    }


    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int[] charNum = new int[26];
        for(char temp : s.toCharArray())
            charNum[temp - 'a'] += 1;

        boolean flag = true;
        for(int temp : charNum)
            if(temp > 0 && temp < k){
                flag = false;
                break;
            }
        if(flag)
            return s.length();



        int start = 0, cur = 0;
        int result = 0;

        while(cur < s.length()){
            if(charNum[s.charAt(cur) - 'a'] < k){
                result = Math.max(result, longestSubstring(s.substring(start,cur), k));
                start = cur + 1;
            }
            cur++;

        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;

    }
}
