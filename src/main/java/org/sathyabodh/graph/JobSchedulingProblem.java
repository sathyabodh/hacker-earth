package org.sathyabodh.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobSchedulingProblem {
    static class Job{
        String name;
        int deadline;
        int profit;
        Job(String name, int deadline, int profit){
            this.name = name;
            this.deadline = deadline;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "name='" + name + '\'' +
                    ", deadline=" + deadline +
                    ", profit=" + profit +
                    '}';
        }
    }
    static class DisJoint{
        int[] parent ;
        DisJoint(int n){
            parent = new int[n+1];
            for(int i = 0; i < parent.length; ++i){
                parent[i] = i ;
            }
        }
        int find(int i){
            if(parent[i] == i)
                return i;
            return parent[i] = find (parent[i]);
        }

        void merge(int root1, int root2){
            parent[root2] = root1;
        }
    }

    private int scheduleJobs(List<Job> jobs){
        int maxProfit = 0;
        Collections.sort (jobs, (first, second)-> second.profit - first.profit);
        int maxDeadline = jobs.stream ().max ((first, second)-> first.deadline - second.deadline).get ().deadline;
        DisJoint disJoint = new DisJoint (maxDeadline);
        List<Job> scheduledJobs = new ArrayList<> ();
        for(Job job: jobs){
            int availableSlot = disJoint.find (job.deadline);
            if(availableSlot > 0){
                disJoint.merge (disJoint.find (availableSlot-1), availableSlot);
                maxProfit += job.profit;
                scheduledJobs.add (job);
            }
        }
        scheduledJobs.forEach (System.out::println);
        return maxProfit;
    }

    public static void main(String[] args) {
        ArrayList<Job> arr=new ArrayList<Job>();
//        arr.add(new Job("a",2,100));
//        arr.add(new Job("b",1,19));
//        arr.add(new Job("c",2,27));
//        arr.add(new Job("d",1,25));
//        arr.add(new Job("e",3,15));

        arr.add(new Job("a",4,20));
        arr.add(new Job("b",1,10));
        arr.add(new Job("c",1,40));
        arr.add(new Job("d",1,30));

        int maxProfit = new JobSchedulingProblem ().scheduleJobs(arr);
        System.out.println ("Maxprofit is : " + maxProfit);
    }
}
