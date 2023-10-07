package com.xeagle.android.login.common.previewseekbar;

import android.widget.FrameLayout;

public interface PreviewApi {

    public interface OnPreviewChangeListener {
        void onPreview(PreviewApi previewApi, int i2, boolean z2);

        void onStartPreview(PreviewApi previewApi, int i2);

        void onStopPreview(PreviewApi previewApi, int i2);
    }

    void addOnPreviewChangeListener(OnPreviewChangeListener onPreviewChangeListener);

    void attachPreviewFrameLayout(FrameLayout frameLayout);

    int getDefaultColor();

    int getMax();

    int getProgress();

    int getThumbOffset();

    void hidePreview();

    boolean isShowingPreview();

    void removeOnPreviewChangeListener(OnPreviewChangeListener onPreviewChangeListener);

    void setPreviewColorResourceTint(int i2);

    void setPreviewColorTint(int i2);

    void setPreviewLoader(PreviewLoader previewLoader);

    void showPreview();
}
