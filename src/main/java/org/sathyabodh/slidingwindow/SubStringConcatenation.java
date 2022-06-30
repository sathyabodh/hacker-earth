package org.sathyabodh.slidingwindow;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
public class SubStringConcatenation {
    static List<Integer> findSubString(String s, String[] words){
        List<Integer> substringIndices = new ArrayList<> ();
        int low = 0;
        int high = 0;
        int wordLength = words[0].length ();
        int totalLength = wordLength * words.length;
        Map<String, Integer> temp = Arrays.stream(words).collect(Collectors.toMap (it-> it, it->1, (i,j)->i+j));
        Map<String, Integer> counter = new HashMap<> (temp);
        int unMatched = counter.size ();
        while(high <= (s.length ()-wordLength)){
            String substr = s.substring (high, high+wordLength);
            Integer count = counter.get (substr);
            if(count != null){
                count--;
                counter.put (substr, count);
                if(count == 0) unMatched --;
                high+= wordLength;
            }
            if(count == null || counter.get (substr) < 0){
                counter = new HashMap<> (temp);
                unMatched = counter.size ();
                low++;
                high = low;
            }
            if(unMatched == 0){
                substringIndices.add (low);
                low++;
                high = low;
                counter = new HashMap<> (temp);
                unMatched = counter.size ();
            }
        }
        return substringIndices;
    }
    public static void main(String[] args) {
        String[] words = {"foo", "bar"};
        List<Integer> results = findSubString ("barfoothefoobarman", words);
        System.out.println ("result: " + results.toString ());


        String words1[] = {"word","good","best","word"};
        List<Integer> results1 = findSubString ("wordgoodgoodgoodbestwordwordgoodbestword", words1);
        System.out.println ("result: " + results1.toString ());

        List<Integer> results2 = findSubString ("wordgoodgoodgoodbestword", words1);
        System.out.println ("result: " + results2.toString ());
        String words2[] = {"ab","ba","ba"};
        List<Integer> results3 = findSubString ("ababaab", words2);
        System.out.println ("result: " + results3.toString ());
    }
}
