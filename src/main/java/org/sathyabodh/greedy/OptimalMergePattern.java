package org.sathyabodh.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
Optimal merge always involves in merging two small list. Min priority queue used to fetch two minimum list
which can create merged list. Merge list is also inserted back again to participate in further merging process
with condition being picking up next two small list sizes
 */
public class OptimalMergePattern {
    static int optimalMerge(int[] arr){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<> ();
        Arrays.stream (arr).forEach (it->priorityQueue.add(it));
        int count = 0;
        while(priorityQueue.size () > 1){
            int item1 = priorityQueue.poll ();
            int item2 = priorityQueue.poll ();
            count += (item1 + item2);
            priorityQueue.add (item1 + item2);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] a= {2,3,4};
        int[] arr = {2, 3, 4, 5, 6, 7};
        System.out.println ("optimal merge pattern: " + optimalMerge (arr));
    }
}
