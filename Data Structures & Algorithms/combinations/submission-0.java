class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        combination(n, k, 1, new ArrayList<>());
        return res;
    }
    private void combination(int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (start > n) return;

        // take it
        list.add(start);
        combination(n, k, start + 1, list);

        list.remove(list.size() - 1);
        combination(n, k, start + 1, list);  
    }
}