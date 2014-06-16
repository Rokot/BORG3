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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Build;
import android.content.Intent;

public class LoginActivity extends Activity implements OnClickListener{
	Button btnAnmelden;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		btnAnmelden=(Button) findViewById(R.id.btnAnmelden);
		btnAnmelden.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		switch(v.getId())
		{
		case R.id.btnAnmelden:
			{/*
				Intent intent=new Intent (this,LoginActivity.class);
				startActivity(intent);*/
				
				AlertDialog dlgAlert  = new AlertDialog.Builder(this).create();
				dlgAlert.setTitle("Anmelden");
				dlgAlert.setMessage("Durch Klicken dieser Taste wird verglichen ob ein Nutzer mit diesen Anmeldedaten in der Datenbank exestiert. Bei einer Erfolgreicher Anmeldung werden zu diesem Benutzer zugehörige Termine aus der DB geladen ");
				dlgAlert.setButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) 
					{
				
					}
					});
				dlgAlert.setIcon(R.drawable.ic_launcher);
				dlgAlert.show();
			break;
			}
		default:{break;}
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_login,
					container, false);
			return rootView;
		}
	}

}
