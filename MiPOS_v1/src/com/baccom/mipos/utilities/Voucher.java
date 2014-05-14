package com.baccom.mipos.utilities;

import com.baccom.mipos.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class Voucher extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.voucher);
	    
	    getSupportActionBar().setIcon(android.R.color.transparent);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
	}

	public void sendVoucher(View view){
		Intent sendVoucher = new Intent(this, SendVoucher.class);
		startActivity(sendVoucher);
	}
}
