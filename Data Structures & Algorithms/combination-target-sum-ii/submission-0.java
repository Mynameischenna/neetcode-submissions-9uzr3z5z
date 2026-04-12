class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] cds, int target) {
        Arrays.sort(cds);
        combination2(cds, target, 0, new ArrayList<>());
        return res;    
    }
    private void combination2(int[] cds, int target, int index, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (index == cds.length || target < 0) return;
        // take it
        list.add(cds[index]);
        combination2(cds, target - cds[index], index + 1, list);

        // leave it
        list.remove(list.size() - 1);
        while (index + 1 < cds.length && cds[index] == cds[index + 1]) {
            index ++;
        }
        combination2(cds, target, index + 1, list);

    }
}
