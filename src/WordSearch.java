import java.sql.DriverManager;

public class WordSearch {
    boolean[][] flag;

//    private static ThreadLocal<LargestRectangleinHistogram> lrh = new ThreadLocal<>(){
//        public LargestRectangleinHistogram initialValue(){
//            return DriverManager.getConnection(DB_URL);
//        }
//    }
    public static void main(String[] args) {

    }


    public boolean exist(char[][] board, String word) {
        if(word.length()==0)
            return true;
        if(board.length ==0||board[0].length ==0)
            return false;
        flag = new boolean[board.length][board[0].length];
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[i].length;j++){
                if(board[i][j] == word.charAt(0)){
                    flag[i][j] = true;
                    if(dfs(board,i,j,word,1))
                        return true;
                    flag[i][j] = false;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, String word, int index){
        if(index == word.length())
            return true;
        if(i - 1 >= 0 && !flag[i-1][j] && board[i-1][j] == word.charAt(index)){
            flag[i-1][j] = true;
            if(dfs(board,i-1,j,word,index+1))
                return true;
            flag[i-1][j] = false;
        }
        if(i + 1 < board.length && !flag[i+1][j] && board[i+1][j] == word.charAt(index)){
            flag[i+1][j] = true;
            if(dfs(board,i+1,j,word,index+1))
                return true;
            flag[i+1][j] = false;
        }
        if(j - 1 >= 0 && !flag[i][j-1] && board[i][j-1] == word.charAt(index)){
            flag[i][j-1] = true;
            if(dfs(board,i,j-1,word,index+1))
                return true;
            flag[i][j-1] = false;
        }
        if(j + 1 < board[i].length && !flag[i][j+1] && board[i][j+1] == word.charAt(index)){
            flag[i][j+1] = true;
            if(dfs(board,i,j+1,word,index+1))
                return true;
            flag[i][j+1] = false;
        }
        return false;
    }
}
