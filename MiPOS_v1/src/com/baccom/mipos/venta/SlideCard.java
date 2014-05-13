package com.baccom.mipos.venta;

import com.baccom.mipos.R;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

public class SlideCard extends ActionBarActivity {
	
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.slide_card);
	   
	    getSupportActionBar().setIcon(android.R.color.transparent);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
	    
	    final ProgressDialog progressDialog = ProgressDialog.show(SlideCard.this, "", "Validando Lector");
	   
	    new Thread(){
	    	public void run(){
	    		try{
	    			sleep(10000);
	    		}catch (Exception e){
	    			Log.e("tag", e.getMessage());
	    		}
	    		progressDialog.dismiss();
	    		
	    		Intent confirmarCompra = new Intent(SlideCard.this, ConfirmSale.class);
	    		startActivity(confirmarCompra);
	    		finish();
	    	}
	    }.start();
	    
	}
	
	
	
	
}
