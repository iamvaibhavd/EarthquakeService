package com.earthquakeInfo.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.geojson.Feature;
import org.geojson.FeatureCollection;

import com.earthquakeInfo.model.EarthquaeModel;
import com.fasterxml.jackson.annotation.JsonFormat.Features;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EarthquakeInfoService {
	
	public EarthquaeModel[] getEarthquakeInfo(String start , String end)
	{
		
		//EQ Service client
		
		URL url;
		try {
			url = new URL("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime="+start+"&endtime="+end);
		
		
		  HttpURLConnection conn = (HttpURLConnection) url.openConnection();;
		 
			conn.setRequestMethod("GET");
			conn.setRequestProperty("ACCEPT", "application/json");
			
			
			//Feed for EQ data
			FeatureCollection fcoll= new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false).readValue(new InputStreamReader((conn.getInputStream())), FeatureCollection.class);	
			
			
			//parse the JSON
			
			List<Feature> flist = fcoll.getFeatures();
			
			Feature[] feature = new Feature[flist.size()];
			
			EarthquaeModel[] eqModel = new EarthquaeModel[flist.size()];
			
			
			for(int i =0;i<flist.size();i++)
			{
				eqModel[i]  = new EarthquaeModel();
				feature[i] = fcoll.getFeatures().get(i);
				eqModel[i].setLocation(""+feature[i].getProperties().get("place"));
				eqModel[i].setMagnitude(""+feature[i].getProperties().get("mag"));
			}
			
			conn.disconnect();
			return eqModel;
			
			
	} catch (MalformedURLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
		
		
		
		return null;
		
		
	}

}
