import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> hel = new HashSet<>(10);
        boolean flag = true;
        hel.add(n);
        while(n!=1){
            int temp = 0 ;
            while(n>0){
                temp+=(n%10)*(n%10);
                if(n%10==1)
                    flag = false;
                n/=10;
            }
            if(hel.contains(temp)){
                if(flag)
                    return true;
                return false;
            }
            hel.add(temp);
            n=temp;
        }
        return true;
    }
}
