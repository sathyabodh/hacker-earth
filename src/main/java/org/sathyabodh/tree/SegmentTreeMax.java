package org.sathyabodh.tree;

public class SegmentTreeMax {

    private int minItemRange(int low, int high) {
        return searchRange(low, high, segmentTree.length/2, segmentTree);
    }

    private int searchRange(int low, int high, int n, int[] segmentTree){
        int min = Integer.MIN_VALUE;
        low += n;
        high += n;
        while(low <= high){
//            System.out.println ("L:" + low + "H:" + high);
            if((low & 1) == 1)
            {
                min = Math.max (min, segmentTree[low]);
                low++;
            }
            if((high & 1) == 1)
            {
//                high--;
                min = Math.max(min, segmentTree[high]);
            }
            if((high & 1) == 0)
            {
                min = Math.max (min, segmentTree[high]);
                high--;
            }
            low /= 2;
            high /= 2;
        }
        return min;
    }
    private int[] segmentTree ;

    private int[] constructSegmentTree(int[] a){
        segmentTree = new int[2*a.length];

        System.arraycopy (a, 0, segmentTree, a.length, a.length);

        for(int i = a.length-1; i >0; --i ){
            segmentTree[i] = Math.max(segmentTree[2*i], segmentTree[2*i + 1]);
        }

        return segmentTree;
    }

    private void updateTree(int i, int value){
        int newIndex = i + segmentTree.length /2;
        segmentTree[newIndex] = value;
        while (newIndex > 1){
            newIndex /=2;
            int max = Math.max (segmentTree[2*newIndex], segmentTree[2*newIndex + 1]);
            if(segmentTree[newIndex] != max){
                segmentTree[newIndex] = max;
            }
            else{
                return;
            }

        }
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,7,9,11};
//        int[] a = {6,10,5,2,7,1,0};
        SegmentTreeMax tree = new SegmentTreeMax ();
        tree.constructSegmentTree (a);

        int result = tree.minItemRange (1,4);
        System.out.println ("1:4->" + result);
        result = tree.minItemRange (0,4);
        System.out.println ("0:4->" + result);
        result = tree.minItemRange (0,5);
        System.out.println ("0:5->" + result);
        result = tree.minItemRange (2,5);
        System.out.println ("2:5->" + result);
        result = tree.minItemRange (0,2);
        System.out.println ("0:2->" + result);
        result = tree.minItemRange (0,3);
        System.out.println ("0:3->" + result);
        tree.updateTree (2, 10);
        int result1 = tree.minItemRange (1,4);
        System.out.println ("1:4->" + result1);




    }
}
