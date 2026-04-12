class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, maxfr = 0;
        while (r < s.length()) {
            map.put(s.charAt(r), 
                map.getOrDefault(s.charAt(r), 0) + 1);
            maxfr = Math.max(maxfr, map.get(s.charAt(r)));
            while ((r - l + 1) - maxfr > k) {
                map.put(s.charAt(l), 
                    map.get(s.charAt(l)) - 1);
                l ++;
            }
            res = Math.max(res, r - l + 1);
            r ++;
        }
        return res;
    }
}
