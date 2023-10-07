package com.xeagle.android.login.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public abstract class LazyLoadFragment extends Fragment {
    protected final String TAG = "LazyLoadFragment";
    protected boolean isInit = false;
    protected boolean isLoad = false;
    private View view;

    private void isCanLoadData() {
        if (this.isInit) {
            if (getUserVisibleHint()) {
                lazyLoad();
                this.isLoad = true;
            } else if (this.isLoad) {
                stopLoad();
            }
        }
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findViewById(int i2) {
        return getContentView().findViewById(i2);
    }

    /* access modifiers changed from: protected */
    public View getContentView() {
        return this.view;
    }

    /* access modifiers changed from: protected */
    public abstract void lazyLoad();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(setContentView(), viewGroup, false);
        this.isInit = true;
        isCanLoadData();
        return this.view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.isInit = false;
        this.isLoad = false;
    }

    /* access modifiers changed from: protected */
    public abstract int setContentView();

    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        isCanLoadData();
    }

    /* access modifiers changed from: protected */
    public void showToast(String str) {
        if (!TextUtils.isEmpty(str)) {
            Toast.makeText(getContext(), str, 0).show();
        }
    }

    /* access modifiers changed from: protected */
    public void stopLoad() {
    }
}
