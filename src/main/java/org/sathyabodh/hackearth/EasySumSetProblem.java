package org.sathyabodh.hackearth;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

    public class EasySumSetProblem {
        public static void main(String[] args) throws IOException {
            List array = new ArrayList (Arrays.asList (4,3,2,1));
            int shifts = insertionSort(array);
            System.out.println ("Shifts :" + shifts);
        }
        public static int insertionSort(List<Integer> arr) {
            // Write your code here
            int sorted = 0;
            Integer a[] = new Integer[1];
//            arr.toArray (a);
            int l = 0;
            int m = 3;
            Arrays.copyOfRange(a, l, m+1);
            int b = a.length ;
            int totalShifts = 0 ;
            for(int i = 1; i < arr.size(); ++i){
                int val = arr.get(i) ;
                int j = i-1;
                for(; j >= 0 && arr.get(j) > val; --j){
                    arr.set(j+1, arr.get(j));
                    totalShifts ++;
                }
                arr.set(j+1, val);
            }
            return totalShifts;
        }


    }
