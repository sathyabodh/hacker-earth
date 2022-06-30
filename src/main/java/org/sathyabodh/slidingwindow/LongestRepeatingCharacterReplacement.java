package org.sathyabodh.slidingwindow;

//https://leetcode.com/problems/longest-repeating-character-replacement/

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    static String find(String s, int k){
        int left = 0;
        int high = 0;
        int maxCharCount = Integer.MIN_VALUE;
        Character maxChar = null;
        int maxWindowLength = Integer.MIN_VALUE;
        int maxLeft = 0;
        int maxHigh = 0;
        Map<Character, Integer> count = new HashMap<> ();
        while(high < s.length ()){
            Integer counter = count.get (s.charAt (high));
            if(counter == null){
                count.put (s.charAt (high), 1);
            }
            else{
                count.put (s.charAt (high), counter + 1);
            }
            if(maxCharCount < count.get(s.charAt (high))){
                maxCharCount = count.get(s.charAt (high));
                maxChar = s.charAt (high);
            }
            while((high-left+1-maxCharCount) > k){
                counter = count.get (s.charAt (left));
                if(counter != null){
                    count.put (s.charAt (left), counter-1);
                }
//                if(maxChar == s.charAt (left)){
//                    int localMaximum = Integer.MIN_VALUE;
//                    Character localMaxChar = null;
//                    for(Map.Entry<Character, Integer> entry: count.entrySet ()){
//                        if(entry.getValue () > localMaximum){
//                            localMaxChar = entry.getKey ();
//                            localMaximum = entry.getValue ();
//                        }
//                    }
//                    maxChar = localMaxChar;
//                    maxCharCount = localMaximum;
//                }
                left++;
            }
            int length = high - left + 1;
            if(maxWindowLength <= length){
                maxWindowLength = length;
                maxLeft = left;
                maxHigh = high;
            }
            high++;
        }
        return s.substring (maxLeft, maxHigh+1);
    }

    public static void main(String[] args) {
        String windowString = find ("AABABBA", 1);
        System.out.println("AABABBA and window is :" + windowString);

        windowString = find ("ABAB", 2);
        System.out.println("ABAB and window is :" + windowString);

        windowString = find ("ABABBA", 2);
        System.out.println("ABABBA and window is :" + windowString);
    }
}
