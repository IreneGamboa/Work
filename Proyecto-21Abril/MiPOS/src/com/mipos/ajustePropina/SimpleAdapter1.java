package com.mipos.ajustePropina;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SimpleAdapter1 extends BaseAdapter{
	
	Context context;
	List<Map<String, String>> list;
	int simpleListItem1;
	String[] title;
	int [] i;
	
	public SimpleAdapter1(Context context,
			List<Map<String, String>> list, int simpleListItem1,
			String[] strings, int[] is) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list=list;
		this.simpleListItem1=simpleListItem1;
		this.title=strings;
		this.i=is;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
