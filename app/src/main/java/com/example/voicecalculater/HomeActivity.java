package com.example.voicecalculater;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button voiceBtn, manuallyBtn, settingBtn;
    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        setStatusBarDesign();
    }

    // TODO :- Methods
    private void init()
    {
        voiceBtn = findViewById(R.id.voiceBtn);
        voiceBtn.setOnClickListener(this);
        manuallyBtn= findViewById(R.id.manuallyBtn);
        manuallyBtn.setOnClickListener(this);
        settingBtn= findViewById(R.id.settingBtn);
        settingBtn.setOnClickListener(this);
        backBtn= findViewById(R.id.back);
        backBtn.setOnClickListener(this);
    }

    public void setStatusBarDesign()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusBar, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusBar));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.voiceBtn:
                clickToCalculator(1);
                break;
            case R.id.manuallyBtn:
                clickToCalculator(0);
                break;
            case R.id.settingBtn:
                clickToSetting();
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    public void clickToCalculator(int type){
        Intent intent = new Intent(getApplicationContext(), CalculatorActivity.class);
        intent.putExtra("isVoice", type);
        startActivity(intent);
    }

    public void clickToSetting(){
        Intent intent = new Intent(getApplicationContext(), AppSettingActivity.class);
        startActivity(intent);
    }
}
