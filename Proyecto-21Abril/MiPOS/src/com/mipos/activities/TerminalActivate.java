package com.mipos.activities;

import com.androidbegin.menuviewpagertutorial.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TerminalActivate extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activate_terminal);
	}
	
	public void activateTerminal(View v){
    	Intent loginIntent = new Intent (this, Login.class);
    	startActivity(loginIntent);
	}
}
