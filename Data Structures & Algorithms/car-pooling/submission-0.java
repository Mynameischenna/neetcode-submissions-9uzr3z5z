class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // sort trips based on start time
        PriorityQueue<int[]> pickUp = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // sort based on nearst drop off
        PriorityQueue<int[]> dropOff = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int[] trip : trips) {
            pickUp.add(trip);
        }
        int distance = 0;
        while (!pickUp.isEmpty()) {
            // first drop off anyone are there at this point
            while (!dropOff.isEmpty() && dropOff.peek()[2] == distance) {
                capacity += dropOff.poll()[0];
            }
            // add people
            while (!pickUp.isEmpty() && pickUp.peek()[1] == distance) {
                if (capacity - pickUp.peek()[0] < 0) return false; // no space
                capacity -= pickUp.peek()[0];
                dropOff.add(pickUp.poll());
            }
            distance ++;
        }
        return true;
    }
}