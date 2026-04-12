class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (String s : operations) {
            if (s.equals("+")) {
                int s2 = dq.removeFirst();
                int s1 = dq.removeFirst();
                int s3 = s1 + s2;
                dq.addFirst(s1);
                dq.addFirst(s2);
                dq.addFirst(s3);
            } else if (s.equals("D")) {
                int s2 = dq.removeFirst();
                int s3 = 2 * s2;
                dq.addFirst(s2);
                dq.addFirst(s3);
            } else if (s.equals("C")) dq.removeFirst();
            else dq.addFirst(Integer.valueOf(s));
        }
        int sum = 0;
        while (!dq.isEmpty()) {
            sum += dq.removeFirst();
        }
        return sum;
    }
}