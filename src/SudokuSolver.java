import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] grids = new HashSet[9];
        for(int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            grids[i] = new HashSet<>();
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    continue;
                else{
                    rows[i].add(board[i][j]);
                    cols[j].add(board[i][j]);
                    grids[i / 3 * 3 + j / 3].add(board[i][j]);
                }
            }
        }
        solve(board, 0, 0, rows, cols, grids);
        for(char[] temp : board) {
            for (char ch : temp)
                System.out.print(ch);
            System.out.println();
        }
    }

    private boolean solve(char[][] board, int i, int j, HashSet<Character>[] rows, HashSet<Character>[] cols, HashSet<Character>[] grids) {
        if(i == 8 && j > 8)
            return true;
        if(j > 8){
            i++;
            j = 0;
        }
        boolean flag = false;
        if(board[i][j] != '.'){
            flag = solve(board, i, j + 1, rows, cols, grids);
        }
        else{
            for(char t = '1'; t < '1' + 9; t++){
                if(rows[i].contains(t) || cols[j].contains(t) || grids[i / 3 * 3 + j /3].contains(t))
                    continue;
                else{
                    rows[i].add(t);
                    cols[j].add(t);
                    grids[i / 3 * 3 + j /3].add(t);
                    board[i][j] = t;
                    flag = flag || solve(board, i, j + 1, rows, cols, grids);
                    if(flag)
                        return true;
                    rows[i].remove(t);
                    cols[j].remove(t);
                    grids[i / 3 * 3 + j /3].remove(t);
                    board[i][j] = '.';
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        SudokuSolver s = new SudokuSolver();
        s.solveSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}});

    }
}
