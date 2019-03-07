public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman i = new IntegerToRoman();
        String str = "asdasd";
        System.out.println(str.replace('a','g'));
        String arr[] = new String[]{"asdsadsa"};
        arr[0].replace('a','j');
        System.out.println(arr[0]);

        System.out.println(i.intToRoman(1994));
    }
    private static String M[] = {"","M","MM","MMM"};
    private static String C[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    private static String X[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    private static String I[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        return roman.append(M[num/1000]).append(C[(num%1000)/100]).append(X[(num%100)/10]).append(I[num%10]).toString();
    }

}
