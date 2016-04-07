package com.example.testquestion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ReadSD extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read_sd);
		
		
		
		try {
			File file=new File("/sdcard/mysdfile.txt");
			FileInputStream fis= new FileInputStream(file);
			InputStreamReader isr= new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			
			String ss=br.readLine();
			while(ss!=null){
				Toast.makeText(this, ss, Toast.LENGTH_LONG).show();
				ss=br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
