class Solution {
    public int search(int[] nums, int target) {
        //Method2: Rotated sorted array must contain two sorted array, do binary search in the array that contains target.
        int start = 0, end = nums.length - 1;
        while(end >= start) {
            int mid = (start + end) / 2;
            if(target == nums[mid]) {
                return mid;
            }
            
            if(nums[start] <= nums[mid]) { //The boundary it's a little bit triky
                if(nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { 
                if(nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}