package org.sathyabodh.leetcode;
//https://leetcode.com/problems/daily-temperatures/

import org.sathyabodh.util.Pair;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
/*
This makes use of Next Greater element using monotonic stack.
Main concept here is when we find element greater than the top, we pop the element
till stack top element becomes greater than current element or stack becomes empty
Below monotonic stack used is of type decreasing.. ie values decreases as we move up
from stack bottom to top.
We always traverse from back to front of the list /array when we make use of monotonic stack
 */
public class DailyTemperature {


    static int[] solve(int[] temp){
        int[] sol = new int[temp.length];
        Arrays.fill (sol, Integer.MAX_VALUE);
        sol[temp.length-1] = 0;
        Stack<Integer> stack = new Stack<> ();
        for(int i = temp.length-1; i >=0; --i){
            while(!stack.isEmpty () && temp[stack.peek ()] < temp[i]){
                stack.pop ();
            }
            int num = stack.isEmpty ()?0:stack.peek()-i;
            sol[i] = num;
            stack.push (i);
        }
        return  sol;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
//        int[] temp = {89,62,70,58,47,47,46,76,100,70};
        int[] sol = solve(temperatures);
        System.out.println ("sol:" + Arrays.toString (sol));

    }
}
