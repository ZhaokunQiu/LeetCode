public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger r =new RomanToInteger();
        System.out.println(r.romanToInt("M"));
    }
    public int romanToInt(String s) {
        char romans[] = s.toCharArray();
        int result =0;
        int size = romans.length;
        for(int i=0;i<size;++i){
            char cur = romans[i];
            switch(cur){
                case 'I':
                    if(i+1<size&&(romans[i+1]=='V'||romans[i+1]=='X'))
                        --result;
                    else ++result;
                    break;
                case 'V':
                    result+=5;
                    break;
                case 'X':
                    if(i+1<size&&(romans[i+1]=='L'||romans[i+1]=='C'))
                        result-=10;
                    else result+=10;
                    break;
                case 'L':
                    result+=50;
                    break;
                case 'C':
                    if(i+1<size&&(romans[i+1]=='D'||romans[i+1]=='M'))
                        result-=100;
                    else result+=100;
                    break;
                case 'D':
                    result+=500;
                    break;
                case 'M':
                    result+=1000;
                    break;
            }
        }
        return result;
    }

    //更高效的解法

    public int romanToInt2(String s) {
        int[] nums=new int[s.length()];
        for(int i=0;i<s.length();i++) {
            switch (s.charAt(i)) {
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return sum+nums[nums.length-1];
    }
}
