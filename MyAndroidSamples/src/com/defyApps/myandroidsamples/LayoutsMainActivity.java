package com.defyApps.myandroidsamples;

import com.defyApps.myandroidsamples.R;
import com.defyApps.myandroidsamples.ui.layouts.LinearLayoutHorizActivity;
import com.defyApps.myandroidsamples.ui.layouts.LinearLayoutVerticalActivity;
import com.defyApps.myandroidsamples.ui.layouts.RelativeLayoutActivity;
import com.defyApps.myandroidsamples.ui.layouts.TableLayoutActivity;
import com.defyApps.myandroidsamples.utils.Utils;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class LayoutsMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layouts_main);

		ActionBar aBar = getActionBar();
		aBar.setHomeButtonEnabled(true);
		aBar.setDisplayHomeAsUpEnabled(true);
		
		ListView layoutsListView = (ListView) findViewById(R.id.layoutsListView);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.activity_layouts_main, R.id.textViewLayouts,
				getResources().getStringArray(R.array.layoutTypes));
		layoutsListView.setAdapter(adapter);

		layoutsListView.setOnItemClickListener(layoutsItemClickListner);
	}

	private OnItemClickListener layoutsItemClickListner = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			if (position == 0) {
				// Tapped on the linear layout(Horizontal)
				Intent  i = new Intent(LayoutsMainActivity.this, LinearLayoutHorizActivity.class);
				startActivity(i);
			} else if (position == 1) {
				// Tapped on the linear layout(Vertical)
				Intent  i = new Intent(LayoutsMainActivity.this, LinearLayoutVerticalActivity.class);
				startActivity(i);
			} else if (position == 2) {
				// Tapped on the Relative layout
				Intent  i = new Intent(LayoutsMainActivity.this, RelativeLayoutActivity.class);
				startActivity(i);
			} else if (position == 3) {
				// Tapped on the Table layout
				Intent  i = new Intent(LayoutsMainActivity.this, TableLayoutActivity.class);
				startActivity(i);
			} else if (position == 4) {
				// Tapped on the Grid layout
			} else if (position == 5) {
				// Tapped on the Frame layout
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layouts_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Utils.logMessage(getClass().getSimpleName(), "Tapped on Action bar item", Log.VERBOSE);
		switch (item.getItemId()) {
			case android.R.id.home:
				this.finish();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
}
