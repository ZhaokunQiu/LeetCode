public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman i = new IntegerToRoman();
        String str = "asdasd";
        System.out.println(str.replace('a','g'));
        String arr[] = new String[]{"asdsadsa"};
        arr[0].replace('a','j');
        System.out.println(arr[0]);

        System.out.println(i.intToRoman(399));
    }
    public String intToRoman(int num) {
        String media[] = new String[]{
                    "","I","II","III","IV","V","VI","VII","VIII","IX"
        };
        String result = "";
        int chushu = 1000;
        while(num>0){
            int shang = num / chushu;
            num%=chushu;
            String temp = media[shang];
            switch (chushu){
                case 1000:
                    temp.replace('I','M');
                    break;
                case 100:
                    temp.replace('I','C');
                    temp.replace('V','D');
                    temp.replace('X','M');
                    break;
                case 10:
                    temp.replace('X','M');
                    temp.replace('I','X');
                    temp.replace('V','L');
                    break;
                default:
                        break;
            }
            result+=temp;
            chushu/=10;
        }
        return result;
    }
}
