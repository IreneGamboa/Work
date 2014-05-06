package com.mipos.ajustePropina;




import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.androidbegin.menuviewpagertutorial.R;


public class AjustePropina extends SherlockFragment {
	
	@Override
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
	            return textView;
	        }
	 
	        @Override
	        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
	            TextView textView = new TextView(AjustePropina.this.getActivity());
	            textView.setText(getChild(i, i1).toString());
	            return textView;
	        }
	 
	        @Override
	        public boolean isChildSelectable(int i, int i1) {
	            return true;
	        }
	 
	    }
		 
	 }
	/*private ArrayList<String> parentItems = new ArrayList<String>();
	private ArrayList<Object> childItems = new ArrayList<Object>();
	
	private SherlockExpandableListActivity prueba;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		// this is not really  necessary as ExpandableListActivity contains an ExpandableList
		//setContentView(R.layout.main);
		
		
		ExpandableListView expandableList =  prueba.getExpandableListView(); // you can use (ExpandableListView) findViewById(R.id.list)
		
		expandableList.setDividerHeight(2);
		expandableList.setGroupIndicator(null);
		expandableList.setClickable(true);

		setGroupParents();
		setChildData();

		MyExpandableAdapter adapter = new MyExpandableAdapter(parentItems, childItems);
		
		adapter.setInflater((LayoutInflater) prueba.getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
		expandableList.setAdapter(adapter);
		expandableList.setOnChildClickListener((OnChildClickListener) this);
	}

	public void setGroupParents() {
		parentItems.add("Android");
		parentItems.add("Core Java");
		parentItems.add("Desktop Java");
		parentItems.add("Enterprise Java");
	}

	public void setChildData() {
		
		// Android
		ArrayList<String> child = new ArrayList<String>();
		child.add("Core");
		child.add("Games");
		childItems.add(child);
		
		
		// Core Java
		child = new ArrayList<String>();
		child.add("Apache");
		child.add("Applet");
		child.add("AspectJ");
		child.add("Beans");
		child.add("Crypto");
		childItems.add(child);
		
		// Desktop Java
		child = new ArrayList<String>();
		child.add("Accessibility");
		child.add("AWT");
		child.add("ImageIO");
		child.add("Print");
		childItems.add(child);
		
		
		// Enterprise Java
		child = new ArrayList<String>();
		child.add("EJB3");
		child.add("GWT");
		child.add("Hibernate");
		child.add("JSP");
		childItems.add(child);
	}*/

