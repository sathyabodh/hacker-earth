package org.sathyabodh.sort;

import java.util.Arrays;

public class SelectionSort {

    private void sort(int[] a){
        for(int i =0; i < a.length-1; ++i){
            int min=i;
            for(int j = i+1; j < a.length; ++j){
                if(a[min] > a[j]){
                    min = j;
                }
            }
            if(min !=i){
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int a[]={4,10,3,5,1};
        System.out.println ("Before sort:" + Arrays.toString (a));
        new SelectionSort ().sort (a);
        System.out.println ("After sort:" + Arrays.toString (a));
    }
}
