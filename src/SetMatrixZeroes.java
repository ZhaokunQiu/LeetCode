public class SetMatrixZeroes {
    int zero = 45689721;
    final static String temp = "aaa";

    public static void main(String[] args) {


    }

    public void setZeroes(int[][] matrix) {
        findZero(matrix);
        for(int i = 0;i < matrix.length; i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == 0)
                    matrix[i][j] = zero;
            }
        }
        for(int i = 0;i < matrix.length; i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == zero)
                    mark(matrix,i,j);
            }
        }
        for(int i = 0;i < matrix.length; i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j] == zero)
                    matrix[i][j] = 0;
            }
        }
    }

    public void findZero(int matrix[][]){
        boolean flag = false;
        do{
            zero++;
            flag = false;
            for(int i = 0;i < matrix.length ;i++){
                for(int j = 0;j < matrix[i].length;j++){
                    if(matrix[i][j] == zero)
                        flag = true;
                }
            }
        }while(flag);
    }

    public void mark(int matrix[][], int i, int j){
        for(int t = 0;t<matrix[i].length;t++)
            if(matrix[i][t] != zero)
                matrix[i][t] = 0;
        for(int t = 0;t < matrix.length; t++)
            if(matrix[t][j] != zero)
                matrix[t][j] = 0;
    }


    // 优秀解法：利用第一行和第一列记录该行和该列是否有0
    public void setZeroes2(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}
