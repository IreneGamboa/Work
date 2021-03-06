package com.pos.activities;


import com.pos.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MenuListAdapter extends BaseAdapter {
	
	Context context;
	String [] mTitle;
	LayoutInflater inflater;
	

	public MenuListAdapter(Context context, String[] title) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.mTitle = title;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mTitle.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mTitle[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView txtTitle;
		
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View itemView = inflater.inflate(R.layout.drawer_list_item, parent, false);
		txtTitle = (TextView) itemView.findViewById(R.id.title);
		
		txtTitle.setText(mTitle[position]);
		
		return itemView;
	}

}
