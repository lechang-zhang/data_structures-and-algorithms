            //                                     []
            //            [1]                                               []
            //     [1,2]       [1]                                  [2]            []
            // [1.2.3][1,2]  [1,3][1]                            [2,3][2]        [3][]            

class Solution {
    //dfs: O(2 ^ n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, list, new ArrayList<>(), 0);
        return list;
    }
    //Definition
    private void dfs(int[] nums, List<List<Integer>> list, List<Integer> tmpList, int start) {
        //body
        list.add(new ArrayList<>(tmpList));
        for(int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            dfs(nums, list, tmpList, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
        //exit
        return;
    }
}