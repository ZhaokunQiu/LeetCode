public class RotateMatrix {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0)
            return;
        else{
            for(int i = 0; i < matrix.length/2; ++i){
                for(int j = i; j < matrix.length - i - 1; ++j){
                    rotateOne(matrix,i,j);
                }
            }
        }
    }
    public void rotateOne(int[][] matrix, int layer, int num){
        int size = matrix.length - layer - 1;
        num -= layer;
        int temp = matrix[layer+num][size];
        matrix[layer+num][size] = matrix[layer][layer+num];
        matrix[layer][layer+num] = matrix[size - num][layer];
        matrix[size - num][layer] = matrix[size][size - num];
        matrix[size][size - num] = temp;
    }
}
