class Solution {
    Map<Character, List<Character>> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));
        if (digits.length() == 0) return res;
        combination(digits, 0, new char[digits.length()]);
        return res;
    }
    private void combination(String digits, int index, char[] c) {
        if (index == digits.length()) {
            res.add(new String(c));
            return;
        }

        List<Character> cs = map.get(digits.charAt(index));

        for (char cr : cs) {
            c[index] = cr;
            combination(digits, index + 1, c);
        }
    }
}
