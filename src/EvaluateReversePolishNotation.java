import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0)
            return 0;
        LinkedList<Integer> helper = new LinkedList<>();
        for(String temp : tokens){
            if(temp.length() == 1){
                switch(temp.charAt(0)) {
                    case '+':
                        int a = helper.pop();
                        int b= helper.pop();
                        helper.push(a + b);
                        break;
                    case '-':
                        int jiana = helper.pop();
                        int jianb = helper.pop();
                        helper.push(jiana - jianb);
                        break;
                    case '*':
                        int chenga = helper.pop();
                        int chengb = helper.pop();
                        helper.push(chenga * chengb);
                        break;
                    case '/':
                        int chua = helper.pop();
                        int chub = helper.pop();
                        helper.push(chua / chub);
                        break;
                    default:
                        helper.push(Integer.parseInt(temp));
                        break;
                }
            }
            else {
                helper.push(Integer.parseInt(temp));
            }
        }
        return helper.pop();
    }
}
