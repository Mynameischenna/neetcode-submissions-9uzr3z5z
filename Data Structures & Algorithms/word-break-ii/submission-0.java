class Solution {
    List<String> res = new ArrayList<>();
    HashSet<String> dict;
    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet(wordDict);
        word(s, 0, new ArrayList<>());
        return res;
    }
    private void word(String s, int index, List<String> temp) {
        if (index == s.length()) {
            res.add(buildRes(temp));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String ss = s.substring(index, i + 1);
            if (dict.contains(ss)) {
                temp.add(ss);
                word(s, i + 1, temp);
                temp.remove(temp.size() - 1); // backtrack
            }
        }
    }
    private String buildRes(List<String> temp) {
        StringBuilder sb = new StringBuilder();
        for (String t : temp) {
            sb.append(t + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}