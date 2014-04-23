package com.pos.activities;

import com.pos.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends Activity {
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.login);
	    }

	 public void login(View v){
	    	Intent menuIntent = new Intent (this, Menu.class);
	    	startActivity(menuIntent);
	    }
}
