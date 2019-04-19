public class SurroundedRegions {
    public void solve(char[][] board) {
        int length = board.length;
        int sidth = board[0].length;
        for(int i = 0;i < board.length;i++)
            if(board[i][0] == 'O')
                dfs(i,0,board);
        for(int i = 0;i < board[0].length;i++)
            if(board[0][i] == 'O')
                dfs(0,i,board);
        for(int i = board.length - 1;i > 0; i--)
            if(board[i][sidth - 1]=='O')
                dfs(i,sidth - 1,board);
        for(int i = 0;i < sidth; i++)
            if(board[length - 1][i] == 'O')
                dfs(length - 1,i,board);
        for(int i = 0;i < length; i++)
            for(int j = 0;j < sidth; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'Q')
                    board[i][j] = 'O';
            }
    }

    private void dfs(int hang,int lie, char[][] board) {
        board[hang][lie] = 'Q';
        if(hang > 0 && board[hang - 1][lie] == 'O')
            dfs(hang - 1, lie, board);
        if(hang < board.length - 1 && board[hang + 1][lie] == 'O')
            dfs(hang + 1,lie,board);
        if(lie > 0 && board[hang][lie - 1] == 'O')
            dfs(hang,lie - 1, board);
        if(lie < board[hang].length - 1 && board[hang][lie + 1] == 'O')
            dfs(hang,lie + 1,board);
    }
}
