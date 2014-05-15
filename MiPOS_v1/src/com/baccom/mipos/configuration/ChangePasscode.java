package com.baccom.mipos.configuration;

import com.baccom.mipos.R;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class ChangePasscode extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.change_passcode);

		getSupportActionBar().setIcon(android.R.color.transparent);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
	}

	public void changePascode() {

	}
}
