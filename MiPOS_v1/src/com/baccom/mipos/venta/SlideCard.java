package com.baccom.mipos.venta;

import com.baccom.mipos.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SlideCard extends Activity {
	
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.slide_card);
	   
	    getActionBar().setIcon(android.R.color.transparent);
		getActionBar().setDisplayShowTitleEnabled(false);
	    
	    final ProgressDialog progressDialog = ProgressDialog.show(SlideCard.this, "", "Validando Lector");
	    progressDialog.setProgressStyle(ProgressDialog.THEME_HOLO_LIGHT);
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
	    	}
	    }.start();
	    
	}
	
	
	
	
}
