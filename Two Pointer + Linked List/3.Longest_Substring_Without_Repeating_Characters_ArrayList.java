class Solution {
    public int lengthOfLongestSubstring(String s) {
        //ArrayList - Time complexity: O(n^2) & Space complexity: O(n)
        List<Character> substring = new ArrayList<>();
        int len = s.length(), maxLen = 0;
        for(int i = 0; i < len; i++) {
            Character ch = s.charAt(i);
            while(substring.contains(ch)) substring.remove(0);
            substring.add(ch);
            maxLen = Math.max(maxLen, substring.size());
        }
        return maxLen;
    }
}
