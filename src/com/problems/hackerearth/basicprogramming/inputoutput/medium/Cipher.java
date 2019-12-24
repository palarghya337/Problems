package com.problems.hackerearth.basicprogramming.inputoutput.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.problems.utils.Log;

/**
 * <p>Indian army is going to do a surprise attack on one of its enemies country.
 * The President of India, the Supreme Commander of the Indian Army will be
 * sending an alert message to all its commanding centers. As enemy would be
 * monitoring the message, Indian army is going to encrypt(cipher) the message
 * using basic encryption technique. A decoding key 'K' (number) would be sent
 * secretly.</p>
 * <p>You are assigned to develop a cipher program to encrypt the message. Your
 * cipher must rotate every character in the message by a fixed number making it
 * unreadable by enemies.</p>
 * Given a single line of string 'S' containing alpha, numeric and symbols,
 * followed by a number '0<=N<=1000'. Encrypt and print the resulting string.</p>
 * <p><b>Note:</b> The cipher only encrypts Alpha and Numeric. (A-Z, a-z, and 0-9).
 * All Symbols, such as - , ; %, remain unencrypted.</p>
 * <p>
 * <b>Sample Input:</b><br>
 * All-convoYs-9-be:Alert1.<br>
 * 4<br>
 * <b>Sample Output:</b><br>
 * Epp-gsrzsCw-3-fi:Epivx5.
 * </p>
 * @author Bittu
 *
 */
public class Cipher {

	public static void main(String[] args) {
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String s = reader.readLine();
			int n = Integer.parseInt(reader.readLine());
			Log.logInfo(cipher(s, n));
		} catch (IOException e) {
			Log.logInfo(e.getMessage());
		}
	}
	private static StringBuilder cipher(String s, int n) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				sb.append(cipherInt(Integer.parseInt(ch + ""), n));
			} else {
				if (Character.isUpperCase(ch)) {
					sb.append(cipherUpperChar(ch, n));
				} else if (Character.isLowerCase(ch)) {
					sb.append(cipherChar(ch, n));
				} else {
					sb.append(ch);
				}
			}
		}
		return sb;
	}
	private static char cipherUpperChar(char c, int n) {

		n = n - 26 * (n / 26);
		int chara = c + n;
		int num = (chara - 'Z');
		return (char) (chara > 'Z' ? 'A' + num - 1: chara);
	}
	private static char cipherChar(char c, int n) {
		
		n = n - 26 * (n / 26);
		int chara = c + n;
		int num = (chara - 'z');
		return (char) (chara > 'z' ? 'a' + num - 1: chara);
	}
	private static int cipherInt(int di, int n) {
		
		n = n - 10 * (n / 10);
		int chara = di + n;
		return chara > 10 ? chara - 10 : chara;
	}
}
