class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        part(s, 0, new ArrayList<>());
        return res;
    }
    private void part(String s, int index, List<String> list) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i ++) {
            String subString = s.substring(index, i + 1);
            if (isPali(subString)) {
                // add it
                list.add(subString);
                part(s, i + 1, list);
                // remove it
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPali(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l ++;
            r--;
        }
        return true;
    }
}
