package cn.walkpast.rahmenview;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import cn.walkpast.rahmen.OnRahmenListener;
import cn.walkpast.rahmen.RahmenView;

/**
 * Author: Kern
 * Time: 2018/6/14 10:31
 * Description: This is..
 */

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvbBackground;
    private TextView mTvbForeground;
    private TextView mTvbSlopeleft;
    private TextView mTvbSloperight;

    private RahmenView mRahmenView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
        setRahmenView();
    }

    private void initView() {

        mTvbBackground = findViewById(R.id.tvb_background);
        mTvbForeground = findViewById(R.id.tvb_foreground);
        mTvbSlopeleft = findViewById(R.id.tvb_slopeleft);
        mTvbSloperight = findViewById(R.id.tvb_sloperight);
        mTvbBackground.setOnClickListener(this);
        mTvbForeground.setOnClickListener(this);
        mTvbSlopeleft.setOnClickListener(this);
        mTvbSloperight.setOnClickListener(this);

        mRahmenView = findViewById(R.id.rahmen_view_ad);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setRahmenView() {

        mRahmenView.setOnRahmenListener(mOnRahmenListener);

        //set  iamge
        //mRahmenView.setRahmenImage(getDrawable(R.drawable.sample_plot_2));
        /**
         * You can  use Glide to load the online picture easily;
         *
         * */

        String url = "http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg";
        Glide.with(this)
                .load(url)
                .placeholder(R.drawable.sample_plot_1)
                .into(mRahmenView.getImageView());

    }

    OnRahmenListener mOnRahmenListener = new OnRahmenListener() {
        @Override
        public void onClick(View view) {
            super.onClick(view);
            Toast.makeText(SplashActivity.this, "onClick", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLongClick(View view) {
            super.onLongClick(view);
            Toast.makeText(SplashActivity.this, "onLongClick", Toast.LENGTH_SHORT).show();
        }
    };

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.tvb_background:

                mRahmenView.setRahmenBackgroud(getDrawable(R.drawable.bg_rahmen_2));

                break;
            case R.id.tvb_foreground:

                mRahmenView.setRahmenForeground(getDrawable(R.drawable.fg_rahmen_1));

                break;
            case R.id.tvb_slopeleft:

                mRahmenView.setRahmenImageRotation(-7);

                break;
            case R.id.tvb_sloperight:

                mRahmenView.setRahmenImageRotation(7);

                break;
        }
    }
}
