class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //exactly same as #15 3Sum
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len - 3; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                for(int j = i + 1; j < len - 2; j++) {
                    if(j == i + 1 || nums[j] != nums[j - 1]) {
                        int low = j + 1, high = len - 1, sum = target - (nums[i] + nums[j]);
                        while(low < high) {
                            if(nums[low] + nums[high] == sum) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[low++], nums[high--]));
                                while(low < high && nums[low] == nums[low - 1]) low++;
                                while(low < high && nums[high] == nums[high + 1]) high--;
                            }
                            else if (nums[low] + nums[high] < sum) low++;
                            else high--;
                        }
                    }
                }
            }
        }
        return res;
    }
}