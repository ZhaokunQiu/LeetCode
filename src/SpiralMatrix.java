import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    boolean flag[][];
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0 )
            return null;
        if(matrix[0].length == 0)
            return new ArrayList<>() ;
        flag = new boolean[matrix.length][matrix[0].length];
        List<Integer> res = new ArrayList<>();
        int length = matrix.length;
        int width = matrix[0].length;
        int i1 = 0, i2 = length -1;
        int j1 = 0, j2 = width -1 ;
        while(i1 <= i2 && j1 <= j2){
            for(int i = j1;i<=j2;++i){
                if(!flag[i1][i]) {
                    res.add(matrix[i1][i]);
                    flag[i1][i] = true;
                }
            }
            i1++;
            for(int i = i1;i<=i2;++i){
                if(!flag[i][j2]) {
                    res.add(matrix[i][j2]);
                    flag[i][j2] = true;
                }
            }
            j2 --;
            for(int i = j2; i >= j1;i-- ){
                if(!flag[i2][i]){
                    res.add(matrix[i2][i]);
                    flag[i2][i] = true;
                }
            }
            i2 --;
            for(int i = i2;i>=i1;--i){
                if(!flag[i][j1]){
                    res.add(matrix[i][j1]);
                    flag[i][j1]=true;
                }
            }
            j1++;
        }
        return res;

    }
}
