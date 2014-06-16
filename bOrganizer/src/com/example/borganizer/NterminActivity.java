package com.example.borganizer;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.View.OnClickListener;
import android.content.DialogInterface;
import android.app.AlertDialog;


public class NterminActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ntermin);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ntermin, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId())
		{
			case R.id.action_monat: 
			{
			//return true;
				onBackPressed();
			break;
			}
		
			case R.id.action_utermin: 
			{
				onBackPressed();
			//return true;
			Intent intent=new Intent (this,UterminActivity.class);
			overridePendingTransition(0,0);
			startActivity(intent);
			break;
			}
			
			case R.id.action_einstell: 
			{
				onBackPressed();
			//return true;
			Intent intent=new Intent (this,EinstellActivity.class);
			overridePendingTransition(0,0);
			startActivity(intent);
			break;
			}
			
			case R.id.action_ltermin: 
			{
				onBackPressed();
				
			//return true;
			Intent intent=new Intent (this,LterminActivity.class);
			overridePendingTransition(0,0);
			startActivity(intent);
			break;
			}
			
////////////Termin in die Datenbank Speichern
			case R.id.action_save: 
			{
				AlertDialog dlgAlert  = new AlertDialog.Builder(this).create();
				dlgAlert.setTitle("Termin Speichern");
				dlgAlert.setMessage("Durch Klicken der + Taste wird der Termin in die Datenbank gespeichert! ");
				dlgAlert.setButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) 
					{
					// here you can add functions
					}
					});
				dlgAlert.setIcon(R.drawable.ic_launcher);
				dlgAlert.show();
				//onBackPressed();
//////////////HIER WIRD IN DB GESPEICHERT//////////////
			//
			//
			/////////////////////////////////////////
			//Intent intent=new Intent (this,UterminActivity.class);
			//overridePendingTransition(0,0);
			//startActivity(intent);
			break;
			}
			
			case R.id.action_ende: 
			{
			//return true;
			finish();
			break;
			}
			
			
			default:{}
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_ntermin,
					container, false);
			return rootView;
		}
	}

}
