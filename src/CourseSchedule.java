import java.beans.PropertyChangeEvent;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;

public class CourseSchedule extends PropertyChangeEvent {
    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source       the bean that fired the event
     * @param propertyName the programmatic name of the property that was changed
     * @param oldValue     the old value of the property
     * @param newValue     the new value of the property
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public CourseSchedule(Object source, String propertyName, Object oldValue, Object newValue) {
        super(source, propertyName, oldValue, newValue);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] inDegrees = new int[numCourses];
        for(int i = 0;i < prerequisites.length; ++i){
            int pre = prerequisites[i][0];
            int post = prerequisites[i][1];
            if(matrix[pre][post] == 0)
                ++inDegrees[post];
            matrix[pre][post] = 1;
        }
        Queue<Integer> helper = new LinkedList<>();
        for(int i = 0;i < numCourses; i++){
            if(inDegrees[i] == 0)
                helper.add(i);
        }
        int count = 0;
        while(!helper.isEmpty()){
            int cur = helper.poll();
            count++;
            for(int i = 0;i < numCourses;i++){
                if(matrix[cur][i] == 1) {
                    inDegrees[i]--;
                    if(inDegrees[i] == 0)
                        helper.add(i);
                }
            }
        }
        return count == numCourses;
    }
}
