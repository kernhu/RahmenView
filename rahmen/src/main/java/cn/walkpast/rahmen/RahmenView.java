package cn.walkpast.rahmen;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Author: Kern
 * Time: 2018/6/13 15:23
 * Description: This is.. a Rahmen for image base FrameLayout
 */

public class RahmenView extends BaseRahmenView {

    private OnRahmenListener listener;
    private ImageView mImageView;
    private LayoutParams mImageParams;

    public RahmenView(@NonNull Context context) {
        super(context);
    }

    public RahmenView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RahmenView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
        super.initAttrs(context, attrs, defStyleAttr);
        initView();
    }

    protected void initView() {

        LayoutParams mParentParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        /**创建一个ImageView，将iamgeview插入布局*/
        mImageView = new ImageView(getContext());
        //mParentParams.gravity = Gravity.CENTER_HORIZONTAL;
        this.addView(mImageView, mParentParams);
        /**点击事件*/
        mImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(v);
                }
            }
        });
        /**长按事件*/
        mImageView.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (listener != null) {
                    listener.onLongClick(v);
                }
                return false;
            }
        });

        /**插入背景图*/
        setRahmenBackgroud(getRahmenBackgroud());
        /**设置图片、背景、倾斜角度*/
        setRahmenImage(getRahmenImage());
        /**设置图片倾斜角度*/
        setRahmenImageRotation(getRahmenImageRotation());
        mImageView.setScaleType(ImageView.ScaleType.FIT_XY);

        /**设置ImageView位置、宽高、边距*/
        mImageParams = (LayoutParams) mImageView.getLayoutParams();
        //mImageParams.gravity = Gravity.CENTER;
        mImageParams.width = (int) (getScreenSize()[0] * getRahmenImageWidth());
        mImageParams.height = (int) (getScreenSize()[1] * getRahmenImageHeight());
        mImageParams.topMargin = (int) (getScreenSize()[1] * getRahmenImageY());
        mImageParams.leftMargin = (int) (getScreenSize()[0] * getRahmenImageX());
        mImageView.setLayoutParams(mImageParams);
        //动画
        // AnimUtils.setAlpha(mImageView, 1000, listener);
    }

    public ImageView getImageView() {

        invalidate();
        return mImageView;
    }

    @Override
    public void setRahmenBackgroud(Drawable rahmenBackgroud) {
        super.setRahmenBackgroud(rahmenBackgroud);
        this.setBackgroundDrawable(getRahmenBackgroud());
    }

    @Override
    public void setRahmenForeground(Drawable rahmenForeground) {
        super.setRahmenForeground(rahmenForeground);
        this.setForeground(getRahmenBackgroud());
    }

    @Override
    public void setRahmenImage(Drawable rahmenImage) {
        super.setRahmenImage(rahmenImage);
        mImageView.setImageDrawable(rahmenImage);
        mImageView.invalidate();
    }

    @Override
    public void setRahmenImageRotation(float rahmenImageRotation) {
        super.setRahmenImageRotation(rahmenImageRotation);
        mImageView.setRotation(rahmenImageRotation);
        mImageView.invalidate();
    }

    @Override
    public void setRahmenImageHeight(float rahmenImageHeight) {
        super.setRahmenImageHeight(rahmenImageHeight);
        mImageParams.height = (int) (getScreenSize()[1] * getRahmenImageHeight());
        mImageView.invalidate();
    }

    @Override
    public void setRahmenImageWidth(float rahmenImageWidth) {
        super.setRahmenImageWidth(rahmenImageWidth);
        mImageParams.width = (int) (getScreenSize()[0] * getRahmenImageWidth());
        mImageView.invalidate();
    }

    @Override
    public void setRahmenImageX(float rahmenImageX) {
        super.setRahmenImageX(rahmenImageX);
        mImageParams.topMargin = (int) (getScreenSize()[1] * getRahmenImageY());
        mImageView.invalidate();
    }

    @Override
    public void setRahmenImageY(float rahmenImageY) {
        super.setRahmenImageY(rahmenImageY);
        mImageParams.leftMargin = (int) (getScreenSize()[0] * getRahmenImageX());
        mImageView.invalidate();
    }

    public void addOnRahmenListener(OnRahmenListener listener) {
        this.listener = listener;
    }

    public void setOnRahmenListener(OnRahmenListener listener) {
        this.listener = listener;
    }

}
