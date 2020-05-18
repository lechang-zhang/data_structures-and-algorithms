                   //                           []
                   //            [1]         [2]        [3]        [4]
                   //    [1,2][1,3][1,4]  [2,3][2,4]   [3,4]
                   // [1,2,3][1,2,4][1,3,4] [2,3,4]
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        //dfs+backtracking O(C(n, k))
        List<List<Integer>> list = new ArrayList<>();
        dfs(n, k, list, new ArrayList<>(), 1);
        return list;
    }
    private void dfs(int n, int k, List<List<Integer>> list, List<Integer> tmpList, int start) {
        if(tmpList.size() == k) {
            list.add(new ArrayList<>(tmpList));
            return;
        }
        for(int i = start; i <= n; i++) {
            tmpList.add(i);
            dfs(n, k, list, tmpList, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}