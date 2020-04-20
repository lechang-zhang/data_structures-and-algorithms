class Solution {
    //Use Binary Search Method twice to find the start index and the end index
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = BinarySearchStart(nums, target);
        res[1] = BinarySearchEnd(nums, target);
        return res;
    }
    private int BinarySearchStart(int[] nums, int target) {
        int idx = -1, low = 0, high = nums.length - 1;
        while(high >= low) {
            int mid = low + (high - low) / 2;
            if(target <= nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            if(target == nums[mid]) {
                idx = mid;
            }
        }
        return idx;
    }
    private int BinarySearchEnd(int[] nums, int target) {
        int idx = -1, low = 0, high = nums.length - 1;
        while(high >= low) {
            int mid = low + (high - low) / 2;
            if(target >= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            if(target == nums[mid]) {
                idx = mid;
            }
        }
        return idx;
    }
}    