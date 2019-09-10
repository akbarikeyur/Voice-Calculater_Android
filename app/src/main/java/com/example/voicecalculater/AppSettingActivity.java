package com.example.voicecalculater;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class AppSettingActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton backBtn;
    RelativeLayout inAppView, privacyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_setting);
        init();
        setStatusBarDesign();

    }

    // TODO :- Methods
    private void init()
    {
        inAppView = findViewById(R.id.inAppView);
        inAppView.setOnClickListener(this);
        privacyView= findViewById(R.id.privacyView);
        privacyView.setOnClickListener(this);
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
            case R.id.inAppView:
                clickToInAppView();
                break;
            case R.id.privacyView:
                clickToPrivacyView();
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    public void clickToInAppView(){

    }

    public void clickToPrivacyView(){

    }


}
