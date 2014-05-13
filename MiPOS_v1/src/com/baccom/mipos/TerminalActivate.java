package com.baccom.mipos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class TerminalActivate extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.terminal_activate);
	    
	    getSupportActionBar().hide();
        
	}
	
	public void activate(View view){
		Intent loginIntent = new Intent(this, Login.class);
		startActivity(loginIntent);
	}

}
