class Solution {
    public boolean validPalindrome(String s) {
        int count = 0, n = s.length();
        int i = 0, j = n - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i ++;
            j --;
        }
        return true;
    }
    private boolean isPalindrome(String s, int l , int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l ++;
            r --;
        }
        return true;
    }
}