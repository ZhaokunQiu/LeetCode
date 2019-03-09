import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombination {

    public static void main(String[] args) {
        LetterCombination l = new LetterCombination();
        System.out.println(l.letterCombinations("234"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0)
            return result;
        HashMap<Character,ArrayList<Character>> rep = new HashMap<>();
        rep.put('2',new ArrayList<Character>(){{add('a');add('b');add('c');}});
        rep.put('3',new ArrayList<Character>(){{add('d');add('e');add('f');}});
        rep.put('4',new ArrayList<Character>(){{add('g');add('h');add('i');}});
        rep.put('5',new ArrayList<Character>(){{add('j');add('k');add('l');}});
        rep.put('6',new ArrayList<Character>(){{add('m');add('n');add('o');}});
        rep.put('7',new ArrayList<Character>(){{add('p');add('q');add('r');add('s');}});
        rep.put('8',new ArrayList<Character>(){{add('t');add('u');add('v');}});
        rep.put('9',new ArrayList<Character>(){{add('w');add('x');add('y');add('z');}});
        result.add(digits.substring(0,0));
        for(int i=0;i<digits.length();++i){
            List<String> temp = new ArrayList<>();
            ArrayList<Character> real = rep.get(digits.charAt(i));
            for(int j=0;j<result.size();++j){
                StringBuffer tt = new StringBuffer(result.get(j));
                for(int t=0;t<real.size();++t){
                    StringBuffer pp =new StringBuffer(tt);
                    temp.add(pp.append(real.get(t)).toString());
                }
            }
            result = temp;
        }
        return result;
    }


    //简洁高效的实现
    public List<String> letterCombinations2(String digits) {
        List<String> ans = new LinkedList<>();
        if (digits.length() == 0) return ans;
        ans.add("");

        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++) {
            int k = digits.charAt(i) - '0';
            int size = ans.size();
            for(int j = 0; j < size; j++){
                String x = ans.remove(0);
                for(char y : map[k].toCharArray())
                    ans.add(x + y);
            }
        }
        return ans;
    }
}
