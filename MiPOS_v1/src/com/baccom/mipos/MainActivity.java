package com.baccom.mipos;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;





import com.baccom.mipos.ajuste_propina.AjustePropina;
import com.baccom.mipos.model.OptionsArrayAdapter;
import com.baccom.mipos.venta.VentaFragment;
import com.baccom.mipos.R;


public class MainActivity extends ActionBarActivity {

    private DrawerLayout mDrawer;
    private ListView mDrawerListView;
    private ActionBarDrawerToggle mToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    private String[] mCategories = {"Autorizacion", "Administrativo", "Miscelaneo"};
    private String[] mOptionsAut = {"Venta Colones", "Venta Dolares", "Venta Tasa Cero", "Venta MiniCuotas"};
    private String[] mOptionsAdmin = {"Ajuste de Propina", "Anulacion","Devolucion","Cierre", "Reportes"};
    private String[] mOptionsMisc = {"Configuracion", "Cierre"};
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        

        mTitle = mDrawerTitle = getTitle();

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerListView = (ListView) findViewById(R.id.left_drawer);

        mDrawer.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        OptionsArrayAdapter arrayAdapter = new OptionsArrayAdapter(this.getApplicationContext());

        arrayAdapter.addSection(mCategories[0], new ArrayAdapter<String>(this.getApplicationContext(), R.layout.list_option, mOptionsAut));
        arrayAdapter.addSection(mCategories[1], new ArrayAdapter<String>(this.getApplicationContext(), R.layout.list_option, mOptionsAdmin));
        arrayAdapter.addSection(mCategories[2], new ArrayAdapter<String>(this.getApplicationContext(), R.layout.list_option, mOptionsMisc));

        
        mDrawerListView.setAdapter(arrayAdapter);

        mDrawerListView.setOnItemClickListener(new DrawerItemClickListener());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        mToggle = new ActionBarDrawerToggle(this,  mDrawer, R.drawable.ic_launcher,
                R.string.drawer_open, R.string.drawer_close){
            public void onDrawerClosed(View view){
                getSupportActionBar().setTitle(mTitle);
            }

            public void onDrawerOpened(View drawerView){
                getSupportActionBar().setTitle(mDrawerTitle);
                super.onDrawerOpened(drawerView);
            }
        };
        mDrawer.setDrawerListener(mToggle);

        if (savedInstanceState == null)
        {
            selectItem(0);
        }

        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        return mToggle.onOptionsItemSelected(item);
    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position)
    {
        // update the main content by replacing fragments
        Fragment venta = new VentaFragment();
        Fragment ajusteP = new AjustePropina();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, venta).commit();
             
        switch (position){
        	case 1:
        		fragmentManager.beginTransaction().replace(R.id.content_frame, venta).commit();
        		break;
        	case 2:
        		fragmentManager.beginTransaction().replace(R.id.content_frame, venta).commit();
        		break;
        	case 3:
        		fragmentManager.beginTransaction().replace(R.id.content_frame, venta).commit();
        		break;
        	case 4:
        		fragmentManager.beginTransaction().replace(R.id.content_frame, venta).commit();
        		break;
        	case 6:
        		fragmentManager.beginTransaction().replace(R.id.content_frame, ajusteP).commit();
        		break;
        	case 7:
        		fragmentManager.beginTransaction().replace(R.id.content_frame, ajusteP).commit();
        		break;
        }

        // update selected item and title, then close the drawer
        mDrawerListView.setItemChecked(position, true);
        mDrawer.closeDrawer(mDrawerListView);
    }


    @Override
    public void setTitle(CharSequence title)
    {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mToggle.onConfigurationChanged(newConfig);
    }

}
