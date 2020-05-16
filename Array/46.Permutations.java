class Solution {
    //dfs - O(n!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), nums);
        return list;
    }
    private void dfs(List<List<Integer>> list, List<Integer> l, int[] nums) {
        if(l.size() == nums.length) { //Exit
            list.add(new ArrayList<>(l));
            return;
        } else { //Recursion & Backtracking
            for(int i = 0; i < nums.length; i++) {
                if(l.contains(nums[i])) continue;
                l.add(nums[i]);
                dfs(list, l, nums);
                l.remove(l.size() - 1);
            }
        }
    }
}