class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> list = new ArrayList<>();
        int index = findClosest(arr, x);

        int left = index - 1;
        int right = index;

        while (k > 0) {

            if (left < 0) {
                list.add(arr[right++]);
            } 
            else if (right >= arr.length) {
                list.add(0, arr[left--]);
            } 
            else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                list.add(0, arr[left--]);
            } 
            else {
                list.add(arr[right++]);
            }

            k--;
        }

        return list;
    }

    private int findClosest(int[] arr, int x) {

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < x) left = mid + 1;
            else right = mid - 1;
        }

        if (right < 0) return left;
        if (left >= arr.length) return right;

        return Math.abs(arr[left] - x) < Math.abs(arr[right] - x) ? left : right;
    }
}