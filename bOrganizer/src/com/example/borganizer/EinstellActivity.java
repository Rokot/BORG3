package com.example.borganizer;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.view.View.OnClickListener;

public class EinstellActivity extends Activity implements OnClickListener {
	Button btnlog;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_einstell);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		btnlog=(Button) findViewById(R.id.btnlog);
		btnlog.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v)
	{
		switch(v.getId())
		{
		case R.id.btnlog:
			{
				Intent intent=new Intent (this,LoginActivity.class);
				startActivity(intent);
				
			break;
			}
		default:{break;}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.einstell, menu);
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
		
			case R.id.action_utermin: 
			{
				onBackPressed();
			//return true;
			Intent intent=new Intent (this,UterminActivity.class);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_einstell,
					container, false);
			return rootView;
		}
	}
	


}
