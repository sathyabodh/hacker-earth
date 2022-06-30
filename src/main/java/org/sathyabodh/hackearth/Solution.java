package org.sathyabodh.hackearth;


import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here

        int notification = 0;
        Integer[] array = expenditure.toArray (new Integer[1]);
        Integer[] count = countSort (array, 0, d-1);
        for (int i = d; i < array.length; ++i) {
//            Integer[] count = countSort (array, i - d, i - 1);
            int value = findMedian (count, d);
            System.out.println ("median" + value);
            notification += array[i] >= value ? 1 : 0;
            if(i + 1 < array.length){
                adjustCountArray (count, array,i-d, i);
            }
            // insert(linkedList, expenditure.get(i), i-1, i-d+1);
            // Arrays.sort(array, i-d+1, i);

        }
        return notification;
    }

    private static void adjustCountArray(Integer[] count, Integer[] array, int prevEleIndex, int nextEleIndex){
        int prevEle = array[prevEleIndex];
        int nextEle = array[nextEleIndex];
        for(int i = prevEle; i < count.length;++i){
            count[i] -= 1;
        }
        for(int i = nextEle; i < count.length;++i){
            count[i] += 1;
        }
    }

    private static Integer[] countSort(Integer[] arr, int s, int e) {
        Integer[] count = new Integer[201];
        for (int i = 0; i < count.length; ++i) {
            count[i] = 0;
        }
        for (int i = s; i <= e; ++i) {
            count[arr[i]]++;
        }
        for (int i = 1; i <count.length; ++i) {
            count[i] += count[i-1];
        }
        return count;
    }


    private static int findMedian(Integer[] count, int length) {
        int mid = (length -1) / 2;
        int element = 0;
        if (length % 2 == 1) {
            for (int i = 0; i < count.length; ++i) {
                if (mid <= count[i]-1) {
                    element = i;
                    break;
                }
            }
            return 2 * element;
        }
        int first = -1;
        int second = -1;
        for (int i = 0; i < count.length; ++i) {
            if (mid <= count[i] - 1 && first < 0) {
                first = i;
            }
            if (mid + 1 <= count[i] - 1 && second < 0) {
                second = i;
            }
        }
        return (first + second);


    }
}

public class Solution {
    public static void main(String[] args) throws IOException {


        List<Integer> expenditure = Arrays.asList (1,2,3,4,4);
        int d = 4;
        int result = Result.activityNotifications (expenditure, d);
        System.out.println ("" + result);

    }
}
