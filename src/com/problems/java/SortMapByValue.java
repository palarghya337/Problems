/* 
 * PORTWARE DISCLAIMER 
 * COPYRIGHT (C) 2004 PORTWARE LLC. ALL RIGHTS RESERVED. 
 * 
 * THIS SOURCE CODE AND/OR DOCUMENTATION IS THE CONFIDENTIAL AND PROPRIETARY 
 * INFORMATION OF PORTWARE,LLC. ("CONFIDENTIAL INFORMATION"). YOU SHALL  NOT 
 * DISCLOSE SUCH CONFIDENTIAL INFORMATION AND SHALL USE IT ONLY IN ACCORDANCE 
 * WITH THE TERMS OF THE LICENSE AND/OR NON-DISCLOSURE AGREEMENT YOU ENTERED 
 * INTO WITH PORTWARE. 
 * 
 * THIS PROGRAMMING CODE IS INTENDED FOR ILLUSTRATIVE PURPOSES ONLY. PORTWARE 
 * MAKES NO REPRESENTATIONS OR WARRANTIES, EITHER EXPRESS OR IMPLIED, ABOUT 
 * THE SUITABILITY OF THE CODE FOR PRODUCTION. THIS INCLUDES, BUT IS NOT 
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, NON-INFRINGEMENT 
 * AND FITNESS FOR A PARTICULAR PURPOSE. PORTWARE SHALL NOT BE LIABLE FOR ANY 
 * DAMAGES SUFFERED AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS CODE 
 * OR ITS DERIVATIVES. 
 */ 
package com.problems.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.corejava.practice.utils.Log;

public class SortMapByValue {

  public static void main(String[] args) {

    Map<Integer, String> keyValueStore = new HashMap<>();
    keyValueStore.put(1, "Poritosh");
    keyValueStore.put(3, "Sumit");
    keyValueStore.put(5, "Keya");
    keyValueStore.put(2, "Biswajit");
    keyValueStore.put(4, "Arghya");
    Log.logInfo("Before Sort: {0}", keyValueStore);

    // Adding entrySet to the list.
    List<Map.Entry<Integer, String>> values = new ArrayList<>(keyValueStore.entrySet());
    // Sorting using the entries by the values.
    Collections.sort(values, (item1, item2) -> item1.getValue().compareTo(item2.getValue()));
    Map<Integer, String> sortedByValue = new LinkedHashMap<>();
    // Putting sorted value to LinkedHashMap because it maintains insertion order.
    values.forEach(entry -> sortedByValue.put(entry.getKey(), entry.getValue()));
    Log.logInfo("After Sort: {0}", sortedByValue);

    HashMap<String, Integer> subjectAndMarks = new HashMap<>();
    subjectAndMarks.put("Math", 98);
    subjectAndMarks.put("Data Structure", 85);
    subjectAndMarks.put("Database", 91);
    subjectAndMarks.put("Java", 95);
    subjectAndMarks.put("Operating System", 79);
    subjectAndMarks.put("Networking", 80);
    Log.logInfo("Before Sort: {0}", subjectAndMarks);

    // Adding entrySet to the list.
    List<Map.Entry<String, Integer>> values1 = new ArrayList<>(subjectAndMarks.entrySet());
    // Sorting using the entries by the values.
    Collections.sort(values1, (item1, item2) -> item1.getValue().compareTo(item2.getValue()));
    Map<String, Integer> sortedByValue1 = new LinkedHashMap<>();
    // Putting sorted value to LinkedHashMap because it maintains insertion order.
    values1.forEach(entry -> sortedByValue1.put(entry.getKey(), entry.getValue()));
    Log.logInfo("After Sort: {0}", sortedByValue1);
  }
}
