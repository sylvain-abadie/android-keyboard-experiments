package com.example.sylvain.myapplication.ui.views;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;

/**
 * Created by sylvain on 8/19/17.
 */

public class FixedKeyboardEditText extends AppCompatEditText {
    public FixedKeyboardEditText(Context context) {
        super(context);
    }

    public FixedKeyboardEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FixedKeyboardEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        return keyCode == KeyEvent.KEYCODE_BACK;
    }
}
