class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        // first window
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        if (isMatch(arr1, arr2)) return true;

        int left = 0;

        for (int right = s1.length(); right < s2.length(); right++) {

            arr2[s2.charAt(right) - 'a']++;   // add new char
            arr2[s2.charAt(left) - 'a']--;    // remove old char
            left++;

            if (isMatch(arr1, arr2)) return true;
        }

        return false;
    }

    private boolean isMatch(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}