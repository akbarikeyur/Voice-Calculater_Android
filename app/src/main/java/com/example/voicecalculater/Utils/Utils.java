package com.example.voicecalculater.Utils;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;

import com.example.voicecalculater.R;

public class Utils {
	
	public static void changeStatusBarColor(Window window)
	{
		window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			window.setStatusBarColor(Color.parseColor("#B3315F"));
		}
	}
	
}
