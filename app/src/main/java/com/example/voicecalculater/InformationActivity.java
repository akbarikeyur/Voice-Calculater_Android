package com.example.voicecalculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.voicecalculater.Adapter.GuidanceAdapter;
import com.example.voicecalculater.Utils.Utils;

public class InformationActivity extends AppCompatActivity {
	
	RecyclerView recyclerView;
	GuidanceAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_information);
		
		init();
		registerIds();
		setRecyclerView();
		
	}
	
	
	
	// TODO :- Methods
	
	private void init()
	{
		Utils.changeStatusBarColor(getWindow());
	}
	
	private void registerIds()
	{
		recyclerView = findViewById(R.id.recyclerView);
	}
	
	private void setRecyclerView()
	{
		recyclerView.setHasFixedSize(true);
		adapter = new GuidanceAdapter(InformationActivity.this);
		LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
		mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(mLayoutManager);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		recyclerView.setAdapter(adapter);
		adapter.AddAll();
	}
	
	
	// TODO :- Button Click
	
	public void clickToBack(View view)
	{
		finish();
	}
}
