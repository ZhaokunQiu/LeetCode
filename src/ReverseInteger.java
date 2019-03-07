public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(1230));
    }

    public int reverse(int x) {
        int result = 0;
        int zheng = 1;
        if (x > 0)
            zheng = 1;
        else zheng = -1;
        x = Math.abs(x);
        while (x > 0) {
            int temp = 10 * result;
            if (temp / 10 != result) //判断整数计算是否超过了最大值，只需逆运算判断跟原值是否一样！！！
                return 0;
            result = temp;
            result += x % 10;
            x /= 10;
        }
        return zheng * result;
    }
}
