package cn.walkpast.rahmen;

import android.view.View;
import android.view.animation.Animation;

/**
 * Author: Kern
 * Time: 2018/6/13 15:40
 * Description: This is..Rahmen's event
 */

public abstract class OnRahmenListener {


    /**
     * while the image is checked
     *
     * @param view
     */
    public void onClick(View view) {
    }

    /**
     * while the image is long checked
     *
     * @param view
     */
    public void onLongClick(View view) {
    }

    /**
     * while the animation is starting
     *
     * @param view
     * @param animation
     */
    public void onAnimationStart(View view, Animation animation) {
    }

    /**
     * while the animation is finishing
     *
     * @param view
     * @param animation
     */
    public void onAnimationFinish(View view, Animation animation) {
    }
}
