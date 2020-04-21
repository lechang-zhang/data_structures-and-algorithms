class Solution {
    public int search(int[] nums, int target) {
        //Find the smallest number in the array by Binary Search
        int low = 0, high = nums.length - 1;
        while(low < high) {
            if(nums[low] < nums[high]) {
                break;
            }
            int mid = (low + high) / 2;
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            }
        }
        //Find the target by Binary Search(Just modulo operation to compute the realmid)
        int increm = low, n = nums.length;
        low = 0;
        high = n - 1;
        while(high >= low) {
            int mid = (low + high) / 2, realmid = (mid + increm) % n;
            if(target < nums[realmid]) {
                high = mid - 1;
            } else if (target > nums[realmid]) {
                low = mid + 1;
            } else {
                return realmid;
            }
        }
        return -1;
    }
}