package com.problems.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    /* Need to fix this code.*/
    String[] words = {"flower", "dog", "do", "does"};
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
      return 0;
    });
    Log.logInfo(listOfWords);
    Map<String, Integer> map = getCommonPrefixMap(listOfWords);
    String highestKey = null;
    Integer highestValue = 0;
    for (Map.Entry<String, Integer> entrySet: map.entrySet()) {
      
      Integer value = entrySet.getValue();
      if (highestValue < value) {
        highestValue = value;
        highestKey = entrySet.getKey();
      }
    }
    Log.logInfo(map);
    Log.logInfo("Highest Key {0}\nHighest Value {1}", highestKey, highestValue);
  }

  private static Map<String, Integer> getCommonPrefixMap(List<String> listOfWords) {
    Map<String, Integer> map = new HashMap<>();
    for (int k = 0; k < listOfWords.size() - 1; k++) {
      
      String word = listOfWords.get(k);
      int length = word.length();
      for (int i = length; i > 0; i--) {
        for (int j = k +1; j < listOfWords.size(); j++) {
          
          String mainSubString = word.substring(0, i);
          if (listOfWords.get(j).startsWith(mainSubString)) {
            Integer count = map.get(mainSubString);
            if (Objects.isNull(count)) {
              count = 1;
            }
            map.put(mainSubString, ++count);
          }
        }
      }
    }
    return map;
  }
}
