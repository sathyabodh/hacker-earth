package org.sathyabodh.general;

import java.util.Arrays;

public class ZigZagArray {
    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j]= temp;
    }
    private static void zigZag(int[] arr){
        boolean lessThan = true;
        for(int i = 0; i < arr.length-1; ++i){
            if(lessThan){
                if(arr[i] > arr[i+1]){
                    swap (arr, i, i+1);
                }
                lessThan = false;
            }
            else {
                if(arr[i] < arr[i+1]){
                    swap (arr, i, i+1);
                }
                lessThan = true;
            }
        }
    }
    public static void main(String[] args) {
        int [] arr = {4,3,7,8,6,2,1};
        zigZag (arr);
        System.out.println (Arrays.toString (arr));
    }
}
