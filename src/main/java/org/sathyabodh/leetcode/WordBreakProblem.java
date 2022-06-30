package org.sathyabodh.leetcode;

import java.util.Arrays;
import java.util.List;

public class WordBreakProblem {
    public boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }

    public static void main(String[] args) {
        WordBreakProblem problem = new WordBreakProblem ();
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList ("apple","pen");
        problem.wordBreak (s, wordDict);
    }
}
