package org.sathyabodh.hackearth;

import java.util.Arrays;

public class CountingSort {

    private static int[] countSort(int[] arr){
        int [] output = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length; ++i){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int [] count = new int[max + 1];
        for(int i = 0 ; i < count.length; ++i){
            count[i] = 0;
        }

        for(int i = 0 ; i < arr.length; ++i){
            count[arr[i]] ++;
        }
        // convert the number into output index
        for(int i = 1; i < count.length; ++i){
            count[i] += count[i-1];
        }

        // copy to output
        for(int i = 0; i < arr.length; ++i){
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]] -= 1;
        }
        return output;
    }

    public static void main(String[] args) {
        int [] arr = {2,3,4,2,3,6,8,4,5};
       int [] output = countSort(arr);
       System.out.println (Arrays.toString (output));
    }
}
