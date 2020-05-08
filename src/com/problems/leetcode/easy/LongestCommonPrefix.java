package com.problems.leetcode.easy;

import java.util.stream.Stream;

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
	  //"dog","racecar","car"
	  //"flower","flow","flight"
	  //"a","a","b" - ""
	  // "a" - a
	  // "c", "c" - c
	  // "abab","aba",""
    String[] words = {"flower"};
    String longestCommonPrefix = longestCommonPrefix(words);
    System.out.println(longestCommonPrefix);
  }
  public static String longestCommonPrefix(String[] words) {
	  
	  return longestCommonPrefix(0, words.length - 1, words);
  }
  public static String longestCommonPrefix(int start, int end,
		  String[] words) {
	  
	  if (end == -1) {
		  return "";
	  }
	  if (start < end) {
		  
		  int mid = (start + end) / 2;
		  String left = longestCommonPrefix(start, mid, words);
		  String right = longestCommonPrefix(mid + 1, end, words);
		  int small = Math.min(left.length(), right.length());
		  for (int i = 0; i < small; i++ ) {
			  if (left.charAt(i) != right.charAt(i)) {
				  return left.substring(0, i);
			  }
		  }
		  return left.substring(0, small);
	  }
	  return words[start];
  }
  private static String getLongestCommonPrefix(String[] listOfWords) {
	  
	  String empty = "";
	  int sizeOfArray = listOfWords.length;
	  int lengthOfSmallestWord = Stream.of(listOfWords)
			  .min((s1, s2) -> s1.length() - s2.length())
			  .orElse(empty)
			  .length();
	  String longestPrefix = empty;
	  for (int i = 0; i < lengthOfSmallestWord; i++) {
		  for (int j = 0; j < sizeOfArray - 1; j++) {
			  
			  String first = listOfWords[j];
			  String second = listOfWords[j + 1];
			  /*
			   * Below we are comparing each character of each
			   * string in the array. If first character of any
			   * string does matches with the previous then we
			   * return empty string ("") otherwise we return
			   * pre-calculated substring.
			   **/
			  if (first.charAt(i) != second.charAt(i)) {
				  if (i == 0) {
					  return empty;
				  } else {
					  return longestPrefix;
				  }
			  }
		  }
		  /* 
		   * Storing the longest prefix. This will change each
		   * time if any character of all the string matches.
		   **/
		  longestPrefix = listOfWords[0].substring(0, i + 1);
	  }
	  return longestPrefix;
  }
}
