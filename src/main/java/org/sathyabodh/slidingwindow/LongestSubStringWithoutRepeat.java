package org.sathyabodh.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeat {
    static String find(String s){

        int low = 0;
        int high = 0;
        int maxWindowSize = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowEnd = 0;
        Map<Character, Integer> counter = new HashMap<> ();
        while(high < s.length ()){
            Character ch = s.charAt (high);
            Integer count = counter.get (ch);
            if(count == null){
                counter.put (ch, high);
                high++;
            }
            else{
                low = counter.get(ch) + 1;
                high = low;
                counter = new HashMap<> ();
            }
            int size = high - low;
            if(maxWindowSize < size){
                maxWindowSize = size;
                windowStart = low;
                windowEnd = high-1;
            }

        }
        int size = high - low;
        if(maxWindowSize < size){
            maxWindowSize = size;
            windowStart = low;
            windowEnd = high-1;
        }
        return s.substring (windowStart, windowEnd+1);
    }
    public static void main(String[] args) {
        String str = find ("ABABBCA");
        System.out.println ("ABABBA substring is " + str);
    }
}
