package com.pos.activities;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.pos.R;


public class Menu extends SherlockFragmentActivity {
	


	

	public class DrawerItemClickListener implements ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			selectItem(position);

		}

	}

	//Variables
	DrawerLayout mDrawerLayout;
	ListView mDrawerList;
	ActionBarDrawerToggle mDrawerToggle;
	MenuListAdapter mMenuAdapter;
	String [] title;
	Fragment venta = new Venta();
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		mTitle = mDrawerTitle = getTitle();
		
		title = new String[] {"ventas Colones" , "Ventas Doalers", "Ventas MiniCuotas", 
				"Ventas Tasa Cero", "Ajuste de Propina", "Anulacion", "Devolucion", "Cierre",
				"Reportes", "Configuracion", "Salir"};
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		
		mDrawerList = (ListView) findViewById(R.id.listview_drawer);
		
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		
		mMenuAdapter = new MenuListAdapter(Menu.this, title);
		
		mDrawerList.setAdapter(mMenuAdapter);
		
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 
				R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close){
			
			public void onDrawerClosed(View view){
				super.onDrawerClosed(view);
			}
			public void onDrawerOpened(View view){
				getSupportActionBar().setTitle(mDrawerTitle);
				super.onDrawerOpened(view);
			}
		};
		
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		if(savedInstanceState == null){
			selectItem(0);
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		if (item.getItemId()== android.R.id.home){
			if(mDrawerLayout.isDrawerOpen(mDrawerList)){
				mDrawerLayout.closeDrawer(mDrawerList);
			}else {
				mDrawerLayout.openDrawer(mDrawerList);
			}
		}
		return super.onOptionsItemSelected(item);
	}

	private void selectItem(int i) {
		// TODO Auto-generated method stub
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		switch (i){
		case 0:
			ft.replace(R.id.content_frame, venta);
			break;
		}
		ft.commit();
		mDrawerList.setItemChecked(i, true);
		setTitle(title[i]);
		mDrawerLayout.closeDrawer(mDrawerList);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState){
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig){
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	@Override
	public void setTitle(CharSequence title){
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}
	
	@Override
	public void onBackPressed(){
		FragmentManager manager = getSupportFragmentManager();
		if (manager.getBackStackEntryCount() > 0){
			manager.popBackStack();
		}else{
			super.onBackPressed();
		}
	}
}