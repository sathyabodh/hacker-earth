package org.sathyabodh.sort;

import java.util.Arrays;

public class BubbleSort {
    private void sort(int[] a){
        boolean isExchanged = true;
        for(int i =0 ;i < a.length-1 && isExchanged; ++i){
            isExchanged = false;
            for(int j = 0; j < a.length-1-i; ++j){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    isExchanged = true;
                }
            }

        }
    }

    public static void main(String[] args) {
        int a[]={4,10,3,5,1};
        System.out.println ("Before sort:" + Arrays.toString (a));
        new BubbleSort ().sort (a);
        System.out.println ("After sort:" + Arrays.toString (a));
    }
}
