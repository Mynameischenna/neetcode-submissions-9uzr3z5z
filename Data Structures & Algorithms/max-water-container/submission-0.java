class Solution {
    public int maxArea(int[] heights) {
        int area = 0, n = heights.length;
        int i = 0, j = n - 1;

        while (i < j) {
            int length = j - i;
            int height = Math.min(heights[i], heights[j]);
            int tempArea = length * height;
            area = Math.max(area, tempArea);

            if (heights[i] < heights[j]) i ++;
            else j --;
        }
        return area;
    }
}
