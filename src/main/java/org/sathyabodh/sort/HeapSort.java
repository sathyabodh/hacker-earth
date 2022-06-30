package org.sathyabodh.sort;

import java.util.Arrays;

public class HeapSort {

    private  void heapSort(int[] a){
        int index = a.length - 1;
        while(index >=0){
            heapify (a,index, a.length-1);
            index--;
        }

        // delete max heap and do adjust again
        int i = a.length-1;
        while(i >=0){
            System.out.println ("max: " + a[0] + "i:" + i);
            System.out.println ("before swap array: " + Arrays.toString (a));
            swap (a, 0, i);
            System.out.println ("after array: " + Arrays.toString (a));
//            adjustHeap (a, 0, i);
            i--;
            heapify (a, 0, i);
            System.out.println ("adjust array: " + Arrays.toString (a));

        }

    }

    private void swap(int[] a, int i, int j){
     int temp = a[i];
     a[i] = a[j];
     a[j]= temp;
    }

    private void adjustHeap(int[] a, int start, int end){
        while (start < end){
            int left = 2 * start + 1;
            int right = 2 * start + 2;
            int lIndex = start;
            if(left <= end && a[lIndex] < a[left]){
                lIndex = left;
            }
            if(right <= end && a[lIndex] < a[right]){
                lIndex = right;
            }
            if(start != lIndex){
                swap (a, start, lIndex);
                start = lIndex;
            }
            else{
                break;
            }

        }
    }
    private void heapify(int[] a, int index, int end){
            //check left and right child. If they are greater than
            //parent, then exchange it with parent
            int left = 2*index + 1;
            int right = 2*index + 2;
            int lIndex = index;
            if(left <= end && a[lIndex] < a[left]){
                lIndex = left;
            }
            if(right <= end && a[lIndex] < a[right]){
                lIndex = right;
            }
            if(index != lIndex){
                swap (a, index, lIndex);
                heapify (a, lIndex, end);
            }


        System.out.println ("Max element: " + a[0]);
    }

    public static void main(String[] args) {
        int[] a = {4,10,3,5,1};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort (a);
        System.out.println ("Sorted: " + Arrays.toString (a));
    }
}
