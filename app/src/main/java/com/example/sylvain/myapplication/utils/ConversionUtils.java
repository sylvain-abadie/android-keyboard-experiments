package com.example.sylvain.myapplication.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by sylvain on 8/19/17.
 */

public final class ConversionUtils {
    private ConversionUtils() {
    }

    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }

    public static float pxToDp(Context context, float valueInPx) {
        return valueInPx / context.getResources().getDisplayMetrics().density;
    }
}
