package org.sathyabodh.monotonicstack;

import javax.sound.midi.SysexMessage;
import java.util.Arrays;
import java.util.Stack;

/*
    Monotonic Stack: https://labuladong.gitbook.io/algo-en/ii.-data-structure/monotonicstack
 */
//https://leetcode.com/problems/next-greater-element-ii/
public class CircularArrayNextGreaterElement {
    static int[] nextGreaterElements(int[] nums){
        int[] sol = new int[nums.length];
        Stack<Integer> stack = new Stack<> ();
        for(int i = (nums.length-1)*2; i >=0 ; --i){
            while(!stack.isEmpty () && stack.peek () <= nums[i%nums.length]){
                stack.pop ();
            }
            int element = stack.isEmpty ()?-1:stack.peek ();
            sol[i%nums.length] = element;
            stack.push (nums[i%nums.length]);
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] sol = nextGreaterElements(nums);

        System.out.println ("Solution: " + Arrays.toString (sol));

        int[] nums1 = {1,2,1};
        int[] sol1 = nextGreaterElements(nums1);

        System.out.println ("Solution: " + Arrays.toString (sol1));
    }
}
