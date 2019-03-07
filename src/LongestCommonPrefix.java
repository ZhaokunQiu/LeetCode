public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println(l.longestCommonPrefix(new String[]{"asdf","asd","faas"}));
    }

    public String longestCommonPrefix(String[] strs) {
        int length =Integer.MAX_VALUE;
        int size = strs.length;
        for(String temp : strs){
            length = length<temp.length()?length:temp.length();
        }
        if(length == 0||size==0)
            return "";
        int result=0;
        for(result=0;result<length;++result){
            for(int j=0;j<size-1;++j){
                if(strs[j].charAt(result)!=strs[j+1].charAt(result)){
                    return strs[j].substring(0,result);
                }
            }
        }
        return strs[0].substring(0,length);
    }
}
