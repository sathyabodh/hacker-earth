package org.sathyabodh.sort;

import java.util.Arrays;

public class QuickSort {

    private void sort(int[] a, int low, int high){
        if (low < high){
            int j = partition (a, low, low, high);
            sort (a, low, j);
            sort (a, j+1, high);
        }
    }

    private int partition(int a[], int pivot, int low, int high){
        int i = low;
        int j = high;
        while (i < j){
            do{
                i++;
            }while (i < high && a[i] < a[pivot]) ;
            do{
                j--;
            }while(j > low && a[j] > a[pivot]) ;
            if(i < j){
                swap (a, i, j);
            }
        }
        if(j < i)
            swap (a, pivot, j);
        return j;
    }

    private void swap(int[] a, int i, int j){
        int temp =  a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {10, 5, 3, 4, 1};
        System.out.println ("Before srt: " + Arrays.toString (a));
        QuickSort quickSort = new QuickSort ();
        quickSort.sort (a, 0, a.length);
        System.out.println ("After srt: " + Arrays.toString (a));

    }
}
