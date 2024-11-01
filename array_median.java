class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;

        if (totalLength % 2 != 0) {
            return findKthElement(nums1, nums2, totalLength / 2 + 1);
        } else {
            return (findKthElement(nums1, nums2, totalLength / 2) +
                    findKthElement(nums1, nums2, totalLength / 2 + 1)) / 2.0;
        }
    }

    private int findKthElement(int[] nums1, int[] nums2, int k) {
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == nums1.length) {
                return nums2[index2 + k - 1];
            }
            if (index2 == nums2.length) {
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int midIndex1 = Math.min(index1 + k / 2 - 1, nums1.length - 1);
            int midIndex2 = Math.min(index2 + k / 2 - 1, nums2.length - 1);

            if (nums1[midIndex1] <= nums2[midIndex2]) {
                k -= midIndex1 - index1 + 1;
                index1 = midIndex1 + 1;
            } else {
                k -= midIndex2 - index2 + 1;
                index2 = midIndex2 + 1;
            }
        }
    }
}

public class ArrayMedian {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };

        double median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + median);
    }
}
