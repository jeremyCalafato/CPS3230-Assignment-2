package main;
import java.io.*;
import java.net.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class loginRunner 
{
	//Main Class
	public static void main(String[] args) throws IOException 
	{
        loginRunner runner = new loginRunner();
        runner.login();
	}
	
	//Incorrect Login
	public void incorrectLogin()
	{
		System.out.println("User incorrectly logged in");
	}
	
	//Correct Login
	public void correctLogin()
	{	
		System.out.println("User correctly logged in");
	}
	
	//Viewing Alerts
	public void viewAlerts()
	{
		System.out.println("User viewed alerts");
	}
	
	//Log Out 
	public void logout ()
	{
		System.out.println("User logged out");
	}
	
	//Login Method
    public void login() throws IOException
    {
    	//Variables
    		//API-Related 
        BufferedReader bufferedReader;
        String line;
        StringBuilder APIreply = new StringBuilder();
        String errorMessage;
        URL url = new URL("https://api.marketalertum.com/EventsLog/58ec3bf1-c290-4382-8b12-e2d1fe574e5b");
        URLConnection conn = url.openConnection();
        
        	//Counters 
        int loginCounter = 0;
        int viewAlertsCounter = 0;
        int logoutCounter = 0;
        
        	//API Response Related
        int eventLogType = 8;
        Boolean loginStatus = false;

        //Attempt to read from API
        try 
    	{
        	bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        while ((line = bufferedReader.readLine()) != null) 
	        {
	        	APIreply.append(line);
	        }
	        
	        bufferedReader.close();
    	} 
        
        //In case there was an error while attempting to read from API
    	catch (IOException error) 
    	{
    		errorMessage = error.getMessage();
	        System.out.println(errorMessage);
	        
	        incorrectLogin();
	        return;
    	}
	        
        //Get the response from the API and turn it into a String
        String jsonString = APIreply.toString();
        
        //Create an array of type JSONArray and pass the API's response in string format
        JSONArray JSONArray = new JSONArray(jsonString);
        
        //Traverse the newly created JSONArray
        for (int i=0; i<JSONArray.length(); i++)
        {
            JSONObject currentObject = JSONArray.getJSONObject(i); 
            
            //Get the login status by going inside 'systemState' and finding the state of 'loggedIn' found within the JSONArray
            loginStatus = currentObject.getJSONObject("systemState").getBoolean("loggedIn");
            
            //Get the eventLogType by going inside 'eventLogType' found within the JSONArray
            eventLogType = currentObject.getInt("eventLogType");
            
            //Count every instance user logs in (which has an eventLogType of 5)
            if(eventLogType == 5)
            {
            	loginCounter++;
            }
            
            //Count every instance user views alerts (which has an eventLogType of 7)
            if(eventLogType == 7)
            {
            	viewAlertsCounter++;
            }
            
            //Count every instance user logs out (which has an eventLogType of 6)
            if(eventLogType == 6)
            {
            	logoutCounter++;
            }
           
        }     
             
        //If user did not manage to log in 
        if(loginStatus == false && loginCounter < 1)
        {
        	incorrectLogin();
        }
        
        //If user managed to log in
        if(loginStatus == true || loginCounter >= 1)
        {
        	correctLogin();
        	
        	//If user viewed alerts at least once
        	if(viewAlertsCounter >= 1)
        	{
        		viewAlerts();
        		
        	}
        	
        	//If user logged out at least once
        	if(logoutCounter >= 1)
        	{
        		logout();
        	}

        }
    }
  }