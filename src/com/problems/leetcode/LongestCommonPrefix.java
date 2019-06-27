package com.problems.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.problems.utils.Log;

/**
 * <p>
 * Write a function to find the longest common prefix string
 * amongst an array of strings. If there is no common prefix,
 * return an empty string "".</p>
 * <br>Example 1:
 * <br>Input: ["flower", "flow", "flight"]
 * <br>Output: "fl"
 * <br>Example 2:
 * <br>Input: ["dog", "racecar", "car"]
 * <br>Output: ""
 * <br>Explanation: There is no common prefix among the input strings.
 * @author apal
 *
 */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] words = {"flower", "flow", "flight"};
    List<String> listOfWords = Arrays.asList(words);
    Collections.sort(listOfWords, (word1, word2) -> {
      
      int word1Length = 0;
      int word2Length = 0;
      if (Objects.nonNull(word1)) {
        word1Length = word1.length();
      }
      if (Objects.nonNull(word2)) {
        word2Length = word2.length();
      }
      if (word1Length > word2Length) {
        return 1;
      } else if (word1Length < word2Length) {
        return -1;
      }
      return 1;
    });
    Log.logInfo(listOfWords);
    
    for (int i =0; i < listOfWords.get(0).length(); i++) {
      
    }
  }
}
