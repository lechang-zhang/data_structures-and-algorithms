class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //Do binary search with range instead of index
        int low = matrix[0][0], high = matrix[matrix.length - 1][matrix[0].length - 1];
        while(high > low) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int i = 0, j = matrix[0].length - 1; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if(k > count) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}