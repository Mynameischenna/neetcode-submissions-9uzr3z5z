class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int boats = 0;
        int l = 0, r = n - 1;
        Arrays.sort(people);
        while (l <= r) {
            if (l == r) {
                boats ++;
                l ++;
                r --;
                continue;
            }
            if (people[l] + people[r] <= limit) {
                boats ++;
                l ++; r--;
            } else { // only one person can fit in a boat
                // which ever pointer is grater move that peroson into the boat
                if (people[l] > people[r]) {
                    l ++;
                } else r --;
                boats ++;
            }
        }
        return boats;
    }
}