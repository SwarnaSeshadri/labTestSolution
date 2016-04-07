package com.example.testquestion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try{
			Intent i =getIntent();
			int x=i.getExtras().getInt("issuccess");
			if(x==1){
				Toast.makeText(this, "order placed successfully", Toast.LENGTH_LONG).show();
			}
			
		}
		catch(Exception e){}
	}

	public void order (View v){
		EditText et1,et2,et3,et4,et5;
		et1=(EditText)findViewById(R.id.editText2);
		et2=(EditText)findViewById(R.id.editText1);
		et3=(EditText)findViewById(R.id.EditText01);
		et4=(EditText)findViewById(R.id.editText4);
		et5=(EditText)findViewById(R.id.EditText02);
		
		String s1,s2,s3,s4,s5;
		s1=et1.getText().toString();
		s2=et2.getText().toString();
		s3=et3.getText().toString();
		s4=et4.getText().toString();
		s5=et5.getText().toString();
		
		Boolean b1,b2,b3;
		b1=((CheckBox)findViewById(R.id.checkBox1)).isChecked();
		b2=((CheckBox)findViewById(R.id.checkBox2)).isChecked();
		b3=((CheckBox)findViewById(R.id.checkBox3)).isChecked();
		
		Intent i = new Intent(this,Orderred.class);

		i.putExtra("name", s1);
		i.putExtra("phone", s2);
		if(b1){
			i.putExtra("paneer", s3);
		}
		else{
			i.putExtra("paneer", "");
		}
		if(b2){
			i.putExtra("gobi", s4);
		}
		else{
			i.putExtra("gobi", "");
		}
		if(b3){
			i.putExtra("juice", s5);
		}
		else{
			i.putExtra("juice", "");
		}

		startActivity(i);
	}
}
