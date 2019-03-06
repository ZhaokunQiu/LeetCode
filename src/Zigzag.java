public class Zigzag {

    public static void main(String[] args) {
        Zigzag z = new Zigzag();
        System.out.println(z.convert("pa",1));
    }

    public String convert(String s, int numRows) {
        int length = s.length();
        if (length <= numRows || numRows == 1) return s;
        char[] chars = new char[length];
        int step = 2 * (numRows - 1);
        int count = 0;
        for (int i = 0; i < numRows; i++){
            int interval = step - 2 * i;
            for (int j = i; j < length; j += step){
                chars[count] = s.charAt(j);
                count++;
                if (interval < step && interval > 0
                        && j + interval < length && count <  length){
                    chars[count] = s.charAt(j + interval);
                    count++;
                }
            }
        }
        return new String(chars);
    }
}
