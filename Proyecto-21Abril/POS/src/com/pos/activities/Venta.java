package com.pos.activities;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.pos.R;


public class Venta extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.venta, container, false);
		return rootView;
	}
	
}
