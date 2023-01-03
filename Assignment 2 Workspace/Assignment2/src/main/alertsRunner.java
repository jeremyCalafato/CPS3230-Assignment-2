package main;
import java.io.*;
import java.net.*;

import org.json.JSONArray;
import org.json.JSONObject;


public class alertsRunner 
{
	//Main Class
	public static void main(String[] args) throws IOException 
	{
        alertsRunner runner = new alertsRunner();
        runner.checkAlerts();
	}
	
	//Alerts not posted
	public void unsuccessfullyPostAlerts()
	{
		System.out.println("No alerts were posted");
	}
	
	//Alerts posted
	public void successfullyPostAlerts()
	{
		System.out.println("Alerts were posted");
	}
	
	//Actual number of alerts != Intended number of alerts
	public void unintendedNumberOfAlertsPosted()
	{
		System.out.println("Incorrect number of alerts posted");
	}
	
	//Actual number of alerts == Intended number of alerts
	public void intendedNumberOfAlertsPosted()
	{
		System.out.println("Correct number of alerts posted");
	}
	
	//Uploaded alerts contain valid heading, icon, alert type etc.
	public void alertsCorrectlyPosted()
	{
		System.out.println("The required alert properties are all present");
	}
	
	//Uploaded alerts do not contain valid heading, or icon, or alert type etc.
	public void alertsIncorrectlyPosted(String missingAlertProperty)
	{
		System.out.println("The Required alert properties are not all present");
		System.out.println(missingAlertProperty);
	}
	
	//Alerts deleted
	public void alertsDeleted()
	{
		System.out.println("Alerts have been deleted");
	}
	
	//Alerts not deleted
	public void alertsNotDeleted()
	{
		System.out.println("Alerts have not been deleted");
	}
	
	public void checkAlerts() throws IOException
	{   
		//Variables
			//API-Related
		BufferedReader bufferedReader;
		String line;
		StringBuilder APIreply = new StringBuilder();
		URL url = new URL("https://api.marketalertum.com/EventsLog/58ec3bf1-c290-4382-8b12-e2d1fe574e5b");
		URLConnection conn = url.openConnection();
		  
			//Counters
		int numberOfAlertsCreated = 0;
		int alertsDeletedCounter = 0;
		
			//API Response-Related
		int eventLogType = 8;
		JSONArray alertContent = new JSONArray();
		
		bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		while ((line = bufferedReader.readLine()) != null) 
		{
			APIreply.append(line);
		}
			
		bufferedReader.close();
		        
		//Get the response from the API and turn it into a String
		String jsonString = APIreply.toString();
		  
		//Create an array of type JSONArray and pass the API's response in string format
		JSONArray JSONArray2 = new JSONArray(jsonString);
		  
		//Traverse the array 
		for (int i=0; i<JSONArray2.length(); i++)
		{
			JSONObject currentObject = JSONArray2.getJSONObject(i); 
			      
			//Get the alerts by going inside 'systemState' and finding the contents inside of 'alerts'
			eventLogType = currentObject.getInt("eventLogType");
			alertContent = currentObject.getJSONObject("systemState").getJSONArray("alerts");
		      
			//Count every instance user creates alert
			if(eventLogType == 0)
			{
				numberOfAlertsCreated++;
			} 
			
			//Count every instance user deletes alert
			if(eventLogType == 1)
			{
				alertsDeletedCounter++;
			} 
			
		}  
		
		  //If user deleted at least one alert
	      if(alertsDeletedCounter >= 1)
	      {
	    	  alertsDeleted();
    	  
	    	//If user did not manage to post even one alert
	  		if (numberOfAlertsCreated == 0)
			{
				unsuccessfullyPostAlerts();
			}
			
	  	    //If user posted an alert
			else
			{
				successfullyPostAlerts();
				
				//If the number of alerts actually posted does not match the number of alerts intended to be posted
				if(numberOfAlertsCreated != 3)
				{
					unintendedNumberOfAlertsPosted();
				} 
				
				//If the number of alerts actually posted is equal to the number of alerts intended to be posted
				else
				{
					intendedNumberOfAlertsPosted();
					checkAlertsContains(alertContent);
				}
			}
	      }
	      
	      //If user did not delete at least one alert
	      else
	      {
	    	  alertsNotDeleted();
	      }
	}

	  public void checkAlertsContains(JSONArray alertContent) throws IOException
	  {
	      int alertType;
	      String alertHeading;
	      String alertDescription;
	      String alertURL;
	      String alertImageURL;
	      int alertPriceInCents;
	      
	      int correctAlertType = 0;
	      int correctAlertHeading = 0;
	      int correctAlertDescription = 0;
	      int correctAlertURL = 0;
	      int correctAlertImageURL = 0;
	      int correctAlertPriceInCents = 0;
	      
			for (int j=0; j<=alertContent.length()-1; j++)
			{
				JSONObject currentAlert = alertContent.getJSONObject(j); 
				
				alertType = currentAlert.getInt("alertType");
				alertHeading = currentAlert.getString("heading");
				alertDescription = currentAlert.getString("description");
				alertURL = currentAlert.getString("url");
				alertImageURL = currentAlert.getString("imageURL");
				alertPriceInCents = currentAlert.getInt("priceInCents");
					
				//Check for whether the alerts contains a valid alert type
				if(alertType > 1 || alertType < 6)
				{
					correctAlertType++;
				}
				
				//Check for whether the alerts contains a valid alert heading
				if(!alertHeading.isEmpty())
				{
					correctAlertHeading++;
				}
				
				//Check for whether the alerts contains a valid alert description
				if(!alertDescription.isEmpty())
				{
					correctAlertDescription++;
				}
				
				//Check for whether the alerts contains a valid alert url
				if(!alertURL.isEmpty())
				{
					correctAlertURL++;
				}
				
				//Check for whether the alerts contains a valid alert image url
				if(!alertImageURL.isEmpty())
				{
					correctAlertImageURL++;
				}
				
				//Check for whether the alerts contains a valid price in cents
				if(alertPriceInCents > 0)
				{
					correctAlertPriceInCents++;
				}
				
				//In the case that all the uploaded alerts contain a valid alert type, heading, description, URL, image URL, and price in cents
				if(correctAlertType == 3 && correctAlertHeading == 3 && correctAlertDescription == 3 && correctAlertURL == 3 && correctAlertImageURL == 3 && correctAlertPriceInCents == 3)
				{
					alertsCorrectlyPosted();
				}
			}
	  	
		//In the case that at least 1 alert contains an invalid alert type
	  	if (correctAlertType != 3) 
	  	{
	  		String missingAlertProperty = "There are not 3 alerts types";
	  		alertsIncorrectlyPosted(missingAlertProperty);
	  	}
	  	
	    //In the case that at least 1 alert contains an invalid heading
	  	if (correctAlertHeading != 3) 
	  	{
	  		String missingAlertProperty = "There are not 3 alert headings";
	  		alertsIncorrectlyPosted(missingAlertProperty);
	  	}
	  	
	    //In the case that at least 1 alert contains an invalid description
	  	if (correctAlertDescription != 3) 
	  	{
	  		String missingAlertProperty = "There are not 3 alert descriptions";
	  		alertsIncorrectlyPosted(missingAlertProperty);
	  	}
	  	
	    //In the case that at least 1 alert contains an invalid URL
	  	if (correctAlertURL != 3) 
	  	{
	  		String missingAlertProperty = "There are not 3 alert URLs";
	  		alertsIncorrectlyPosted(missingAlertProperty);
	  	}
	  	
	    //In the case that at least 1 alert contains an invalid image URL
	  	if (correctAlertImageURL != 3) 
	  	{
	  		String missingAlertProperty = "There are not 3 alert image URLs";
	  		alertsIncorrectlyPosted(missingAlertProperty);
	  	}
	  	
	    //In the case that at least 1 alert contains an invalid price in cents
	  	if (correctAlertPriceInCents != 3) 
	  	{
	  		String missingAlertProperty = "There are not 3 alert prices in cents";
	  		alertsIncorrectlyPosted(missingAlertProperty);
	  	}
	  }
	  

}
