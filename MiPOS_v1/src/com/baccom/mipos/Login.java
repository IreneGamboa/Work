package com.baccom.mipos;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class Login extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.login);
	    
	    getSupportActionBar().hide();
       
	}
	
	public void login(View view){
		Intent mainIntent = new Intent(this, MainActivity.class);
		startActivity(mainIntent);
	}
	
	public void rememberPass(View view){
		Intent rePa = new Intent(this, RememberPassword.class);
		startActivity(rePa);
	}
	

}
