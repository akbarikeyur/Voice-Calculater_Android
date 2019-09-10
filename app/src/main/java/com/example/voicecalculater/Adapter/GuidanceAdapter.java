package com.example.voicecalculater.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.voicecalculater.R;

import java.util.ArrayList;

public class GuidanceAdapter extends RecyclerView.Adapter<GuidanceAdapter.MyViewHolder> {
	
	Context context;
	View view;
	ArrayList<String> operatorList = new ArrayList<>();
	ArrayList<String> codeList = new ArrayList<>();
	ArrayList<String> descriptionList = new ArrayList<>();
	
	public class MyViewHolder extends RecyclerView.ViewHolder
	{
		
		TextView operatorTxtView, codeTxtView, descriptionTxtView ;
		
		public MyViewHolder(View view) {
			super(view);
			operatorTxtView = view.findViewById(R.id.operatorTxtView);
			codeTxtView = view.findViewById(R.id.codeTxtView);
			descriptionTxtView = view.findViewById(R.id.descriptionTxtView);
		}
	}
	
	public GuidanceAdapter(Context context) {
		this.context = context;
	}
	
	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		view = LayoutInflater.from(context).inflate(R.layout.cell_guidance_layout, viewGroup, false);
		return new MyViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
		myViewHolder.operatorTxtView.setText(operatorList.get(i));
		myViewHolder.codeTxtView.setText(codeList.get(i));
		myViewHolder.descriptionTxtView.setText(descriptionList.get(i));
	}
	
	@Override
	public int getItemCount() {
		return operatorList.size();
	}
	
	public void AddAll()
	{
		try
		{
			addData();
			notifyDataSetChanged();
		}
		catch (Exception e)
		{
		
		}
	}
	
	public void addData()
	{
		operatorList.clear();
		codeList.clear();
		descriptionList.clear();
		
		operatorList.add("+");
		codeList.add("Plus" +
				"\n" +
				"( Add )");
		descriptionList.add("5 + 3");
		
		
		operatorList.add("-");
		codeList.add("Minus" +
				"\n" +
				"( Sub )");
		descriptionList.add("3 - 5");
		
		operatorList.add("/");
		codeList.add("Divided by" +
				"\n" +
				"( By, Divide, Divided )");
		descriptionList.add("10 / 5");
		
		operatorList.add("x");
		codeList.add("Multiply by" +
				"\n" +
				"( Multiply, Times, Into, Cross, Asterisk )");
		descriptionList.add("10 x 2");
		
		operatorList.add("^");
		codeList.add("To the power of");
		descriptionList.add("10 ^ 6");
		
		operatorList.add("%");
		codeList.add("Mod");
		descriptionList.add("10 % 2");
		
		operatorList.add("^");
		codeList.add("Raised to" +
				"\n" +
				"( Raise to, Raise )");
		descriptionList.add("10 ^ 3");
		
		operatorList.add(".");
		codeList.add("Point" +
				"\n" +
				"( Dot )");
		descriptionList.add("3.5");
		
		operatorList.add("=");
		codeList.add("Equals to");
		descriptionList.add("-");
		
		operatorList.add("%");
		codeList.add("Percent");
		descriptionList.add("10 % 5");
		
		operatorList.add("(");
		codeList.add("Open parenthesis" +
				"\n" +
				"( Open bracket )");
		descriptionList.add("-");
		
		operatorList.add(")");
		codeList.add("Close parenthesis" +
				"\n" +
				"( Close bracket )");
		descriptionList.add("-");
		
		operatorList.add("-");
		codeList.add("Negative");
		descriptionList.add("-3");
		
		operatorList.add("^");
		codeList.add("Cube" +
				"\n" +
				"( Cube, Cubed )");
		descriptionList.add("3 x 3 x 3");
		
		operatorList.add("Pi");
		codeList.add("3.14");
		descriptionList.add("-");
		
	}
	

}
