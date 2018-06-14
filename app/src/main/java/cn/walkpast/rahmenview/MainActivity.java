package cn.walkpast.rahmenview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mBtnAd;
    private TextView mBtnPw;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAd = findViewById(R.id.btn_ad);
        mBtnPw = findViewById(R.id.btn_pw);
        mBtnAd.setOnClickListener(this);
        mBtnPw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ad:
                mIntent=new Intent(this,SplashActivity.class);
                break;
            case R.id.btn_pw:
                mIntent=new Intent(this,PhotoWallActivity.class);
                break;
        }
        startActivity(mIntent);
    }
}
