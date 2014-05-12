package com.baccom.mipos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TerminalActivate extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.terminal_activate);
	    
	    getActionBar().hide();
        
	}
	
	public void activate(View view){
		Intent loginIntent = new Intent(this, Login.class);
		startActivity(loginIntent);
	}

}
