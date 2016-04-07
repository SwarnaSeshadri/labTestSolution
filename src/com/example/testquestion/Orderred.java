package com.example.testquestion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Orderred extends Activity {

	String name,phone,paneer,gobi,juice;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_orderred);
		
		try{
			Intent i= getIntent();
			name=i.getExtras().getString("name");
			phone=i.getExtras().getString("phone");
			paneer=i.getExtras().getString("paneer");
			gobi=i.getExtras().getString("gobi");
			juice=i.getExtras().getString("juice");
			
			
			TextView tv;
			tv=(TextView)findViewById(R.id.textView1);
			tv.setText("order name.." + name+" phone is.. "+phone+ "paneer?.."+ paneer + "gobi?.." +gobi +"juice?.." +juice);
			
		}
		catch(Exception e){
			
		}
		
	}

	
	public void oorder(View v){
		
		//sd card write
		
			try {
				File myFile = new File("/sdcard/mysdfile.txt");
				if(!myFile.exists())
					myFile.createNewFile();
				FileOutputStream fOut = new FileOutputStream(myFile);
				OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
				
				myOutWriter.append("order name.." + name+" phone is.. "+phone+ "paneer?.."+ paneer + "gobi?.." +gobi +"juice?.." +juice);
				myOutWriter.close();
				fOut.close();
				
		//		Toast.makeText(getBaseContext(),"Done writing SD 'mysdfile.txt'",Toast.LENGTH_SHORT).show();
			} catch (Exception e) {
				//Toast.makeText(getBaseContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
			}
		
		Intent i= new Intent(this,MainActivity.class);
		i.putExtra("issuccess", 1);
		startActivity(i);
		
		
	}
	public void viewOrder(View v){
		Intent i= new Intent(this,ReadSD.class);
		
		startActivity(i);
		
		

	}
}
