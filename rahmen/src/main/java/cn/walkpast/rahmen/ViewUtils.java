package cn.walkpast.rahmen;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author: Kern
 * Time: 2018/6/14 14:18
 * Description: This is..
 */

public class ViewUtils {

    public static int[] getScreenSize(Context context) {

        int[] screenSize = new int[2];
        //通过Resources获取
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        screenSize[0] = dm.widthPixels;
        screenSize[1] = dm.heightPixels;

        return screenSize;
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
}
