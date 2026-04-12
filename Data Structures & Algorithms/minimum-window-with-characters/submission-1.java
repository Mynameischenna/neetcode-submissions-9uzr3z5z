class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int[] window = new int[128];
        int[] target = new int[128];

        for (char c : t.toCharArray()) {
            target[c]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            window[s.charAt(right)]++;

            while (isMatch(window, target)) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                window[s.charAt(left)]--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    private boolean isMatch(int[] window, int[] target) {

        for (int i = 0; i < 128; i++) {
            if (window[i] < target[i]) return false;
        }

        return true;
    }
}