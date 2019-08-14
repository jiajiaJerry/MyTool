package com.jiajia.jerry_core.utils.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.jiajia.jerry_core.app.Tool;

/**
 * @author : jerry
 * @date : 2018/7/14 15:35
 */
public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = Tool.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Tool.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
