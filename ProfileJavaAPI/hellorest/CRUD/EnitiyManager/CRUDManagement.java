package EnitiyManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import profile.Profile;
import customExceptions.CustomException;
import edu.neumont.csc380.AuthClient.AuthClient;
import edu.neumont.csc380.AuthClient.AuthResponse;

@Service("CRUDManagementService")
public class CRUDManagement implements CRUDService {

	HashMap<Integer, Profile> tempServer = new HashMap<Integer, Profile>();
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	int currentID = 1;
		
	public Response createProfile(Profile profile) throws CustomException 
	{
		Profile newProfile = profile;
		
		newProfile.setUserID(currentID);
		
		if(newProfile.getName() == null)
        {
            throw new CustomException("NO_NAME - User name is missing.");
        }
		
		if(newProfile.getName().length() > 50)
        {
            throw new CustomException("NAME_TOO_LONG - User name is over the character limit");
        }
		
		if(newProfile.getName().length() < 1)
        {
            throw new CustomException("NAME_TOO_SHORT - User name is under the character limit");
        }
		
		if(newProfile.getLocation() == null){
			throw new CustomException("NO_LOCATION - Location is missing");
		}
		
		if(newProfile.getLocation().getCity().length() > 50)
        {
            throw new CustomException("LOCATION_TOO_LONG - Location is over character limit");
        }
	
    	if(!validateEmailAddress(profile.getEmail()))
        {
            throw new CustomException("INVALID_EMAIL - Email is not a valid email address");
        }
		
		newProfile.setUserRating(0);

		BufferedReader reader = null;
		URL url = getClass().getResource("ProfileToken.txt");
		File file = new File(url.getPath());
		String tokenFromFile = "";

		try {
			reader = new BufferedReader(new FileReader(file));
			tokenFromFile = reader.readLine();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		AuthClient authClient  = new AuthClient();
		String password = "SuperSecurePassphrase";
		authClient.createAuth(profile.getUserID()+"", profile.getName(), password, tokenFromFile);
		AuthResponse authResponse = authClient.login(profile.getName(), password);
		System.out.println(authResponse.toString());
		tempServer.put(newProfile.getUserID(), newProfile);
		
		currentID++;
		return Response.status(201).entity(newProfile).build();		
				
	}
	
	
	public Response updateProfile(int id,Profile profile) throws CustomException
	{
		
		if(tempServer.containsKey(id))
		{
			if(profile == null){	
		    	throw new CustomException("NO_DATA – No data was given to update.");
		    }
			
			System.out.println("Profile id: "+profile.getUserID());
			System.out.println("Input id: "+id);
			
			if(id == profile.getUserID())
			{
				
				if(profile.getName().length() > 50)
		        {
		            throw new CustomException("NAME_TOO_LONG - User name is over the character limit");
		        }
				
				if(profile.getName().length() < 1)
		        {
		            throw new CustomException("NAME_TOO_SHORT - User name is under the character limit");
		        }
				
				if(profile.getLocation().getCity().length() > 50)
		        {
		            throw new CustomException("LOCATION_TOO_LONG - Location is over character limit");
		        }
			
				if(!validateEmailAddress(profile.getEmail()))
		        {
		            throw new CustomException("INVALID_EMAIL - Email is not a valid email address");
		        }
				
				tempServer.put(id,profile);
				
				return Response.ok().build();
			}
			else
			{
				throw new CustomException("ID_MISMATCH - The id on the request and the profile don’t match");
			}
		}
		else
		{
			return Response.status(404).build();   //id doesn't exist
		}		
	}
	
	public Response getProfile(int id) throws CustomException
	{
		if(tempServer.containsKey(id))
		{
			Profile profile = (Profile) tempServer.get(id);
			return Response.ok(profile).build();
		}
		else
		{
			return Response.status(404).build();
		}
		
	}
	
	public Response deleteProfile(int id) throws CustomException
	{
		if(tempServer.containsKey(id))
		{
			tempServer.remove(id);
			return Response.status(204).build();
		}
		else
		{
			return Response.status(404).build();
		}
	}
	
	private boolean validateEmailAddress(String s){
		 Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(s);
	        return matcher.find();
	}
}


