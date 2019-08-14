package com.jiajia.jerry_core.utils.keyboard;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * @author : jerry
 * @date : 2018/7/20 21:40
 */
public class KeyBoardUtil {

    public static void hideKeyBoard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
        if (null != view) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
