package com.baccom.mipos;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;


public class SplashScreenActivity extends Activity {
	private long splashDelay = 6000; //6 segundos

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_splash_screen);
	    
	    final SharedPreferences preferences = getSharedPreferences("com.baccom.mipos", 0);
		final SharedPreferences.Editor editor = preferences.edit();

	    TimerTask task = new TimerTask() {
	      @Override
	      public void run() {
	    	  boolean firstTime = preferences.getBoolean("first_time", true);
				if(!firstTime){  
					Log.i("fkpoqjfpowekopfkeowpfkpodq", ":D not first time");
					Intent mainIntent = new Intent().setClass(SplashScreenActivity.this, Login.class);
					startActivity(mainIntent);
					finish();//Destruimos esta activity para prevenit que el usuario retorne aqui presionando el boton Atras.
				} else {
					editor.putBoolean("first_time", false);
					Log.i("fkpoqjfpowekopfkeowpfkpodq", ":D first time");
					Intent mainIntent = new Intent().setClass(SplashScreenActivity.this, TerminalActivate.class);
					startActivity(mainIntent);
					finish();
				}
				editor.commit();
				editor.apply();
	      }
	    };

	    Timer timer = new Timer();
	    timer.schedule(task, splashDelay);//Pasado los 6 segundos dispara la tarea
	  }
	  
	  


}
