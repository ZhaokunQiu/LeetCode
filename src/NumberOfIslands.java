import java.util.LinkedList;

public class NumberOfIslands {
    boolean mark[][];

    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return  0;
        mark = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;++i)
            for(int j=0;j<grid[i].length;++j)
                mark[i][j] = false;
            int result = 0;
         for(int i =0;i<grid.length;++i){
             for(int j=0;j<grid[i].length;++j){
                 if(!mark[i][j] && grid[i][j] == '1'){
                     oneSucc(grid,i,j);
                     ++result;
                 }

             }
         }
         return result;

    }

    void oneSucc(char [][] grid, int i,int j){
        if(i<0||i>=grid.length||j<0||j>grid[i].length||mark[i][j])
            return;
        else{
            if(grid[i][j] == '0') {
                mark[i][j] = true;
                return;
            }
            else{
                mark[i][j] = true;
                oneSucc(grid,i-1,j);
                oneSucc(grid,i+1,j);
                oneSucc(grid,i,j-1);
                oneSucc(grid,i,j+1);
            }
        }
    }
}
