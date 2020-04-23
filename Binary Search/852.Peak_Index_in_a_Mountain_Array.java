class Solution {
    public int peakIndexInMountainArray(int[] A) {
        //Exactly same as NO.162, just do binary search
        int left = 0, right = A.length - 1;
        while(right > left) {
            int mid = left + (right - left) / 2;
            if(A[mid] < A[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}