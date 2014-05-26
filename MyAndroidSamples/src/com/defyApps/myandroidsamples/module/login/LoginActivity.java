package com.defyApps.myandroidsamples.module.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.defyApps.myandroidsamples.R;

public class LoginActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);
		findViewById(R.id.btn_login).setOnClickListener(this);
		findViewById(R.id.btn_register).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_login){
			
		} else if (v.getId() == R.id.btn_register){
			Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
			startActivity(intent);
		}
	}

}
