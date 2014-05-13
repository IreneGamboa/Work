package com.baccom.mipos;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class RememberPassword extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.remember_password);
	    
	    getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setIcon(android.R.color.transparent);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
       
	}

}
