package cn.walkpast.rahmen;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Author: Kern
 * Time: 2018/6/13 15:23
 * Description: This is.. a Rahmen for image base PercentFrameLayout
 */

public class RahmenView extends BaseRahmenView {

    private static final String TAG = "RahmenView";
    private OnRahmenListener listener;
    private ImageView mImageView;
    private ImageView mWatermarkView;
    private int mParentWidth;
    private int mParentHeight;

    /**
     * watermark location
     */
    public enum WatermarkLocate {

        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }

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

    public static int[] getParentSize(View view) {

        int[] screenSize = new int[2];
        //获取SingleTouchView所在父布局的中心点
        ViewGroup mViewGroup = (ViewGroup) view.getParent();
        if (null != mViewGroup) {
            screenSize[0] = mViewGroup.getWidth();
            screenSize[1] = mViewGroup.getHeight();
        }
        return screenSize;
    }

    protected void initView() {

        LayoutParams mParentParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        /** create a imageview and add into PercentFrameLayout*/
        mImageView = new ImageView(getContext());
        mImageView.setId(R.id.id_rahmen_image);
        setRahmenImageRotation(getRahmenImageRotation());

        //mParentParams.gravity = Gravity.CENTER_HORIZONTAL;
        this.addView(mImageView, mParentParams);
        /**event callback*/
        mImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(v);
                }
            }
        });
        mImageView.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (listener != null) {
                    listener.onLongClick(v);
                }
                return false;
            }
        });

        /**set backgroud and foreground */
        if (getRahmenBackgroud() != null) {
            setRahmenBackgroud(getRahmenBackgroud());
        } else {
            setRahmenForeground(getRahmenForeground());
        }

        /**set the image for the ImageView*/
        setRahmenImage(getRahmenImage());
        /**set the rotation the value(0~360,0~-360)*/
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mImageView.bringToFront();
        mImageView.setVisibility(View.GONE);

        /**set size and margin for the iamge*/


        /** give a watermark in the image*/
        mWatermarkView = new ImageView(getContext());
        mWatermarkView.setVisibility(View.GONE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mParentWidth = w;
        mParentHeight = h;

        mImageView.setVisibility(View.VISIBLE);
        setChildMargins((int) (mParentWidth * getRahmenImageX()), (int) (mParentHeight * getRahmenImageY()));
        setChildSize((int) (mParentWidth * getRahmenImageWidth()), (int) (mParentHeight * getRahmenImageHeight()));
    }

    /**
     * @param left
     * @param top
     */
    private void setChildMargins(final int left, final int top) {

        mImageView.post(new Runnable() {
            @Override
            public void run() {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(left, top, 0, 0);
                mImageView.setLayoutParams(layoutParams);
            }
        });

    }

    /**
     * @param width
     * @param height
     */
    private void setChildSize(final int width, final int height) {

        mImageView.post(new Runnable() {
            @Override
            public void run() {
                ViewGroup.LayoutParams lp = mImageView.getLayoutParams();
                lp.width = width;
                lp.height = height;
                mImageView.setLayoutParams(lp);
            }
        });
    }

    public ImageView getImageView() {
        return mImageView;
    }


    public void setWatermark(Drawable watermark, WatermarkLocate locate, int[] margin) {

        mWatermarkView.setVisibility(View.VISIBLE);
        mWatermarkView.setImageDrawable(watermark);
        mWatermarkView.setRotation(getRahmenImageRotation());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(margin[0], margin[1], margin[2], margin[3]);
        switch (locate) {
            case TOP_LEFT:
                layoutParams.addRule(RelativeLayout.ALIGN_TOP, R.id.id_rahmen_image);
                layoutParams.addRule(RelativeLayout.ALIGN_LEFT, R.id.id_rahmen_image);
                break;
            case TOP_RIGHT:
                layoutParams.addRule(RelativeLayout.ALIGN_TOP, R.id.id_rahmen_image);
                layoutParams.addRule(RelativeLayout.ALIGN_RIGHT, R.id.id_rahmen_image);
                break;
            case BOTTOM_LEFT:
                layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.id_rahmen_image);
                layoutParams.addRule(RelativeLayout.ALIGN_LEFT, R.id.id_rahmen_image);
                break;
            case BOTTOM_RIGHT:
                layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.id_rahmen_image);
                layoutParams.addRule(RelativeLayout.ALIGN_RIGHT, R.id.id_rahmen_image);
                break;
        }
        mWatermarkView.setLayoutParams(layoutParams);
        this.addView(mWatermarkView);

    }

    @Override
    public void setRahmenBackgroud(Drawable rahmenBackgroud) {
        super.setRahmenBackgroud(rahmenBackgroud);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.setForeground(null);
        } else {
            Log.e(TAG, "the version is under 6.0");
        }
        this.setBackgroundDrawable(getRahmenBackgroud());
    }

    @Override
    public void setRahmenForeground(Drawable rahmenForeground) {
        super.setRahmenForeground(rahmenForeground);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.setBackground(null);
            this.setForeground(getRahmenForeground());
        } else {
            Log.e(TAG, "the version is under 6.0");
        }
    }

    @Override
    public void setRahmenImage(Drawable rahmenImage) {
        super.setRahmenImage(rahmenImage);
        mImageView.setImageDrawable(rahmenImage);
    }

    @Override
    public void setRahmenImageRotation(float rahmenImageRotation) {
        super.setRahmenImageRotation(rahmenImageRotation);
        mImageView.setRotation(rahmenImageRotation);
    }

    @Override
    public void setRahmenImageHeight(float rahmenImageHeight) {
        super.setRahmenImageHeight(rahmenImageHeight);
        setChildSize((int) (mParentHeight * getRahmenImageWidth()), (int) (mParentHeight * rahmenImageHeight));
    }

    @Override
    public void setRahmenImageWidth(float rahmenImageWidth) {
        super.setRahmenImageWidth(rahmenImageWidth);
        setChildSize((int) (mParentHeight * rahmenImageWidth), (int) (mParentHeight * getRahmenImageHeight()));
    }

    @Override
    public void setRahmenImageX(float rahmenImageX) {
        super.setRahmenImageX(rahmenImageX);
        setChildMargins((int) (mParentHeight * rahmenImageX), (int) (mParentHeight * getRahmenImageY()));
    }

    @Override
    public void setRahmenImageY(float rahmenImageY) {
        super.setRahmenImageY(rahmenImageY);
        setChildMargins((int) (mParentHeight * getRahmenImageX()), (int) (mParentHeight * rahmenImageY));
    }


    public void addOnRahmenListener(OnRahmenListener listener) {
        this.listener = listener;
        if (getRahmenAnimMode()) {
            AnimUtils.setAlpha(mImageView, getRahmenDuration(), listener);
        }
    }

    public void setOnRahmenListener(OnRahmenListener listener) {
        this.listener = listener;
        if (getRahmenAnimMode()) {
            AnimUtils.setAlpha(mImageView, getRahmenDuration(), listener);
        }
    }

}
