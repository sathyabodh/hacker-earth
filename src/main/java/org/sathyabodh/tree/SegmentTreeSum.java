package org.sathyabodh.tree;

public class SegmentTreeSum {

    private int[] segmentTree;

    private int rangeSum(int left, int right){
        left += segmentTree.length/2;
        right += segmentTree.length / 2;
        int sum = 0;
        while (left <= right){
            if(left == right){
                sum+= segmentTree[left];
                return sum;
            }
            if((left & 1) == 1){
                sum+= segmentTree[left];
                left++;
            }
            if((right & 1) == 0){
                sum+= segmentTree[right];
                right --;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    private void constructSegmentTree(int[] a){
        int n = a.length;
        segmentTree = new int[2*n];

        System.arraycopy (a, 0, segmentTree, n, n);

        for(int i = n-1; i >0; i--){
            segmentTree[i] = segmentTree[2*i] + segmentTree[2*i+1];
        }
    }

    public static void main(String[] args) {
        int [] a = {1,3,2,7,9,11};
        SegmentTreeSum segmentTreeSum = new SegmentTreeSum ();
        segmentTreeSum.constructSegmentTree (a);
        int result = segmentTreeSum.rangeSum (1,5);
        System.out.println ("1:3->" + result);
    }
}
