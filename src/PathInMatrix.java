import java.util.ArrayList;
import java.util.Arrays;

public class PathInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix.length == 0 || str.length == 0 || matrix.length != rows * cols)
            return false;
        boolean[] visited = new boolean[matrix.length];
        Arrays.fill(visited, false);

        for(int i = 0; i < matrix.length; i++){
            if (matrix[i] == str[0]) {
                visited[i] = true;
                if (verify(matrix, rows, cols, str, i, 0, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    private boolean verify(char[] matrix, int rows, int cols, char[] str, int midx, int sidx, boolean[] visited) {
        if (sidx == str.length - 1)
            return true;
        if (midx + cols < matrix.length && !visited[midx + cols] && matrix[midx + cols] == str[sidx + 1]) {
            visited[midx + cols] = true;
            if (verify(matrix, rows, cols, str, midx + cols, sidx + 1, visited))
                return true;
            visited[midx + cols] = false;
        }

        if (midx - cols >= 0 && !visited[midx - cols] && matrix[midx - cols] == str[sidx + 1]) {
            visited[midx - cols] = true;
            if (verify(matrix, rows, cols, str, midx - cols, sidx + 1, visited))
                return true;
            visited[midx - cols] = false;
        }

        if (midx + 1 < matrix.length && midx + 1 % cols != 0 && !visited[midx + 1] && matrix[midx + 1] == str[sidx + 1]) {
            visited[midx + 1] = true;
            if (verify(matrix, rows, cols, str, midx + 1, sidx + 1, visited))
                return true;
            visited[midx + 1] = false;
        }

        if (midx - 1 >= 0 && midx % cols != 0 && !visited[midx - 1] && matrix[midx - 1] == str[sidx + 1]) {

            visited[midx - 1] = true;
            if (verify(matrix, rows, cols, str, midx - 1, sidx + 1, visited))
                return true;
            visited[midx - 1] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        PathInMatrix p = new PathInMatrix();
        System.out.println(p.hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8, "SGGFIECVAASABCEHJIGQEM".toCharArray()));;



    }
}
