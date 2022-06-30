package org.sathyabodh.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaximumSumOfNonAdjSubSequence {

    private static int maxSum(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int[] exclusiveSum = new int[arr.length];
        int[] inclusiveSum = new int[arr.length];
        Arrays.fill (exclusiveSum, 0);
        Arrays.fill (inclusiveSum, 0);
        exclusiveSum[0] = 0;
        inclusiveSum[0] = arr[0];
        for(int i = 1; i < arr.length; ++i){
            exclusiveSum[i] = Math.max(inclusiveSum[i-1], exclusiveSum[i-1]);
            inclusiveSum[i] = exclusiveSum[i-1] + arr[i];
        }
        System.out.println ("Exclusive:" + Arrays.toString (exclusiveSum));
        System.out.println ("Inclusive:" + Arrays.toString (inclusiveSum));
        int sum = Math.max(inclusiveSum[arr.length-1], exclusiveSum[arr.length-1]);
        int[] path = new int[arr.length];
        Arrays.fill (path, 0);
        for(int i = arr.length-1; i >=0; --i){
            if(sum == exclusiveSum[i]){

            }
            else if(sum == inclusiveSum[i]){
                path[i] = arr[i];
                sum -= arr[i];
            }
        }
        System.out.println ("Path:" + Arrays.toString (path));
        return Math.max (inclusiveSum[arr.length-1], exclusiveSum[arr.length-1]);
    }
    public static void main(String[] args) {
        int[] arr = {4,1,1,4,2,3,1};
        int maxSum = maxSum (arr);
        System.out.println ("Maximum sum:" + maxSum);
    }
}
