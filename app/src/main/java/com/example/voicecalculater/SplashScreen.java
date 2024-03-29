package com.example.voicecalculater;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.voicecalculater.Utils.Utils;

public class SplashScreen extends AppCompatActivity {
	
	private final int SPLASH_DISPLAY_LENGTH = 3000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		splashScreen();
		Utils.changeStatusBarColor(getWindow());
		
	}
	
	// TODO :- Methods
	private void splashScreen()
	{
		new Handler().postDelayed(new Runnable(){
			@Override
			public void run() {
				/* Create an Intent that will start the Menu-Activity. */
				Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
				startActivity(mainIntent);
				finish();
			}
		}, SPLASH_DISPLAY_LENGTH);
	}
}
