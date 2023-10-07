package com.xeagle.android.login.ijkplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MediaController;
import androidx.appcompat.app.ActionBar;
import java.util.ArrayList;
import java.util.Iterator;

public class AndroidMediaController extends MediaController implements IMediaController {
    private ActionBar mActionBar;
    private ArrayList<View> mShowOnceArray = new ArrayList<>();

    public AndroidMediaController(Context context) {
        super(context);
        initView(context);
    }

    public AndroidMediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public AndroidMediaController(Context context, boolean z2) {
        super(context, z2);
        initView(context);
    }

    private void initView(Context context) {
    }

    public void hide() {
        super.hide();
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.c();
        }
        Iterator<View> it2 = this.mShowOnceArray.iterator();
        while (it2.hasNext()) {
            it2.next().setVisibility(8);
        }
        this.mShowOnceArray.clear();
    }

    public void setSupportActionBar(ActionBar actionBar) {
        this.mActionBar = actionBar;
        if (isShowing()) {
            actionBar.b();
        } else {
            actionBar.c();
        }
    }

    public void show() {
        super.show();
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.b();
        }
    }

    public void showOnce(View view) {
        this.mShowOnceArray.add(view);
        view.setVisibility(0);
        show();
    }
}
