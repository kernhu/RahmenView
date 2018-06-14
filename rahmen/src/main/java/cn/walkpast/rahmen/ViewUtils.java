package cn.walkpast.rahmen;

import android.content.Context;
import android.util.DisplayMetrics;

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

}
