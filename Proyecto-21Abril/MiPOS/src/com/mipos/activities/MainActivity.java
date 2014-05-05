package com.mipos.activities;

import com.androidbegin.menuviewpagertutorial.R;




import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class MainActivity  extends Activity {
	
	SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
	boolean isFirstTime = prefs.getBoolean("firstTime", true);
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activate_terminal);
		
		
		
		/*if(isFirstTime){
			SharedPreferences.Editor editor = prefs.edit();
			editor.putBoolean("firstTime", false);
			editor.commit();
			Intent terminalActivate = new Intent (this, TerminalActivate.class);
			startActivity(terminalActivate);
		}else{
			Intent login = new Intent (this, Login.class );
			startActivity(login);
		}
*/	}

	

}
