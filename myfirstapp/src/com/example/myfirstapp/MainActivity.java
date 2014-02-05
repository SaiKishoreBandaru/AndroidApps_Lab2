package com.example.myfirstapp;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.app.Activity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWeatherCondition();
    }

	private void getWeatherCondition() {
		// TODO Auto-generated method stub
		Button rButton =(Button)findViewById(R.id.button1);
		
		final TextView rEditText=(TextView)findViewById(R.id.editText3);
		final TextView rEditText1=(TextView)findViewById(R.id.editText2);
		rButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rEditText1.clearFocus();
				String sWeatherResult = "";
				String URL="http://api.openweathermap.org/data/2.5/weather?q="+rEditText1.getText();
				
	
				RequestContent sp=new RequestContent();
				
				sWeatherResult = sp.doInBackground(URL);
				
				try {
					JSONObject jObject=new JSONObject(sWeatherResult);
					int iTemp = jObject.getInt("temp");
					iTemp=((9*(iTemp-273))/5)+32;
					rEditText.setText(iTemp);
					rEditText.setText(sWeatherResult);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					rEditText.setText("catch");
				}
						
			        
			}
		});
		
	}
   

}
