public class Palindrome {
    public boolean isPalindrome(int x) {
        String temp = String.valueOf(x);
        int high = temp.length() -1;
        int low= 0 ;
        while(low<high){
            if(temp.charAt(low)!=temp.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
    //更好地实现
    public boolean isPalindrome2(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        //the length can be even or odd
        return (x==rev || x==rev/10);
    }
}
