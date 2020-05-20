class Solution {
    public void sortColors(int[] nums) {
        //Quicksort - Time complexity: O(nlogn), Space complexity: O(1)
        
        //Corner case
        if(nums == null || nums.length == 0) return;
        
        Quicksort(nums, 0, nums.length - 1);
    }
    private void Quicksort(int[] nums, int left, int right) {
        if(left < right) {
            int tmp = nums[left], i = left, j = right;
            while(i < j) {
                while(i < j && nums[j] > tmp) j--;
                nums[i] = nums[j];
                while(i < j && nums[i] <= tmp) i++;
                nums[j] = nums[i];
            }
            nums[i] = tmp;
            Quicksort(nums, left, i - 1);
            Quicksort(nums, i + 1, right);
        }
    }
}