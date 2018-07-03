package cn.walkpast.rahmenview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.walkpast.rahmen.RahmenView;

/**
 * Author: Kern
 * Time: 2018/6/14 10:31
 * Description: This is..
 */

public class PhotoWallActivity extends AppCompatActivity {
    private RahmenView mRahmenView1;
    private RahmenView mRahmenView2;
    private RahmenView mRahmenView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_wall);

        mRahmenView1 = findViewById(R.id.rahmen_view_1);
        mRahmenView2 = findViewById(R.id.rahmen_view_2);
        mRahmenView3 = findViewById(R.id.rahmen_view_3);


        mRahmenView1.setWatermark(this.getResources().getDrawable(R.drawable.ad_lable), RahmenView.WatermarkLocate.TOP_LEFT,50);
        mRahmenView2.setWatermark(this.getResources().getDrawable(R.drawable.ad_lable), RahmenView.WatermarkLocate.TOP_RIGHT,10);
        mRahmenView3.setWatermark(this.getResources().getDrawable(R.drawable.ad_lable), RahmenView.WatermarkLocate.BOTTOM_LEFT,10);
    }

}

