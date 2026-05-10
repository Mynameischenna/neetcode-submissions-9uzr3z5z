class Solution {
    int[] rank;
    public boolean isAlienSorted(String[] words, String order) {
        // calculate 
        rank = new int[26];
        int r = 0;
        for (char c : order.toCharArray()) {
            rank[c - 'a'] = r ++;
        }
        // compare adj word 
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];

            // compare
            if (!compare(curr, next)) return false;
        }
        return true;
    }
    private boolean compare(String a, String b) {

    int i = 0;
    int j = 0;

    while (i < a.length() && j < b.length()) {

        char ch1 = a.charAt(i);
        char ch2 = b.charAt(j);

        // same character
        if (ch1 == ch2) {
            i++;
            j++;
        }
        else {

            // compare alien rank
            if (rank[ch1 - 'a'] < rank[ch2 - 'a']) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    // prefix case
    return a.length() <= b.length();
    }
}