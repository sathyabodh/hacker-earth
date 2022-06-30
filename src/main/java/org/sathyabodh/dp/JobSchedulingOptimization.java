package org.sathyabodh.dp;

import java.util.Arrays;

public class JobSchedulingOptimization {
    static class Job implements  Comparable<Job>{
        int start;
        int end;
        int profit;
        Job(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        @Override
        public int compareTo(Job o) {
            return this.start - o.start;
        }

        public boolean doesOverlap(Job job){
            return (this.start < job.start && this.end > job.start);
        }

        @Override
        public String toString() {
            return "Job{" +
                    "start=" + start +
                    ", end=" + end +
                    ", profit=" + profit +
                    '}';
        }
    }

    private static int maximumProfile(Job[] jobs){
        Arrays.sort (jobs);
        int maxProfit = Integer.MIN_VALUE;
        int maxIndex = -1;
        int maxProfits[] = new int[jobs.length];
        int [] path = new int[jobs.length];
        for(int i = 0; i < jobs.length; ++i) {
            maxProfits[i] = jobs[i].profit;
            path[i] = i;
        }
        for(int i = 1; i < jobs.length; ++i){
            for(int j = 0; j < i; ++j ){
                if(!jobs[j].doesOverlap (jobs[i])){
                    int newProfit = maxProfits[j] + jobs[i].profit;
                    if(newProfit > maxProfits[i]){

                        maxProfits[i] = newProfit;
                        path[i] = j;
                    }
                }
                if(maxProfits[i] > maxProfit){
                    maxProfit = maxProfits[i];
                    maxIndex = i;
                }
            }

        }
        System.out.println (Arrays.toString (maxProfits));
        int i = maxIndex;
        while(i >= 0 && path[i] != i){
            System.out.println (jobs[i]);
            i = path[i];
        }
        if(path[i] == i){
            System.out.println (jobs[i]);

        }
        return maxProfit;
    }
    public static void main(String[] args) {
        Job[] jobs = {new Job(1,3,5), new Job (2,5,6), new Job (4,6,5)
        ,new Job (6,7,4), new Job (5,8,11), new Job (7,9,2)};

        int maxProfit = maximumProfile (jobs);
        System.out.println ("Max Profit : " + maxProfit);
    }
}
