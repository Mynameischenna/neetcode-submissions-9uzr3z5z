class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(n, 0, 0, new StringBuilder());
        return list;
    }
    private void generate(int n, int open, int close, StringBuilder sb) {
        if (open == n && close == n) {
            list.add(new String(sb.toString()));
            return;
        }

        if (open < n) {
            sb.append("(");
            generate(n, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            generate(n, open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
