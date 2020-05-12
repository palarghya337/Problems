package com.problems.others;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInMatrix {

	public static void main(String[] args) {
		int[][] area = {{0, 1, 1, 0, 1},{0, 1, 0, 1, 0},
		 {0, 0, 0, 0, 1},{0, 1, 0, 0, 0}};
		System.out.println(getHoursToInfectHuman(area));
	}
	public static int getHoursToInfectHuman(int[][] area) {
		
		Queue<String> zombies = new LinkedList<>();
		int areaLength = area.length;
		for (int i = 0; i < areaLength; i++) {
			
			int colLen = area[i].length;
			for (int j = 0; j < colLen; j++) {
				if (area[i][j] == 1) {
					zombies.add(i + "," + j);
				}
			}
		}
		int zombieCount = zombies.size();
		int hour = 0;
		while (!zombies.isEmpty()) {
			
			if (zombieCount == 0) {
				zombieCount = zombies.size();
				hour++;
			}
			zombieCount--;
			String position = zombies.poll();
			if (position != null) {
				
				String[] po = position.split(",");
				int row = Integer.parseInt(po[0]);
				int column = Integer.parseInt(po[1]);
				int len = area[row].length;
				int adjRow = row + 1;
				int adjCol = column + 1;
				
				if (adjRow < areaLength
						&& area[adjRow][column] == 0) {
					area[adjRow][column] = 1;
					zombies.add((adjRow) + "," + column);
				}
				adjRow = row - 1;
				if (adjRow > -1
						&& area[adjRow][column] == 0) {
					area[adjRow][column] = 1;
					zombies.add((adjRow) + "," + column);
				}
				
				if (adjCol < len
						&& area[row][adjCol] == 0) {
					area[row][adjCol] = 1;
					zombies.add(row + "," + adjCol);
				}
				adjCol = column - 1;
				if (adjCol > -1
						&& area[row][adjCol] == 0) {
					area[row][adjCol] = 1;
					zombies.add(row + "," + (adjCol));
				}
			}
		}
		return hour;
	}
}
