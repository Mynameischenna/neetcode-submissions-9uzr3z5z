class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = -1;
        int min = 1;int max = 0;
        for (int i = 0; i < piles.length;i++) {
            if(piles[i] > max) max = piles[i];
        }
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (eatPerHour(mid, piles, h)) {
                k = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return k;

    }
    private boolean eatPerHour(int k, int[] piles, int h) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += (piles[i] + k - 1) / k;
        }
        return hours <= h;
    }
}
