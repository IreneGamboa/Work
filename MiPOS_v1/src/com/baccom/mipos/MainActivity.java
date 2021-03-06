package com.baccom.mipos;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.baccom.mipos.adjustment_tip.AjustePropina;
import com.baccom.mipos.annulation.Anulacion;
import com.baccom.mipos.configuration.AccountConfiguration;
import com.baccom.mipos.configuration.ChangePasscode;
import com.baccom.mipos.configuration.ChangePassword;
import com.baccom.mipos.model.OptionsArrayAdapter;
import com.baccom.mipos.sale.DeviceConnect;
import com.baccom.mipos.sale.VentaFragment;
import com.baccom.mipos.R;

public class MainActivity extends ActionBarActivity {

	private DrawerLayout mDrawer;
	private ListView mDrawerListView;
	private ActionBarDrawerToggle mToggle;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;

	private String[] mCategories = { "Autorizacion", "Administrativo",
			"Miscelaneo" };
	private String[] mOptionsAut = { "Venta Colones", "Venta Dolares",
			"Venta Tasa Cero", "Venta MiniCuotas" };
	private String[] mOptionsAdmin = { "Ajuste de Propina", "Anulacion",
			"Devolucion", "Cierre", "Reportes" };
	private String[] mOptionsMisc = { "Configuracion", "Salir" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportActionBar().setIcon(android.R.color.transparent);
		getSupportActionBar().setDisplayShowTitleEnabled(false);

		mTitle = mDrawerTitle = getTitle();

		mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerListView = (ListView) findViewById(R.id.left_drawer);

		mDrawer.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

		OptionsArrayAdapter arrayAdapter = new OptionsArrayAdapter(
				this.getApplicationContext());

		arrayAdapter.addSection(mCategories[0],
				new ArrayAdapter<String>(this.getApplicationContext(),
						R.layout.list_option, mOptionsAut));
		arrayAdapter.addSection(mCategories[1],
				new ArrayAdapter<String>(this.getApplicationContext(),
						R.layout.list_option, mOptionsAdmin));
		arrayAdapter.addSection(mCategories[2],
				new ArrayAdapter<String>(this.getApplicationContext(),
						R.layout.list_option, mOptionsMisc));

		mDrawerListView.setAdapter(arrayAdapter);

		mDrawerListView.setOnItemClickListener(new DrawerItemClickListener());

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		mToggle = new ActionBarDrawerToggle(this, mDrawer,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getSupportActionBar().setTitle(mTitle);
			}

			public void onDrawerOpened(View drawerView) {
				getSupportActionBar().setTitle(mDrawerTitle);
				super.onDrawerOpened(drawerView);
			}
		};

		mDrawer.setDrawerListener(mToggle);

		if (savedInstanceState == null) {
			selectItem(0);
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		return mToggle.onOptionsItemSelected(item);
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> adapterView, View view,
				int position, long id) {
			// selectItem(position);
			String option = (String) adapterView.getItemAtPosition(position);
			selectItem(option, position);
		}
	}

	private void selectItem(String optionName, int position) {
		Fragment venta = new VentaFragment();
		Fragment ajusteP = new AjustePropina();
		Fragment anulacion = new Anulacion();
		Fragment configuracion = new AccountConfiguration();
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, venta)
				.commit();

		if (optionName.equals(mOptionsAut[0])) {
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, venta).commit();
			Log.i(optionName, optionName);
		} else if (optionName.equals(mOptionsAdmin[0])) {
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, ajusteP).commit();
			Log.i(optionName, optionName);
		} else if (optionName.equals(mOptionsAdmin[1])) {
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, anulacion).commit();
			Log.i(optionName, optionName);
		} else if (optionName.equals(mOptionsMisc[0])) {
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, configuracion).commit();
			Log.i(optionName, optionName);
		}
		mDrawerListView.setItemChecked(position, true);
		mDrawer.closeDrawer(mDrawerListView);
	}

	private void selectItem(int position) {
		// update the main content by replacing fragments
		Fragment venta = new VentaFragment();
		Fragment ajusteP = new AjustePropina();
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, venta)
				.commit();

		switch (position) {
		case 1:
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, venta).commit();
			break;
		case 2:
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, venta).commit();
			break;
		case 3:
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, venta).commit();
			break;
		case 4:
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, venta).commit();
			break;
		case 6:
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, ajusteP).commit();
			break;
		case 7:
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, ajusteP).commit();
			break;
		}

		// update selected item and title, then close the drawer
		mDrawerListView.setItemChecked(position, true);
		mDrawer.closeDrawer(mDrawerListView);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mToggle.onConfigurationChanged(newConfig);
	}

	public void continueSale(View view) {
		Intent deviceC = new Intent(this, DeviceConnect.class);
		startActivity(deviceC);
	}

	public void changePassword(View view){
		Intent changeP = new Intent (this, ChangePassword.class);
		startActivity(changeP);
	}

	public void changePasscode(View view){
		Intent changeP = new Intent (this, ChangePasscode.class);
		startActivity(changeP);
	}
}
