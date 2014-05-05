package com.mipos.ajustePropina;



import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.androidbegin.menuviewpagertutorial.R;
import com.mipos.utilities.Group;

public class AjustePropina extends SherlockFragment{
	
	SparseArray<Group> groups = new SparseArray<Group>();
	//private Activity activity;
	private View activity;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.ajuste_propina, container, false);
		createData();
		ExpandableListView listView = (ExpandableListView) activity.findViewById(R.id.ListView_AP);
		 MyExpandableListAdapter adapter = new MyExpandableListAdapter(this, groups);
		listView.setAdapter(adapter);
		return rootView;
	}

	private void createData() {
		// TODO Auto-generated method stub
		for (int i = 0; i<4; i++){
			Group group = new Group();
			switch (i){
			case 0:
				group.setGroup("Venta Colones");
				for (int j = 0; j< 3; j++){
					group.childer.add("**********1280"+j);
				}
			break;
			case 1:
				group.setGroup("Venta Dolares");
				for (int j = 0; j< 3; j++){
					group.childer.add("**********1280"+j);
				}
			break;
			case 2:
				group.setGroup("Venta MiniCuotas");
				for (int j = 0; j< 3; j++){
					group.childer.add("**********1280"+j);
				}
			break;
			case 3:
				group.setGroup("Venta Tasa Cero");
				for (int j = 0; j< 3; j++){
					group.childer.add("**********1280"+j);
				}
			break;
			
			}
		}
	}
	
	
	
}
