package com.example.voicecalculater;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.voicecalculater.Utils.Utils;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

	Button startBtn, guidBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	
	// TODO :- Methods
	private void init()
	{
		startBtn = findViewById(R.id.startBtn);
		startBtn.setOnClickListener(this);
		guidBtn= findViewById(R.id.guideBtn);
		guidBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.startBtn:
				clickToStart();
				break;
			case R.id.guideBtn:
				clickToGuide();
				break;
		}
	}

	public void clickToStart(){
		Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
		startActivity(intent);
	}

	public void clickToGuide(){
		Intent intent = new Intent(getApplicationContext(), InformationActivity.class);
		startActivity(intent);
	}

}
