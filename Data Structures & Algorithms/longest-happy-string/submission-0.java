class Solution {
    
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<CharFreq> maxHeap = new PriorityQueue<>((d, e) -> e.count - d.count);
        if (a > 0 ) maxHeap.add(new CharFreq(a,'a'));
        if (b > 0 ) maxHeap.add(new CharFreq(b,'b'));
        if (c > 0 ) maxHeap.add(new CharFreq(c,'c'));
        char firstLast = '.';
        char secondLast = '1';
        while (!maxHeap.isEmpty()) {
            // get the longest char
            CharFreq cf = maxHeap.poll();
            // already 3 chars not a valid state
            if (sb.length() >= 2 && cf.c == firstLast && firstLast == secondLast) {
                // use next available char
                if (maxHeap.isEmpty()) return sb.toString();
                else {
                    CharFreq next = maxHeap.poll();
                    secondLast = firstLast;
                    firstLast = next.c;
                    sb.append(firstLast);
                    next.count --;
                    // add both of the objects back to maxheap
                    if (next.count > 0) maxHeap.add(next);
                    maxHeap.add(cf);
                }
            } else {
                secondLast = firstLast;
                firstLast = cf.c;
                sb.append(firstLast);
                cf.count --;
                // add both of the objects back to maxheap
                if (cf.count > 0) maxHeap.add(cf);
            }
        }
        return sb.toString();

    }
    class CharFreq{
        private int count;
        private char c;

        CharFreq(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }
}