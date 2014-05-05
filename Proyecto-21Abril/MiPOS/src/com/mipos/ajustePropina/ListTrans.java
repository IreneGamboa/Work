package com.mipos.ajustePropina;

import com.androidbegin.menuviewpagertutorial.R;
import com.mipos.utilies.Group;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ExpandableListView;

public class ListTrans extends Activity {
	SparseArray<Group> groups = new SparseArray<Group>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ajuste_propina);
		createData();
		ExpandableListView listView = (ExpandableListView) findViewById(R.id.ListView_AP);
		MyExpandableListAdapter adapter = new MyExpandableListAdapter(this, groups);
		listView.setAdapter(adapter);
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
