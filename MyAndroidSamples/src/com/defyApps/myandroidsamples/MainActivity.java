package com.defyApps.myandroidsamples;

import com.defyApps.myandroidsamples.utils.Utils;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set a list view and its adapter
		ListView mainListView = (ListView) findViewById(R.id.mainListView);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.activity_main, R.id.textViewForMainList,
				getResources().getStringArray(R.array.mainListItems));
		mainListView.setAdapter(adapter);
		mainListView.setOnItemClickListener(mainListItemClickListener);
	}
	
	private OnItemClickListener mainListItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			// Catch the item click and process it
			if (position == 0){
				// Tapped on Layouts
				Utils.logMessage(getClass().getSimpleName(), "Tapped on the Layouts item", Log.VERBOSE);
				Intent i = new Intent(MainActivity.this, LayoutsMainActivity.class);
				startActivity(i);
				
			} else if (position == 1){
				// Tapped on Life cycle
				//Utils.logMessage(getClass().getSimpleName(), "Tapped on the Life cycle item", Log.VERBOSE);
				//Intent i = new Intent(MainActivity.this, LifeCycleMainActivity.class);
				//startActivity(i);
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
