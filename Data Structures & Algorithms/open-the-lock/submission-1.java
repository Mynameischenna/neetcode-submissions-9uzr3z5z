class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visit = new HashSet(Arrays.asList(deadends));
        
        if (visit.contains("0000")) return -1;
        visit.add("0000");

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        int turns = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0;i < size ; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) return turns;
                visit.add(curr);

                for (String lock : children(curr)) {
                    if (!visit.contains(lock)) {
                        queue.add(lock);
                        visit.add(lock);
                    }
                }
            }
            turns ++;
        }
        return -1;
    }
    private List<String> children(String curr) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            char[] c = curr.toCharArray();
            c[i] = (char) (((c[i] - '0' + 1) % 10 ) + '0');
            list.add(new String(c));

            c = curr.toCharArray();
            c[i] = (char) (((c[i] - '0' - 1 + 10) % 10) + '0');
            list.add(new String(c));
        }
        return list;
    }
    
}