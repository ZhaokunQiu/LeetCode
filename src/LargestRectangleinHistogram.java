public class LargestRectangleinHistogram {
    private int count;
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0)
            return 0;
        short dp[][] = new short[heights.length][heights.length];
        for(int i = 0;i < heights.length;i++) {
            dp[i][i] = (short)heights[i];
            for (int j = i + 1; j < heights.length; j++) {
                dp[i][j] = dp[i][j-1] > (short)heights[j] ? (short)heights[j] : dp[i][j-1];
            }
        }
        int area = 0;
        for(int i = 0; i < heights.length;i++){
            for(int j = i; j < heights.length ; j++){
                area = area > (j - i + 1) * dp[i][j] ? area : (j - i + 1) * dp[i][j];
            }
        }
        return area;
    }
}
