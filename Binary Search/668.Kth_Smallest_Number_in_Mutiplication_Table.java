class Solution {
    public int findKthNumber(int m, int n, int k) {
        //Exactly same as NO.378, binary search with range
        //The only trick is that using i and j to represent the numbers in the table
        int low = 1, high = m * n;
        while(high > low) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int i = 1, j = n; i <= m; i++) {
                while(j > 0 && mid < i * j) {
                    j--;
                }
                count += j;
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