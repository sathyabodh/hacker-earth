package org.sathyabodh.slidingwindow;

//https://www.lintcode.com/problem/longest-substring-with-at-most-two-distinct-characters/description

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWith2DistinctCharacter {
    static String solve(String s){
        int low = 0;
        int high = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> count = new HashMap<> ();
        while(high < s.length ()){
            Integer counter = count.get (s.charAt (high));
            if(counter == null){
                count.put(s.charAt (high), 1);
            }
            else{
                count.put (s.charAt (high), counter +1);
            }

            while(count.size () > 2){
                counter = count.get(s.charAt (low));
                if(counter == 1){
                    count.remove (s.charAt (low));
                }
                else{
                    count.put (s.charAt (low), counter-1);
                }
                low++;
            }
            int size = high-low+1;
            if(maxLength < size){
                windowStart = low;
                windowEnd = high;
                maxLength = size;
            }
            high++;
        }
        return s.substring (windowStart, windowEnd+1);
    }
    public static void main(String[] args) {
        String str = solve ("eceba");
        System.out.println ("eceba is :"+ str);

        str = solve ("aaa");
        System.out.println ("aaa is :"+ str);
    }
}
