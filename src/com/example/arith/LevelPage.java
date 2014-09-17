package com.example.arith;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class LevelPage extends Activity implements View.OnTouchListener{

	Button lvl1,lvl2,lvl4,lvl3;
	Intent i;
	public static final String Tag=Level1.class.getSimpleName(); 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
	
		setContentView(R.layout.level);
		initvar();
	}
	private void initvar() {
		// TODO Auto-generated method stub
		
		lvl1=(Button) findViewById(R.id.ibLvl1);
		lvl2=(Button) findViewById(R.id.ibLvl2);
		lvl3=(Button) findViewById(R.id.ibLvl3);
		lvl4=(Button) findViewById(R.id.ibLvl4);

		
		lvl1.setOnTouchListener(this);
		lvl2.setOnTouchListener(this);
		lvl3.setOnTouchListener(this);
		lvl4.setOnTouchListener(this);
		
	}
	
	

	public boolean onTouch(View v,MotionEvent event) {
		// TODO Auto-generated method stub
		Log.d(Tag,"inside switch");
		switch(v.getId())
		{
		case R.id.ibLvl1:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
			{
				lvl1.setBackgroundResource(R.drawable.shape_press);
				Log.d(Tag, "Button Pressed");
			}
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				lvl1.setBackgroundResource(R.drawable.shape);
				Log.d(Tag, "Button Released");
				i=new Intent("com.example.arith.Level1");
				startActivity(i);
			}
			break;
		
		case R.id.ibLvl2:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
			{
				lvl2.setBackgroundResource(R.drawable.shape_press);
			}
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				lvl2.setBackgroundResource(R.drawable.shape);
				i=new Intent("com.example.arith.Level2");
				startActivity(i);
			}
			break;
		case R.id.ibLvl3:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
			{
				lvl3.setBackgroundResource(R.drawable.shape_press);
			}
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				lvl3.setBackgroundResource(R.drawable.shape);
				i=new Intent("com.example.arith.Level3");
				startActivity(i);
			}
			break;
		case R.id.ibLvl4:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
			{
				lvl4.setBackgroundResource(R.drawable.shape_press);
			}
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				lvl4.setBackgroundResource(R.drawable.shape);
				i=new Intent("com.example.arith.Level4");
				startActivity(i);
			}
			break;
		}
		
		return true;
	}
	
	
}
