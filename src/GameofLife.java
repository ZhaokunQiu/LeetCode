public class GameofLife {
    public void gameOfLife(int[][] board) {
        if(board.length==0)
            return;
        int mark[][] = new int[board.length][board[0].length];
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[i].length;++j){
                mark[i][j] = getActiveNum(board,i,j);
            }
        }
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[i].length;++j){
                if(mark[i][j] < 2)
                    board[i][j] = 0;
                if(mark[i][j] == 3 && board[i][j] == 0)
                    board[i][j] = 1;
                if(mark[i][j] > 3)
                    board[i][j] = 0;
            }
        }

    }

    int getActiveNum(int[][]board, int i,int j){
        return getZuoShangOrShang(board,i-1,j-1) + getZuoShangOrShang(board,i-1,j)+getYouShangOrYou(board,i-1,j+1)+
                getYouShangOrYou(board,i,j+1) + getYouXiaOrXia(board,i+1,j+1) + getYouXiaOrXia(board,i+1,j)+
                getZuoXiaOrZuo(board,i+1,j-1) + getZuoXiaOrZuo(board,i,j-1);
    }

    int getZuoShangOrShang(int[][] board, int i, int j){
        if(i<0||j<0)
            return 0;
        else return board[i][j];
    }

    int getYouShangOrYou(int[][] board, int i, int j){
        if(i<0||j>=board[i].length)
            return 0;
        else return board[i][j];
    }

    int getYouXiaOrXia(int[][] board, int i,int j){
        if(i>=board.length||j>=board[i].length)
            return 0;
        else return board[i][j];
    }

    int getZuoXiaOrZuo(int[][] board, int i ,int j){
        if(i>=board.length||j<0)
            return 0;
        else return board[i][j];
    }
}
