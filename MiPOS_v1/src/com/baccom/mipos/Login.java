package com.baccom.mipos;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.login);
	    
	    getActionBar().setHomeButtonEnabled(false);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(false);
        getActionBar().setIcon(android.R.color.transparent);
        getActionBar().setDisplayShowTitleEnabled(false);
	}
	
	public void login(View view){
		Intent mainIntent = new Intent(this, MainActivity.class);
		startActivity(mainIntent);
	}
	

}
