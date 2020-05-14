class Solution {
    public int largestRectangleArea(int[] heights) {
        //Brute force O(n^2)
        //For each bar, check the left and right to calculate the maximum area it can achieve. Compare their area and return the largest area.
        int length = heights.length, maxarea = 0;
        for(int i = 0; i < length; i++) {
            int max = 0;
            //check the left side of bar i
            for(int j = i; j >= 0; j--) {
                if(heights[i] <= heights[j]) max += heights[i];
                else break;
            }
            //check the right side of bar i
            for(int j = i + 1; j < length; j++) {
                if(heights[i] <= heights[j]) max += heights[i];
                else break;
            }
            //compare
            if(max > maxarea) {
                maxarea = max;
            }
        }
        return maxarea;
    }
}