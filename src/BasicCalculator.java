import java.util.LinkedList;

public class BasicCalculator {
    public int calculate(String s) {
        LinkedList<Character> sym = new LinkedList<>();
        LinkedList<Integer> num = new LinkedList<>();
        char[] temp = s.toCharArray();
        for(char tt : temp){
            switch(tt){
                case '+': sym.push('+');break;
                case '-': sym.push('-');break;
                case '*':
            }
        }
        return 0;
    }

}
