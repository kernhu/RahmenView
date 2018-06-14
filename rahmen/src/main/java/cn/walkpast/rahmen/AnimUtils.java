package cn.walkpast.rahmen;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

/**
 * Author: Kern
 * Time: 2018/6/13 17:51
 * Description: This is..
 */

public class AnimUtils {


    /**
     * AlphaAni----透明度动画代码如下， beginAnimation() 方法中，
     * 我们在3000ms的时间内把一个 LinearLayout 对象 llAlpha 的透明度从0到1，
     * 即从完全透明渐变到完全不透明，然后在 onCreate() 方法中调用 beginAnimation() 方法就能以透明度渐变动画的方式跳转到 AlphaAni :
     *
     * @param view
     * @param duration
     * @param listener
     */
    public static void setAlpha(final View view, int duration, final OnRahmenListener listener) {

        AlphaAnimation animation = new AlphaAnimation(0, 1);
        animation.setDuration(duration);// 设置动画持续时间
        view.startAnimation(animation);// 启动动画
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (listener != null) {
                    listener.onAnimationStart(view, animation);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (listener != null) {
                    listener.onAnimationFinish(view, animation);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    /**
     * RotateAni----旋转动画代码如下，表示把一个 View 对象从起始角度0旋转到360度，
     * 后面的四个参数 RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f 表示以中心位置为旋转支点：
     *
     * @param view
     * @param duration
     * @param listener
     */
    public static void setRotate(View view, int duration, OnRahmenListener listener) {

        RotateAnimation animation = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(duration);
        view.startAnimation(animation);


    }

    /**
     * ScaleAni----缩放动画代码如下，与上面的透明度渐变动画类似，
     * 在创建 ScaleAnimation 缩放动画的对象的时候， ScaleAnimation(0, 2, 0, 2)
     * 接受的四个参数分别是 ScaleAnimation(float fromX, float toX, float fromY, float toY) ：
     *
     * @param view
     * @param duration
     * @param listener
     */
    public static void setScale(final View view, int duration, final OnRahmenListener listener) {

        ScaleAnimation animation = new ScaleAnimation(0, 2, 0, 2);
        animation.setDuration(duration);
        view.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (listener != null) {
                    listener.onAnimationStart(view, animation);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (listener != null) {
                    listener.onAnimationFinish(view, animation);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


}
