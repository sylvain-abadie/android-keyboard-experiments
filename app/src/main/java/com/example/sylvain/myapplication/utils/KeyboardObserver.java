package com.example.sylvain.myapplication.utils;

import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewTreeObserver;

import static com.example.sylvain.myapplication.utils.ConversionUtils.dpToPx;

/**
 * Created by sylvain on 8/19/17.
 */

public class KeyboardObserver implements ViewTreeObserver.OnGlobalLayoutListener {

    public interface OnKeyboardListener {
        void onKeyboardOpens();

        void onKeyboardCloses(final int keyboardHeightDp);
    }

    private static final int KEYBOARD_MIN_HEIGHT_TRIGGER_DP = 20;
    private int keyboardMeasuredHeight = -1;
    private boolean isKeyboardVisible = false;
    private View rootView = null;
    private OnKeyboardListener listener = null;
    private float keyboardMinHeightTriggerPx = -1f;

    public KeyboardObserver(@NonNull View rootView, @NonNull OnKeyboardListener listener) {
        this.rootView = rootView;
        this.listener = listener;
        keyboardMinHeightTriggerPx = dpToPx(rootView.getContext(), KEYBOARD_MIN_HEIGHT_TRIGGER_DP);
    }

    @Override
    public void onGlobalLayout() {
        Rect r = new Rect();
        rootView.getWindowVisibleDisplayFrame(r);

        int screenHeight = rootView.getRootView().getHeight();
        int keyboardHeight = screenHeight - r.bottom;

        // We must substract the height of the navigation bar after lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            keyboardHeight -= (int) dpToPx(rootView.getContext(), 48f);
        }

        if (!isKeyboardVisible && keyboardHeight > keyboardMinHeightTriggerPx) {
            keyboardMeasuredHeight = keyboardHeight;
            isKeyboardVisible = true;
            if (listener != null) {
                listener.onKeyboardOpens();
            }
        } else if (isKeyboardVisible && keyboardHeight < keyboardMinHeightTriggerPx) {
            isKeyboardVisible = false;
            if (listener != null) {
                listener.onKeyboardCloses(keyboardMeasuredHeight);
            }
        }
    }
}
