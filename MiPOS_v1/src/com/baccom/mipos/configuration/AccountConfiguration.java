package com.baccom.mipos.configuration;

import com.baccom.mipos.R;

//import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AccountConfiguration extends Fragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.account_configuration, container, false);
		return rootView;
		}
	
//	public void changePassword(View view){
//		Intent changeP = new Intent (AccountConfiguration.this.getActivity(), ChangePassword.class);
//		startActivity(changeP);
//	}
//
//	public void changePasscode(View view){
//		Intent changeP = new Intent (AccountConfiguration.this.getActivity(), ChangePasscode.class);
//		startActivity(changeP);
//	}
}
