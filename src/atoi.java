class Atoi {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0)return 0;
        long result = 0;
        int i = 0;
        int flag = 1;

        if(s.charAt(0) == '-')
        {
            flag = -1;
            i += 1;
        }
        else if(s.charAt(0) == '+')
        {
            flag = 1;
            i += 1;
        }

        while( i < s.length() && Character.isDigit(s.charAt(i)))
        {
            result = result * 10 + s.charAt(i) - '0';
            if (flag*result > Integer.MAX_VALUE ){
                return Integer.MAX_VALUE;
            }
            else if (flag*result<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i += 1;
        }
        return (int)(flag*result);
    }
}
