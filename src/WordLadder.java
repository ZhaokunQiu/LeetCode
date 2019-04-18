import java.security.KeyStore;
import java.util.*;

public class WordLadder {
    Set<Integer> unVisited;
    Set<Integer> visited;
    int result[];

    public static List<String>[] temp = new ArrayList[6];
    public static void main(String[] args) {
        String begin = "talk";
        String end = "tail";
        List<String> word = new ArrayList<>(
                Arrays.asList("talk","tons","fall","tail","gale","hall","negs")
        );
        WordLadder w = new WordLadder();
        System.out.println(w.ladderLength(begin,end,word));
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int endPos = -1;
        for(int i = 0;i < wordList.size();i ++) {
            if (wordList.get(i).equals(endWord)){
                endPos = i + 1;
                break;
            }
        }
        if(endPos == -1)
            return 0;
        result = new int[wordList.size() + 1];
        unVisited = new HashSet<>();
        visited = new HashSet<>();
        for(int i = 0;i < wordList.size();i++) {
            result[i + 1] = getDistance(beginWord,wordList.get(i));
            unVisited.add(i + 1);
        }
        visited.add(0);
        while(!unVisited.isEmpty()){
            int i = findNearestU();
            if(i == 0 || i == endPos)
                break;
            visited.add(i);
            unVisited.remove(i);
            relax(i,wordList);
        }
        return result[endPos] > result.length ? 0 : result[endPos] + 1;
    }

    private void relax(int index, List<String> wordList) {
        for(int i : unVisited){
            int dis = result[index] + getDistance(wordList.get(index - 1),wordList.get(i - 1));
            result[i] = result[i] < dis ? result[i] : dis;
        }
    }

    private int findNearestU() {
        int index = 0;
        int min = Integer.MAX_VALUE;

        for(Iterator<Integer> it = unVisited.iterator();it.hasNext();){
            int i = it.next();
            if(min > result[i]){
                index = i;
                min = result[i];
            }
        }
        return index;
    }

    private int getDistance(String a, String b){
        int delta = 0;
        for(int i = 0;i < a.length();i++)
            if(a.charAt(i) != b.charAt(i))
                delta ++;
        return delta == 1 ? 1 : result.length + 1;
    }

}
