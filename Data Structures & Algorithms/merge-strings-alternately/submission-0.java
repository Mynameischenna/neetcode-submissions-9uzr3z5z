class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, n = word1.length(), m = word2.length(), index = 0;
        char[] cr = new char[n + m];
        while (i < n && j < m) {
            cr[index ++] = word1.charAt(i ++);
            cr[index ++] = word2.charAt(j ++);
        }
        while (i < n) {
            cr[index ++] = word1.charAt(i ++);
        }
        while (j < m) {
            cr[index ++] = word2.charAt(j ++);
        }
        return new String(cr);
    }
}