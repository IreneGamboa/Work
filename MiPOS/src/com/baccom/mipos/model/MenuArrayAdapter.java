package com.baccom.mipos.model;

import java.util.LinkedHashMap;
import java.util.Map;

import com.mipos.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

public class MenuArrayAdapter extends BaseAdapter {
	
	public final Map<String,Adapter> sections = new LinkedHashMap<String,Adapter>();
	public final ArrayAdapter<String> headers;
	public final static int TYPE_SECTION_HEADER = 0;
	
	
	

	public MenuArrayAdapter(Context applicationContext) {
		// TODO Auto-generated constructor stub
		headers = new ArrayAdapter<String>(applicationContext, R.layout.list_header);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		int total = 0;
		for(Adapter adapter : this.sections.values())
			total += adapter.getCount()+1;
		return total;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		for (Object section : this.sections.keySet()){
			Adapter adapter = sections.get(section);
			int size = adapter.getCount()+1;
			
			//check the position (inside this section)
			if(position==0) return section;
			if (position< size) return adapter.getItem(position-1);
			
			position -= size; // jump into next section
			
		}
		return null;
	}


	public int getViewTypeCount() {
        // assume that headers count as one, then total all sections
        int total = 1;
        for(Adapter adapter : this.sections.values())
            total += adapter.getViewTypeCount();
        return total;
    }

    public int getItemViewType(int position) {
        int type = 1;
        for(Object section : this.sections.keySet()) {
            Adapter adapter = sections.get(section);
            int size = adapter.getCount() + 1;

            // check if position inside this section
            if(position == 0) return TYPE_SECTION_HEADER;
            if(position < size) return type + adapter.getItemViewType(position - 1);

            // otherwise jump into next section
            position -= size;
            type += adapter.getViewTypeCount();
        }
        return -1;
    }

    public boolean areAllItemsSelectable() {
        return false;
    }

    public boolean isEnabled(int position) {
        return (getItemViewType(position) != TYPE_SECTION_HEADER);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int sectionNum = 0;
        for(Object section : this.sections.keySet()) {
            Adapter adapter = sections.get(section);
            int size = adapter.getCount() + 1;

            // check if position inside this section
            if(position == 0) return headers.getView(sectionNum, convertView, parent);
            if(position < size) return adapter.getView(position - 1, convertView, parent);

            // otherwise jump into next section
            position -= size;
            sectionNum++;
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

	public void addSection(String section, ArrayAdapter<String> adapter) {
		// TODO Auto-generated method stub
		this.headers.add(section);
		this.sections.put(section, adapter);	
	}

	

}
