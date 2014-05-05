package com.mipos.utilities;

import java.util.ArrayList;
import java.util.List;

public class Group {
	public String string;
	public final List<String> childer = new ArrayList<String>();
	

	public Group() {
		// TODO Auto-generated constructor stub
	}

	public void setGroup(String group){
		this.string=group;
	}
}
