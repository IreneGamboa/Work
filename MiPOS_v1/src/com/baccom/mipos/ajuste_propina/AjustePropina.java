package com.baccom.mipos.ajuste_propina;




import com.baccom.mipos.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class AjustePropina extends Fragment {
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.ajuste_propina, container, false);
		ExpandableListView elv = (ExpandableListView) rootView.findViewById(R.id.list);
        elv.setAdapter(new SavedTabsListAdapter());
		return rootView;
		
	}
	
	
	 public class SavedTabsListAdapter extends BaseExpandableListAdapter {
		 
		 private String[] groups={"Venta Colones", "Venta Dolares", "Venta MiniCuotas"};
			
			private String[][] children = {
					{"*****1280","*****1280","*****1280"},
					{"*****1280","*****1280"},
					{"*****1280"}
			};
			
			@Override
	        public int getGroupCount() {
	            return groups.length;
	        }
	 
	        @Override
	        public int getChildrenCount(int i) {
	            return children[i].length;
	        }
	 
	        @Override
	        public Object getGroup(int i) {
	            return groups[i];
	        }
	 
	        @Override
	        public Object getChild(int i, int i1) {
	            return children[i][i1];
	        }
	 
	        @Override
	        public long getGroupId(int i) {
	            return i;
	        }
	 
	        @Override
	        public long getChildId(int i, int i1) {
	            return i1;
	        }
	 
	        @Override
	        public boolean hasStableIds() {
	            return true;
	        }
	 
	        @Override
	        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
	            TextView textView = new TextView(AjustePropina.this.getActivity());
	            textView.setText(getGroup(i).toString());
	            textView.setTextSize(25);
	            textView.setTextColor(Color.parseColor("#ffffff"));
	            textView.setBackgroundColor(Color.parseColor("#1854DE"));
	            return textView;
	        }
	 
	        @Override
	        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
	            TextView textView = new TextView(AjustePropina.this.getActivity());
	            textView.setText(getChild(i, i1).toString());
	            textView.setTextSize(20);
	            textView.setTextColor(Color.parseColor("#000000"));
	            textView.setBackgroundColor(Color.parseColor("#E3E4E6"));
	            return textView;
	        }
	 
	        @Override
	        public boolean isChildSelectable(int i, int i1) {
	            return true;
	        }
	 
	    }

}
