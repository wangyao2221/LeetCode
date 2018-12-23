package MedianSortedArrays;

public class Solution {
    
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        if (total % 2 == 0){
            return (findK(nums1,nums2,total / 2) + findK(nums1,nums2,total / 2 + 1)) / 2.0;
        }else {
            return findK(nums1,nums2,total / 2 + 1);
        }
    }

    public double findK(int[] nums1,int[] nums2,int k){
        int len1 = nums1.length;
        int len2 = nums2.length;

        int p = 0,q = 0;

        for (int i = 0; i < k - 1; i++) {
            if (p >= len1 && q < len2){
                q++;
            }else if (p < len1 && q >= len2){
                p++;
            }else if (nums1[p] > nums2[q]){
                q++;
            }else{
                p++;
            }
        }

        if (p >= len1) return nums2[q];
        else if (q >= len2) return nums1[p];
        else return Math.min(nums1[p],nums2[q]);
    }
}