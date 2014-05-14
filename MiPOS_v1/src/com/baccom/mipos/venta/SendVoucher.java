package com.baccom.mipos.venta;


import com.baccom.mipos.R;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class SendVoucher extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.send_voucher);
	    
	    getSupportActionBar().setIcon(android.R.color.transparent);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
	}

}
