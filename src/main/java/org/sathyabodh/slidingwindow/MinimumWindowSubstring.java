package org.sathyabodh.slidingwindow;

//https://leetcode.com/problems/minimum-window-substring/description/

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    static String minimumWindow(String s, String t){
        if(s.length () < t.length ())
            return "";
        Map<Character, Integer> counter  = new HashMap<> ();
        for(int i = 0; i < t.length (); ++i){
            Integer count = counter.get (t.charAt (i));
            if(count == null)
                counter.put (t.charAt (i), 1);
            else
                counter.put (t.charAt (i), count +1);
        }
        int low = 0;
        int high = 0;
        int windowSize = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowEnd  = 0 ;
        Map<Character, Integer> temp = new HashMap<> ();
        int noOfCharacter = t.length ();
        while(high < s.length ()){
            Character ch = s.charAt (high);
            Integer count = counter.get (ch);
            if(count != null){
                if(count > 0 )
                    noOfCharacter --;
                count --;
                counter.put (ch, count);
            }
            while(low <= high && noOfCharacter == 0){
                if(noOfCharacter == 0) {
                    int size = high - low + 1;
                    if(windowSize > size){
                        windowSize = size;
                        windowStart = low;
                        windowEnd = high;
                    }
                }
                ch = s.charAt (low);
                count = counter.get (ch);
                if(count != null){
                    count++;
                    if(count > 0)
                        noOfCharacter ++;
                    counter.put(ch, count);
                }
                low++;

            }
            high++;
        }
        if(windowSize == Integer.MAX_VALUE)
            return "";
        return s.substring (windowStart, windowEnd+1);
    }
    public static void main(String[] args) {
        String window = "";
        window = minimumWindow ("ADOBECODEBANC", "ABC");
        System.out.println ("Window: " + window);
    }
}
