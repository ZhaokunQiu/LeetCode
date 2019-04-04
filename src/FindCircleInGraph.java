public class FindCircleInGraph {
    int color[][];
    boolean flag =true;

    public static void main(String[] args) {
        FindCircleInGraph f = new FindCircleInGraph();

    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] temp = new int[numCourses][numCourses];
        color = new int[numCourses][numCourses];
        for(int i =0 ; i < numCourses;i++)
            for(int j=0;j<numCourses;j++) {
                temp[i][j] = 0;
                color[i][j] = -1;
            }
        for(int[] per : prerequisites){
            temp[per[0]][per[1]] = 1;
        }
        for(int i=0;i<numCourses;i++) {
            dfs(temp, i);
        }
        return flag;
    }

    void dfs(int[][] temp,int i){
        if(!flag)
            return;
        for(int j = 0;j<temp.length;j++){
            if(temp[i][j]==1){
                if(color[i][i] == 0){
                    flag = false;
                    return;
                }
                if(color[i][j]==1)
                    continue;
                color[i][j]=0;
                dfs(temp,j);
                color[i][j]=1;
            }
        }
    }

}
