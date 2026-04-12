class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        } else {
            int i = m - 1, j = n - 1;
            int index = m + n - 1;
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[index] = nums1[i];
                    i --;
                } else {
                    nums1[index] = nums2[j];
                    j --;
                }
                index --;
            } while (j >= 0) {
                nums1[index] = nums2[j];
                j --;
                index --;
            }
        }
    }
}