class Solution {

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<CharFreq> maxHeap =
                new PriorityQueue<>((d, e) -> e.count - d.count);

        if (a > 0) maxHeap.add(new CharFreq(a, 'a'));
        if (b > 0) maxHeap.add(new CharFreq(b, 'b'));
        if (c > 0) maxHeap.add(new CharFreq(c, 'c'));

        char firstLast = '#';
        char secondLast = '#';

        while (!maxHeap.isEmpty()) {
            CharFreq cf = maxHeap.poll();

            // If adding this creates 3 same chars
            if (sb.length() >= 2 && cf.c == firstLast && firstLast == secondLast) {

                if (maxHeap.isEmpty()) return sb.toString();

                CharFreq next = maxHeap.poll();

                sb.append(next.c);
                secondLast = firstLast;
                firstLast = next.c;

                next.count--;

                if (next.count > 0) maxHeap.add(next);
                maxHeap.add(cf);

            } else {
                sb.append(cf.c);
                secondLast = firstLast;
                firstLast = cf.c;

                cf.count--;

                if (cf.count > 0) maxHeap.add(cf);
            }
        }

        return sb.toString();
    }

    class CharFreq {
        int count;
        char c;

        CharFreq(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }
}