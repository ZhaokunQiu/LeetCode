import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder re = new StringBuilder();
        long nnumerator = numerator;
        long ddenominator = denominator;
        long zheng = nnumerator / ddenominator;
        long yu = nnumerator % ddenominator;
        Set<Long> yushu = new HashSet<>();
        if((numerator ^ denominator) >>> 31 == 1 && yu != 0)
            re.append('-');
        re.append(zheng);
        yu = nnumerator % ddenominator;
        if(yu == 0)
            return re.toString();
        while(yu != 0 && !yushu.contains(yu)){
            yushu.add(yu);
            yu = yu * 10 % ddenominator;
        }
        re.append('.');
        if(yu == 0){
            yu = nnumerator % ddenominator;
            while(yu != 0){
                long sh = Math.abs(yu * 10 / ddenominator);
                yu = yu * 10 % ddenominator;
                re.append(sh);
            }
        }
        else{
            long mark = yu;
            yu = nnumerator % ddenominator;
            while(yu != mark){
                long sh = Math.abs(yu * 10 / ddenominator);
                yu = yu * 10 % ddenominator;
                re.append(sh);
            }
            re.append('(');
            do{
                long sh = Math.abs(yu * 10 / ddenominator);
                yu = yu * 10 % ddenominator;
                re.append(sh);
            }while(yu != mark);
            re.append(')');
        }
        return re.toString();
    }
}
