package com.baccom.mipos.sale;



import com.baccom.mipos.R;

//import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VentaFragment extends Fragment {
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.venta, container, false);
		return rootView;
		}
	
//	public void continueSale(View view){
//		Intent deviceC = new Intent(VentaFragment.this.getActivity(), DeviceConnect.class);
//    	startActivity(deviceC);
//	}
	
}
