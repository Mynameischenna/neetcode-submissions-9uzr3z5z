class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> list = new ArrayList<>();
        // point - no of passangers
        for (int[] trip : trips) {
            list.add(new int[]{trip[1], trip[0]});
            list.add(new int[]{trip[2], - trip[0]});
        }

        list.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];// in order
            return a[0] - b[0];
        });
        int passangers = 0;
        for (int[] l : list) {
            passangers += l[1];
            if (passangers > capacity) return false;
        }
        return true;
    }
}