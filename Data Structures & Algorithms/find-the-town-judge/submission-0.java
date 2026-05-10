class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] list = new int[n + 1];

        Arrays.fill(list, -1);

        // people who trust someone
        for (int[] i : trust) {
            list[i[0]] = 0;
        }

        for (int i = 1; i <= n; i++) {

            int[] people = new int[n + 1];

            // possible judge
            if (list[i] == -1) {

                for (int[] t : trust) {

                    // who trusts i
                    if (t[1] == i) {
                        people[t[0]] = 1;
                    }
                }
            }

            int count = 0;

            for (int j = 1; j <= n; j++) {
                count += people[j];
            }

            // everyone except judge trusts judge
            if (count == n - 1) {
                return i;
            }
        }

        return -1;
    }
}