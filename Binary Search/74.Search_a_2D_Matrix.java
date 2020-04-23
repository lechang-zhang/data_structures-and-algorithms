class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Because this matrix is ordered from the left upper corner to the bottom right corner, we can treat this 2D array as a 1D array and do binary search.
        //Translate array[p] to array[i][j], i = mid / n,j= mid % n; Use p in binary search and use m&n to find the target number.
        //The boundary case is really important, if there is no element in the matrix, return false
        if(matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while(right >= left) {
            int mid = left + (right - left) / 2;
            int i = mid / n, j = mid % n;
            if(target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}