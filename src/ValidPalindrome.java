public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(Character.toUpperCase('0'));
        System.out.println(v.isPalindrome("race a car"));
    }
    public boolean isPalindrome(String s) {
        if(s.length()<=1)
            return true;
        int i=0,j=s.length()-1;
        char temp[] = s.toCharArray();
        for(;i<j;){
            while(!Character.isLetterOrDigit(temp[i])&&i<j)
                i++;
            while(!Character.isLetterOrDigit(temp[j])&&i<j)
                j--;
            if(Character.toUpperCase(temp[i++])!=Character.toUpperCase(temp[j--]))
                return false;
        }
        return true;
    }
}
