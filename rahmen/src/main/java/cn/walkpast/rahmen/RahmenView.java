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

/**
 * Author: Kern
 * Time: 2018/6/13 15:23
 * Description: This is.. a Rahmen for image base PercentFrameLayout
 */

public class RahmenView extends BaseRahmenView {

    private static final String TAG = "RahmenView";
    private OnRahmenListener listener;
    private ImageView mImageView;
    private LayoutParams mImageParams;
    private int mParentWidth;
    private int mParentHeight;

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
        setRahmenImageRotation(getRahmenImageRotation());
        mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        mImageView.bringToFront();
        mImageView.setVisibility(View.GONE);

        /**set size and margin for the iamge*/
        mImageParams = (LayoutParams) mImageView.getLayoutParams();
        //mImageParams.gravity = Gravity.CENTER;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mParentWidth = w;
        mParentHeight = h;
        mImageParams.width = (int) (mParentWidth * getRahmenImageWidth());
        mImageParams.height = (int) (mParentHeight * getRahmenImageHeight());
        mImageParams.topMargin = (int) (mParentHeight * getRahmenImageY());
        mImageParams.leftMargin = (int) (mParentWidth * getRahmenImageX());
        Log.e("sos", "---onSizeChanged-----mParentWidth=" + (mParentWidth * getRahmenImageWidth()) + ";;;mParentHeight=" + (mParentHeight * getRahmenImageHeight()));
        mImageView.setLayoutParams(mImageParams);
        mImageView.invalidate();
        mImageView.setVisibility(View.VISIBLE);

    }

    public ImageView getImageView() {
        return mImageView;
    }

    @Override
    public void setRahmenBackgroud(Drawable rahmenBackgroud) {
        super.setRahmenBackgroud(rahmenBackgroud);
        this.setForeground(null);
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
        mImageParams.height = (int) (mParentHeight * getRahmenImageHeight());
    }

    @Override
    public void setRahmenImageWidth(float rahmenImageWidth) {
        super.setRahmenImageWidth(rahmenImageWidth);
        mImageParams.width = (int) (mParentWidth * getRahmenImageWidth());
        mImageView.invalidate();
    }

    @Override
    public void setRahmenImageX(float rahmenImageX) {
        super.setRahmenImageX(rahmenImageX);
        mImageParams.topMargin = (int) (mParentHeight * getRahmenImageY());
        mImageView.invalidate();
    }

    @Override
    public void setRahmenImageY(float rahmenImageY) {
        super.setRahmenImageY(rahmenImageY);
        mImageParams.leftMargin = (int) (mParentWidth * getRahmenImageX());
        mImageView.invalidate();
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
