package com.baccom.mipos.venta;

import com.baccom.mipos.R;

import android.app.Activity;
import android.os.Bundle;

public class ConfirmSale extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.confirmar_compra);
	    
	    getActionBar().setIcon(android.R.color.transparent);
		getActionBar().setDisplayShowTitleEnabled(false);
	}

}
