package com.example.borganizer;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
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

import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;

public class UterminActivity extends Activity {
	
	private static final int CM_DELETE_ID = 1;
	  ListView lvData;
	  DB db;
	  SimpleCursorAdapter scAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_utermin);

		if (savedInstanceState == null) 
		{
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
			
///////////Termine aus der DB LADEN////////////////////////////////////////////////////
			AlertDialog dlgAlert  = new AlertDialog.Builder(this).create();
			dlgAlert.setTitle("Termine Laden");
			dlgAlert.setMessage("An dieser Stelle werden die Termine aus der DB geladen");
			dlgAlert.setButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) 
				{
				// here you can add functions
				}
				});
			dlgAlert.setIcon(R.drawable.ic_launcher);
			dlgAlert.show();
////////////////////////////////////////////////////////////			
		
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.utermin, menu);
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
				onBackPressed();
			break;
			}
			
			case R.id.action_ntermin: 
			{	
				onBackPressed();
		           // return true;
		    Intent intent=new Intent (this,NterminActivity.class);
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
//////////////////////////////////////////////////////
	
	    ///////////////////////////////////////////////////////////////////////////
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_utermin,
					container, false);
			return rootView;
		}
	}

}
