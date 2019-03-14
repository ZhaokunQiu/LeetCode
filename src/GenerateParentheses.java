import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        if(n==0)
            return result;
        generate(new String(""),n,n);
        return result;
    }

    public void generate(String temp,int left,int right){
        if(left == 0){
            StringBuffer newTemp = new StringBuffer(temp);
            for(int i=0;i<right;++i)
                newTemp.append(')');
            result.add(newTemp.toString());
            return;
        }
        else{
            StringBuffer bran1 = new StringBuffer(temp);
            bran1.append('(');
            generate(bran1.toString(),left - 1,right);
            if(right>left) {
                bran1.setCharAt(bran1.length() - 1, ')');
                generate(bran1.toString(),left,right-1);
            }
        }
    }
}
