package edu.neumont.csc380.AuthServer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CreateValidator {
	
	/**
	 * Validate the token matches 
	 * @param token
	 * @return true if the token matches
	 */
	public static boolean isValidCreateToken(String token) {
		BufferedReader reader = null;
		String fileLocation = "ProfileToken.txt";
		boolean match = false;
		
		try {
			String tokenFromFile;
			reader = new BufferedReader(new FileReader(fileLocation));
			tokenFromFile = reader.readLine();
			if (token.equals(tokenFromFile)){
				match = true;
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return match;
	}
	
}
