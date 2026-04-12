class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = 0, maxLength = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i ++) {
            while (map.containsKey(s.charAt(i))) {
                map.remove(s.charAt(start ++));
                length --;
            }
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
                length ++;
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
