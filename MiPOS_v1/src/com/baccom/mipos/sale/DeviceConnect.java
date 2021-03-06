 package com.baccom.mipos.sale;

import java.util.Timer;
import java.util.TimerTask;

import com.baccom.mipos.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class DeviceConnect extends ActionBarActivity {

	private long splashDelay = 10000; //10 segundos

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.connnect_device);
	    
	    getSupportActionBar().setIcon(android.R.color.transparent);
		getSupportActionBar().setDisplayShowTitleEnabled(false);

	    TimerTask task = new TimerTask() {
	      @Override
	      public void run() {
	        Intent mainIntent = new Intent().setClass(DeviceConnect.this, SlideCard.class);
	        startActivity(mainIntent);
	        finish();//Destruimos esta activity para prevenit que el usuario retorne aqui presionando el boton Atras.
	      }
	    };

	    Timer timer = new Timer();
	    timer.schedule(task, splashDelay);//Pasado los 6 segundos dispara la tarea
	  }
}
