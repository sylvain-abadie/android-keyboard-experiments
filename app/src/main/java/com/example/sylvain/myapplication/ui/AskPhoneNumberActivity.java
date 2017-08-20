package com.example.sylvain.myapplication.ui;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.sylvain.myapplication.R;
import com.example.sylvain.myapplication.utils.KeyboardObserver;

public class AskPhoneNumberActivity extends AppCompatActivity implements KeyboardObserver.OnKeyboardListener {

    private ConstraintLayout rootLayout = null;
    private KeyboardObserver keyboardObserver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_phone_number);
        setupToolbar();
        rootLayout = (ConstraintLayout) findViewById(R.id.root_layout_ask_phone);
        keyboardObserver = new KeyboardObserver(rootLayout, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        rootLayout.getViewTreeObserver().addOnGlobalLayoutListener(keyboardObserver);
    }

    @Override
    protected void onPause() {
        super.onPause();
        rootLayout.getViewTreeObserver().removeGlobalOnLayoutListener(keyboardObserver);
    }

    @Override
    public void onKeyboardOpens() {
        setEditTextBottomMargin(0);
    }

    @Override
    public void onKeyboardCloses(final int keyboardHeightDp) {
        setEditTextBottomMargin(keyboardHeightDp);
    }

    @Override
    public void onBackPressed() {

    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    private void setEditTextBottomMargin(int margin) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(rootLayout);
        constraintSet.setMargin(R.id.input_number_edit_text, ConstraintSet.BOTTOM, margin);
        constraintSet.applyTo(rootLayout);
    }

}
