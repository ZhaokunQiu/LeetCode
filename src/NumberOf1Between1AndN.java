public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        int base = 1;
        while(base <= n){
            int shang = n / (base * 10) ;
            int yu = n % (base * 10);
            sum += base * shang;
            if(yu >= base * 2)
                sum += base;
            else if(yu >= base)
                sum += (yu - base + 1);
            base *= 10;
        }
        return sum;
    }
}
