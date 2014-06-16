package com.example.borganizer;

import java.util.Calendar;

import com.example.borganizer.R;
import com.example.borganizer.NterminActivity;

import android.content.Intent;
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

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId())
		{
			case R.id.action_ntermin: 
			{
				
		           // return true;
		    Intent intent=new Intent (this,NterminActivity.class);
		    startActivity(intent);
		    overridePendingTransition(0,0);
		    break;
			}
		
			case R.id.action_utermin: 
			{
			//return true;
			Intent intent=new Intent (this,UterminActivity.class);
			startActivity(intent);
			overridePendingTransition(0,0);
			break;
			}
			
			case R.id.action_einstell: 
			{
			//return true;
			Intent intent=new Intent (this,EinstellActivity.class);
			startActivity(intent);
			overridePendingTransition(0,0);
			break;
			}
			
			case R.id.action_ltermin: 
			{
			//return true;
			Intent intent=new Intent (this,LterminActivity.class);
			startActivity(intent);
			overridePendingTransition(0,0);
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
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
