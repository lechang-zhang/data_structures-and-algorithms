class Solution {
    public int lengthOfLongestSubstring(String s) {
        //hashmap + two pointer Time complexity: O(n) Space complexity: O(n)
        
        //Corner case
        if(s == null || s.length() == 0) return 0;
        
        int len = s.length(), maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0, j = 0; i < len; i++) {
            if(map.containsKey(s.charAt(i))) j = Math.max(j, map.get(s.charAt(i)) + 1);
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }
}