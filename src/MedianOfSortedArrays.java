public class MedianOfSortedArrays {
    public static void main(String[] args) {
        MedianOfSortedArrays m = new MedianOfSortedArrays();
        System.out.println(m.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }


    double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m)   //保证数组1一定最短
            return findMedianSortedArrays(nums2, nums1);
        int L1=0, L2=0, R1=0, R2=0, c1, c2, lo = 0, hi = 2 * n;  //我们目前是虚拟加了'#'所以数组1是2*n长度
        while (lo <= hi)   //二分
        {
            c1 = (lo + hi) / 2;  //c1是二分的结果
            c2 = m + n - c1;
            L1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];   //map to original element
            R1 = (c1 == 2 * n) ? Integer.MAX_VALUE : nums1[c1 / 2];
            L2 = (c2 != 0) ? nums2[(c2 - 1) / 2] : Integer.MIN_VALUE;
            R2 = (c2 == 2 * m) ? Integer.MAX_VALUE : nums2[c2 / 2];
            if (L1 > R2)
                hi = c1 - 1;
            else if (L2 > R1)
                lo = c1 + 1;
            else
                break;
        }
        return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
    }
}
