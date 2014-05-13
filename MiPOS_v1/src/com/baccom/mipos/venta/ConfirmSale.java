package com.baccom.mipos.venta;

import com.baccom.mipos.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class ConfirmSale extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.confirmar_compra);
	    
	    getSupportActionBar().setIcon(android.R.color.transparent);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
	}
	
	public void makeSale(View view){
		Intent voucher = new Intent(this, Voucher.class);
		startActivity(voucher);
	}

}
