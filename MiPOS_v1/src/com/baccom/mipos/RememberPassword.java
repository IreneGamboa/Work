package com.baccom.mipos;

import android.app.Activity;
import android.os.Bundle;


public class RememberPassword extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.remember_password);
	    
	    getActionBar().setHomeButtonEnabled(false);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(false);
        getActionBar().setIcon(android.R.color.transparent);
        getActionBar().setDisplayShowTitleEnabled(false);
       
	}

}
