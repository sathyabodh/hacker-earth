package org.sathyabodh.backtracking;

import java.util.Arrays;

public class SumOfSubset {

    private boolean findSubset(int[] arr, int sum, int currSum, int remainingSum, int[] sets, int index){
        if(currSum == sum)
            return true;

        if(index >= arr.length)
            return false;

        int tempSum = currSum + arr[index];
        int tempRemainingSum = remainingSum - arr[index];
        if(tempSum + tempRemainingSum < sum)
            return false;
        boolean found = false;
        if(tempSum <= sum){
            sets[index] = 1;
            found = findSubset (arr, sum, currSum + arr[index], remainingSum-arr[index], sets, index + 1);
            if(found)
                return true;
        }

        sets[index] = 0;
        found = findSubset (arr, sum, currSum, remainingSum-arr[index], sets, index + 1);
        if(found)
            return true;
        return false;
    }
    public static void main(String[] args) {
        int[] a = {15, 22, 14, 26, 32, 9, 16, 8};
        int[] sets = new int[a.length];
        Arrays.fill (sets, -1);
        int remainingSum = Arrays.stream (a).sum ();
        int sum = 53;
        SumOfSubset sumOfSubset = new SumOfSubset ();
        boolean found = sumOfSubset.findSubset (a, sum, 0, remainingSum, sets,0);
        if(found){
            System.out.println (Arrays.toString (sets));
        }

    }
}
