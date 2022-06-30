package org.sathyabodh.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/permutation-in-string/description/
public class PermutationString {
    static boolean solve(String s1, String s2){
        Map<Character, Integer> counter = new HashMap<> ();
        for(int i = 0; i < s1.length (); ++i){
            Character ch = s1.charAt (i);
            if(counter.get (ch) == null){
                counter.put (ch, 1);
            }
            else{
                Integer count = counter.get (ch);
                counter.put (ch, count + 1);
            }
        }

        int low = 0;
        int high = 0;
        Map<Character, Integer> temp = new HashMap<> ();
        int noOfCharacters = 0;
        boolean isFound = false;
        while (high < s2.length ()){
            Character ch = s2.charAt (high);
            Integer count = temp.get (ch);
            if(counter.get (ch) != null){
                if(count == null){
                    temp.put (s2.charAt (high), 1);
                }
                else if(count != null){
                    temp.put (s2.charAt (high), count+1);
                }
                if(temp.get (ch) == counter.get (ch))
                    noOfCharacters++;
                else if(temp.get(ch) > counter.get(ch) ){
                    while(low < high && temp.get(ch) > counter.get (ch)){
                        Integer tempCount = temp.get (s2.charAt (low));
                        if(tempCount  == counter.get(s2.charAt (low)))
                            noOfCharacters--;
                        tempCount --;
                        temp.put (s2.charAt (low), tempCount);

                        low ++;
                    }
                }
            }
            else{
                low = high + 1;
                temp = new HashMap<> ();
                noOfCharacters = 0;
            }
            if(noOfCharacters == counter.size ()){
                isFound=true;
                break;
            }
            high ++;
        }

        return isFound;
    }
    static  boolean isPresent(String s1, String s2){
        if(s1.length () > s2.length ())
            return false;

        Map<Character, Integer> counter = new HashMap<> ();
        for(int i = 0; i < s1.length (); ++i){
            Integer count = counter.get(s1.charAt (i));
            if(count == null)
                counter.put (s1.charAt (i), 1);
            else
                counter.put (s1.charAt (i), count +1);
        }
        int low = 0;
        int high = 0;
        int matched = counter.size ();
        while (high < s2.length ()){
            Integer count = counter.get(s2.charAt (high));
            if(count != null){
                count --;
                counter.put (s2.charAt (high), count);
                if(count == 0) matched--;
            }
            while(matched == 0){
                if(high-low + 1 == s1.length ()) {
                    return true;
                }
                Character ch = s2.charAt (low);
                count = counter.get(ch);
                if(count !=null){
                    count ++;
                    if(count >0 ) matched ++;
                }
                low++;
            }
            high++;
        }
        return false;
    }
    public static void main(String[] args) {
        boolean isPresent = false;
//        isPresent = solve ("ab", "eidaabbooo");
//        System.out.println ("eidaabbooo constains ab : " + isPresent);
//
//        isPresent = solve ("ab", "eidboaoo");
//        System.out.println ("eidboaoo constains ab : " + isPresent);
//
//        isPresent = solve ("adc", "dcda");
//        System.out.println ("dcda constains adc : " + isPresent);
//        isPresent = solve ("abcdxabcde","abcdeabcdx");
//        System.out.println ("abcdeabcdx constains abcdxabcde : " + isPresent);
//
//        System.out.println ("-----------------");
//
//        isPresent = isPresent ("ab", "eidaabbooo");
//        System.out.println ("eidaabbooo constains ab : " + isPresent);
//
//        isPresent = isPresent ("ab", "eidboaoo");
//        System.out.println ("eidboaoo constains ab : " + isPresent);
//
//        isPresent = isPresent ("adc", "dcda");
//        System.out.println ("dcda constains adc : " + isPresent);
//        isPresent = isPresent ("abcdxabcde","abcdeabcdx");
//        System.out.println ("abcdeabcdx constains abcdxabcde : " + isPresent);
        isPresent = solve ("hello","ooolleoooleh");
        System.out.println ("ooolleoooleh constains hello : " + isPresent);
        isPresent = isPresent ("hello","ooolleoooleh");
        System.out.println ("ooolleoooleh constains hello : " + isPresent);
    }
}
