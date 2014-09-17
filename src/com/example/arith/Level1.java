package com.example.arith;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Level1 extends Activity implements OnTouchListener{

	Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,del,ok;
	TextView Op1,Op2,Operator,Score,Input,HighScore;
	String strInput;
	Boolean isRunning;
	ProgressBar progress;
	Long startTime=System.currentTimeMillis();
	public static final String Tag=Level1.class.getSimpleName(); 
	float per;
	public static String filename="OurSharedString";
	SharedPreferences someData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.level1);
		initvar();	
		
		new Thread()
		{
			public void run() {
		
				// TODO Auto-generated method stub
			while(isRunning)
				{
				per=(System.currentTimeMillis()-startTime);
				per=per/300;
				try {
					progress.setProgress((int)per);
					Thread.sleep(100);
					
				
				if(per>=100)
				{
					checkScore();
					finish();
				}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}		
		}.start();
		someData=getSharedPreferences(filename,0);
		
	}
	
	public void setScore()
	{
		someData=getSharedPreferences(filename,0);
		String strScore=someData.getString("lvl1Score", "0");
		HighScore.setText(strScore);
	}
	public void checkScore()
	{
		String strScore=Score.getText().toString();
		String strHighScore=HighScore.getText().toString();
		
		if(Integer.parseInt(strScore)>Integer.parseInt(strHighScore))
		{
			SharedPreferences.Editor editor=someData.edit();
			editor.putString("lvl1Score",strScore);
			editor.commit();		
		}

		
	}
	
	private void initvar() {
		// TODO Auto-generated method stub
		isRunning=true;
		
		n0=(Button)findViewById(R.id.bNum0);
		n1=(Button)findViewById(R.id.bNum1);
		n2=(Button)findViewById(R.id.bNum2);
		n3=(Button)findViewById(R.id.bNum3);
		n4=(Button)findViewById(R.id.bNum4);
		n5=(Button)findViewById(R.id.bNum5);
		n6=(Button)findViewById(R.id.bNum6);
		n7=(Button)findViewById(R.id.bNum7);
		n8=(Button)findViewById(R.id.bNum8);
		n9=(Button)findViewById(R.id.bNum9);
		del=(Button)findViewById(R.id.bDel);
		ok=(Button)findViewById(R.id.bOk);
		Input=(TextView)findViewById(R.id.tvInput);
		Op1=(TextView)findViewById(R.id.tvOp1);
		Op2=(TextView)findViewById(R.id.tvOp2);
		Operator=(TextView)findViewById(R.id.tvOperator);
		Score=(TextView)findViewById(R.id.tvScore);
		HighScore=(TextView)findViewById(R.id.tvHighScore);
		progress=(ProgressBar) findViewById(R.id.progressBar1);
		
		n0.setOnTouchListener(this);
		n1.setOnTouchListener(this);
		n2.setOnTouchListener(this);
		n3.setOnTouchListener(this);
		n4.setOnTouchListener(this);
		n5.setOnTouchListener(this);
		n6.setOnTouchListener(this);
		n7.setOnTouchListener(this);
		n8.setOnTouchListener(this);
		n9.setOnTouchListener(this);
		del.setOnTouchListener(this);
		ok.setOnTouchListener(this);

		random_gen();
		setScore();
	}
	
	

	public boolean onTouch(View v,MotionEvent event) {
		// TODO Auto-generated method stub
		strInput=Input.getText().toString();
		
		switch(v.getId())
		{
		case R.id.bNum0:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
				n0.setBackgroundResource(R.drawable.shape_press);
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				n0.setBackgroundResource(R.drawable.shape);
				strInput=strInput.concat("0");
				Input.setText(strInput);
			}
			check();
			break;
		case R.id.bNum1:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
				n1.setBackgroundResource(R.drawable.shape_press);
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				n1.setBackgroundResource(R.drawable.shape);
				strInput=strInput.concat("1");
				Input.setText(strInput);
			}
			check();
			break;
		case R.id.bNum2:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
				n2.setBackgroundResource(R.drawable.shape_press);
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				n2.setBackgroundResource(R.drawable.shape);
				strInput=strInput.concat("2");
				Input.setText(strInput);
			}
			check();
			break;
			
		case R.id.bNum3:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
				n3.setBackgroundResource(R.drawable.shape_press);
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				n3.setBackgroundResource(R.drawable.shape);
				strInput=strInput.concat("3");
				Input.setText(strInput);
			}
			check();
			break;
		case R.id.bNum4:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
				n4.setBackgroundResource(R.drawable.shape_press);
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				n4.setBackgroundResource(R.drawable.shape);
				strInput=strInput.concat("4");
				Input.setText(strInput);
			}
			check();
			break;
		case R.id.bNum5:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
				n5.setBackgroundResource(R.drawable.shape_press);
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				n5.setBackgroundResource(R.drawable.shape);
				strInput=strInput.concat("5");
				Input.setText(strInput);
			}
			check();
			break;
		case R.id.bNum6:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
				n6.setBackgroundResource(R.drawable.shape_press);
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				n6.setBackgroundResource(R.drawable.shape);
				strInput=strInput.concat("6");
				Input.setText(strInput);
			}
			check();
			break;
		case R.id.bNum7:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
				n7.setBackgroundResource(R.drawable.shape_press);
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				n7.setBackgroundResource(R.drawable.shape);
				strInput=strInput.concat("7");
				Input.setText(strInput);
			}
			check();
			break;
		case R.id.bNum8:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
				n8.setBackgroundResource(R.drawable.shape_press);
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				n8.setBackgroundResource(R.drawable.shape);
				strInput=strInput.concat("8");
				Input.setText(strInput);
			}
			check();
			break;
		case R.id.bNum9:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
				n9.setBackgroundResource(R.drawable.shape_press);
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				n9.setBackgroundResource(R.drawable.shape);
				strInput=strInput.concat("9");
				Input.setText(strInput);
			}
			check();
			break;
		case R.id.bDel:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
				del.setBackgroundResource(R.drawable.shape_press);
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				del.setBackgroundResource(R.drawable.shape);
				if(strInput.length()==0)
					break;
				if(strInput.length()==1)
				{
					Input.setText(null);
					break;
				}
				strInput=strInput.substring(0, strInput.length()-1);
				Input.setText(strInput);
			}
			check();
			break;
		case R.id.bOk:
			if(event.getAction()==MotionEvent.ACTION_DOWN)
				ok.setBackgroundResource(R.drawable.shape_press);
			else if(event.getAction()==MotionEvent.ACTION_UP)
			{
				ok.setBackgroundResource(R.drawable.shape);
				check();
				random_gen();
			}
			break;
		}
		
		return true;
	}
	
	
	private void check() {
		// TODO Auto-generated method stub
		int num1,num2,res,op;
		boolean correct=false;
		num1=Integer.parseInt((String)Op1.getText());
		num2=Integer.parseInt((String)Op2.getText());
		
		if(Input.getText().toString()!="")
		{	
		res=Integer.parseInt(Input.getText().toString());
		if(Operator.getText()=="+")
		{
			if(res==(num1+num2))
				correct=true;
		}
		else if(Operator.getText()=="-")
		{
			if(res==(num1-num2))
				correct=true;
		}	
		
		else if(Operator.getText()=="*")
		{
			if(res==(num1*num2))
				correct=true;
		}	
		
		
		if(correct==true)
		{
			res=5+Integer.parseInt(Score.getText().toString());
			Score.setText(Integer.toString(res));
			random_gen();
		}
		}
	}
	private void random_gen() {
		// TODO Auto-generated method stub
		long temp1=System.currentTimeMillis();
		temp1=(long) (temp1*Math.random());
		temp1=temp1%10;
		
		long temp2=System.currentTimeMillis();
		temp2=(long) (temp2*Math.random());
		temp2=temp2%10;
		
		long temp;
		if(temp1>=temp2)
		{
			Op1.setText(Integer.toString((int)temp1));
			Op2.setText(Integer.toString((int)temp2));
		}
		else
		{
			Op1.setText(Integer.toString((int)temp2));
			Op2.setText(Integer.toString((int)temp1));		
		}
		
		temp=System.currentTimeMillis();
		temp=(long) (temp*Math.random());
		temp=temp%3;
		if(temp==0)
			Operator.setText("+");
		else if(temp==1)
			Operator.setText("-");
		else if(temp==2)
			Operator.setText("*");
		
		Input.setText("");
	}
	
	
	

}