package edu.neumont.csc380.AuthServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class CreateValidator {
	
	/**
	 * Validate the token matches 
	 * @param token
	 * @return true if the token matches
	 */
	public static boolean isValidCreateToken(String token) {
		BufferedReader reader = null;
		URL url = CreateValidator.class.getResource("ProfileToken.txt");
		File file = new File(url.getPath());
		String tokenFromFile = "";
		boolean match = false;

		try {
			reader = new BufferedReader(new FileReader(file));
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
