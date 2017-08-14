package com.earthquakeInfo.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.geojson.FeatureCollection;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class tempMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		URL url;
		try {
			url = new URL("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02");
		
		
		  HttpURLConnection conn = (HttpURLConnection) url.openConnection();;
		 
			conn.setRequestMethod("GET");
			conn.setRequestProperty("ACCEPT", "application/json");
			
			
			//Feed for EQ data
			FeatureCollection fcoll= new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false).readValue(new InputStreamReader((conn.getInputStream())), FeatureCollection.class);	
	

	
	} catch (MalformedURLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
