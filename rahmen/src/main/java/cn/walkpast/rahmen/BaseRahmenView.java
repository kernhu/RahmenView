package cn.walkpast.rahmen;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.percent.PercentRelativeLayout;
import android.util.AttributeSet;

/**
 * Author: Kern
 * Time: 2018/6/13 16:28
 * Description: This is.. the base layout, init some attrs and views;
 */

public class BaseRahmenView extends PercentRelativeLayout {

    private Drawable mRahmenBackgroud;
    private Drawable mRahmenForeground;
    private Drawable mRahmenImage;
    private float mRahmenImageWidth;
    private float mRahmenImageHeight;
    private float mRahmenImageRotation;
    private float mRahmenImageX;
    private float mRahmenImageY;
    private int mRahmenDuration;
    private boolean mRahmenAnimMode;

    public BaseRahmenView(@NonNull Context context) {
        super(context);
        initAttrs(context, null, 0);
    }

    public BaseRahmenView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs, 0);
    }

    public BaseRahmenView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs, defStyleAttr);
    }

    protected void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {

        /* R.styleable.RahmenView */
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.RahmenView);
        mRahmenBackgroud = array.getDrawable(R.styleable.RahmenView_rhv_backgroud);
        mRahmenForeground = array.getDrawable(R.styleable.RahmenView_rhv_foreground);
        mRahmenImage = array.getDrawable(R.styleable.RahmenView_rhv_image);
        mRahmenImageWidth = array.getFraction(R.styleable.RahmenView_rhv_image_width, 1, 1, 1);
        mRahmenImageHeight = array.getFraction(R.styleable.RahmenView_rhv_image_height, 1, 1, 1);
        mRahmenImageX = array.getFraction(R.styleable.RahmenView_rhv_image_x, 1, 1, 1);
        mRahmenImageY = array.getFraction(R.styleable.RahmenView_rhv_image_y, 1, 1, 1);
        mRahmenImageRotation = array.getFloat(R.styleable.RahmenView_rhv_image_rotation, 0);
        mRahmenDuration = array.getInteger(R.styleable.RahmenView_rhv_duration, 3000);
        mRahmenAnimMode = array.getBoolean(R.styleable.RahmenView_rhv_anim, false);
        array.recycle();

    }

    public Drawable getRahmenBackgroud() {
        return mRahmenBackgroud;
    }

    public void setRahmenBackgroud(Drawable rahmenBackgroud) {
        mRahmenBackgroud = rahmenBackgroud;
    }

    public Drawable getRahmenForeground() {
        return mRahmenForeground;
    }

    public void setRahmenForeground(Drawable rahmenForeground) {
        mRahmenForeground = rahmenForeground;
    }

    public Drawable getRahmenImage() {
        return mRahmenImage;
    }

    public void setRahmenImage(Drawable rahmenImage) {
        mRahmenImage = rahmenImage;
    }

    public float getRahmenImageWidth() {
        return mRahmenImageWidth;
    }

    public void setRahmenImageWidth(float rahmenImageWidth) {
        mRahmenImageWidth = rahmenImageWidth;
    }

    public float getRahmenImageHeight() {
        return mRahmenImageHeight;
    }

    public void setRahmenImageHeight(float rahmenImageHeight) {
        mRahmenImageHeight = rahmenImageHeight;
    }

    public float getRahmenImageRotation() {
        return mRahmenImageRotation;
    }

    public void setRahmenImageRotation(float rahmenImageRotation) {
        mRahmenImageRotation = rahmenImageRotation;
    }

    public float getRahmenImageX() {
        return mRahmenImageX;
    }

    public void setRahmenImageX(float rahmenImageX) {
        mRahmenImageX = rahmenImageX;
    }

    public float getRahmenImageY() {
        return mRahmenImageY;
    }

    public void setRahmenImageY(float rahmenImageY) {
        mRahmenImageY = rahmenImageY;
    }

    public int getRahmenDuration() {
        return mRahmenDuration;
    }

    public void setRahmenDuration(int rahmenDuration) {
        mRahmenDuration = rahmenDuration;
    }

    public boolean getRahmenAnimMode() {
        return mRahmenAnimMode;
    }

    public void setRahmenAnimMode(boolean rahmenAnimMode) {
        mRahmenAnimMode = rahmenAnimMode;
    }

}
