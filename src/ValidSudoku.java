public class ValidSudoku {
    int record[][][];
    public boolean isValidSudoku(char[][] board) {
        record = new int[3][9][9];
        boolean flag = true;
        for(int i= 0; i<board.length;++i){
            for(int j=0;j<board[i].length;++j){
                if(board[i][j] == '.')
                    continue;
                else{
                    flag = verify3X3(board,i,j)&&verifyColumn(board,i,j)&&verifyRows(board,i,j);
                    if(!flag)
                        return false;
                }
            }
        }
        return flag;
    }
    boolean verifyRows(char[][] board, int i,int j){
        int num = board[i][j] - '0';
        if(record[0][i][num]==1)
            return false;
        else {
            ++record[0][i][num];
            return true;
        }
    }

    boolean verifyColumn(char[][] board, int i,int j){
        int num = board[i][j] - '0';
        if(record[1][j][num] == 1)
            return false;
        else{
            ++record[1][j][num];
            return true;
        }
    }


    boolean verify3X3(char[][] board, int i,int j){
        int num = board[i][j]-'0';
        int index = i/3 + (i+1)*3 +j/3;
        if(record[2][index][num] == 1)
            return false;
        else{
            ++record[2][index][num];
            return true;
        }
    }
}
