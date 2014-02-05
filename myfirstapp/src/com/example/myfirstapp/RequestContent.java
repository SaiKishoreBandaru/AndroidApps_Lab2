package com.example.myfirstapp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class RequestContent extends AsyncTask<String, Void, String>{
	
	
	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub

HttpClient dClientRequest = new DefaultHttpClient();
		
		InputStream resultStream = null;
		String sWeatherResult = "";
		String s="";
		String URL=arg0[0];
		//String URL="http://api.openweathermap.org/data/2.5/weather?q="+rEditText1.getText();
		
		try {
			
			HttpGet hpURL = new HttpGet(URL);
		   HttpResponse hrWebResponse = dClientRequest.execute(hpURL);
		    StatusLine statusLine = hrWebResponse.getStatusLine();
		    if(statusLine.getStatusCode() == HttpStatus.SC_OK)
		    {
		    HttpEntity heWebEntity = hrWebResponse.getEntity();
		    resultStream = heWebEntity.getContent();
		    BufferedReader bReader = new BufferedReader(new InputStreamReader(resultStream, "UTF-8"), 8);
		    StringBuilder sb = new StringBuilder();
		    
		    while((s = bReader.readLine()) != null)
		    {
		        sb.append(s + "\n");
		        //rEditText.setText(s);
		        
		    }
		    sWeatherResult = sb.toString();	
		    }
		        
		    
		} catch (Exception e) { 
			e.printStackTrace();
		
		}
		
		return sWeatherResult;	
	}

}
