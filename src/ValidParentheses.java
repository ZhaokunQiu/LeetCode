import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("((()]))"));
    }

    public boolean isValid(String s) {
        LinkedList<Character> temp = new LinkedList<Character>();
        if(s.length()==0)
            return true;
        int a = 0;
        int b = 0;
        int c = 0;
        char pp[] = s.toCharArray();
        for(char d : pp){
            switch (d){
                case '(':
                    ++a;
                    temp.push('(');
                    break;
                case ')':
                    if(--a<0||temp.pop()!='(')
                        return false;
                    break;
                case '[':
                    ++b;
                    temp.push('[');
                    break;
                case ']':
                    if(--b<0||temp.pop()!='[')
                        return false;
                    break;
                case '{':
                    ++c;
                    temp.push('{');
                    break;
                case '}':
                    if(--c<0||temp.pop()!='{')
                        return false;

            }
        }
        if(temp.isEmpty())
            return true;
        return false;
    }
}
