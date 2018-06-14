package cn.walkpast.rahmenview;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import cn.walkpast.rahmen.OnRahmenListener;
import cn.walkpast.rahmen.RahmenView;

/**
 * Author: Kern
 * Time: 2018/6/14 10:31
 * Description: This is..
 */

public class SplashActivity extends AppCompatActivity {

    private RahmenView mRahmenView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mRahmenView = findViewById(R.id.rahmen_view);
        mRahmenView.setRahmenImage(getDrawable(R.drawable.timg));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 100);
        mRahmenView.setOnRahmenListener(new OnRahmenListener() {
            @Override
            public void onClick(View view) {
                super.onClick(view);
                Toast.makeText(SplashActivity.this, "RahmenView onClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view) {
                super.onLongClick(view);
                Toast.makeText(SplashActivity.this, "RahmenView onLongClick", Toast.LENGTH_SHORT).show();
            }
        });

        String url = "http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg";
        Glide.with(this)
                .load(url)
                .into(mRahmenView.getImageView());
    }

}
