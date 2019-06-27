package com.problems.hackerrank;

import com.problems.utils.Log;

public class NewYearChaos {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,5,3,7,8,6,4};
		int[] arr2 = new int[] {2,1,5,3,4};
		minimumBribes(arr);
		minimumBribes(arr2);
		Log.logInfo("First text I have entered.");
		Log.logInfo("Second text I have entered.");
	}
	static void minimumBribes(int[] q) {
	    int bribe = 0;
	    boolean chaotic = false;
	    int n = q.length;
	    for(int i = 0; i < n; i++) {
	        if(q[i]-(i+1) > 2) {               
	            chaotic = true;
	            break;     
	        }
	        for (int j = Math.max(0, q[i]-2); j < i; j++) {
	        	if (q[j] > q[i]) {
	        		bribe++;
	        	}
	        }
	    }
	    if(chaotic) {
	    	Log.logInfo("Too chaotic");
	    } else {
	        Log.logInfo("Bribe: {0}", bribe);
	    }
	}
}
