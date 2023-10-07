package com.xeagle.android.login.common;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public abstract class TFragment extends Fragment {
    private static final Handler handler = new Handler();
    private int containerId;
    private boolean destroyed;

    /* access modifiers changed from: protected */
    public <T extends View> T findView(int i2) {
        return getView().findViewById(i2);
    }

    public int getContainerId() {
        return this.containerId;
    }

    /* access modifiers changed from: protected */
    public final Handler getHandler() {
        return handler;
    }

    /* access modifiers changed from: protected */
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager;
        FragmentActivity activity = getActivity();
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean isDestroyed() {
        return this.destroyed;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.destroyed = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.destroyed = true;
    }

    /* access modifiers changed from: protected */
    public final void postDelayed(final Runnable runnable, long j2) {
        handler.postDelayed(new Runnable() {
            public void run() {
                if (TFragment.this.isAdded()) {
                    runnable.run();
                }
            }
        }, j2);
    }

    /* access modifiers changed from: protected */
    public final void postRunnable(Runnable runnable) {
        postDelayed(runnable, 0);
    }

    public void setContainerId(int i2) {
        this.containerId = i2;
    }

    /* access modifiers changed from: protected */
    public void setTitle(int i2) {
        if (getActivity() != null && (getActivity() instanceof UI)) {
            getActivity().setTitle(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void setToolBar(int i2, int i3, int i4) {
        if (getActivity() != null && (getActivity() instanceof UI)) {
            ((UI) getActivity()).setToolBar(i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void showKeyboard(boolean z2) {
        InputMethodManager inputMethodManager;
        FragmentActivity activity = getActivity();
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null) {
            if (z2) {
                if (activity.getCurrentFocus() == null) {
                    inputMethodManager.toggleSoftInput(2, 0);
                } else {
                    inputMethodManager.showSoftInput(activity.getCurrentFocus(), 0);
                }
            } else if (activity.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
            }
        }
    }
}
