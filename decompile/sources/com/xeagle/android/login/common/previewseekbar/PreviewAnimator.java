package com.xeagle.android.login.common.previewseekbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public abstract class PreviewAnimator {
    View morphView;
    ViewGroup parent;
    PreviewApi previewApi;
    FrameLayout previewFrameLayout;
    View previewFrameView;

    public PreviewAnimator(ViewGroup viewGroup, PreviewApi previewApi2, View view, FrameLayout frameLayout, View view2) {
        this.parent = viewGroup;
        this.previewApi = previewApi2;
        this.morphView = view;
        this.previewFrameLayout = frameLayout;
        this.previewFrameView = view2;
    }

    /* access modifiers changed from: package-private */
    public float getFrameX() {
        float widthOffset = getWidthOffset(this.previewApi.getProgress());
        float left = (float) this.previewFrameLayout.getLeft();
        float width = (float) ((this.parent.getWidth() - ((ViewGroup.MarginLayoutParams) this.previewFrameLayout.getLayoutParams()).rightMargin) - this.previewFrameLayout.getWidth());
        float previewViewStartX = getPreviewViewStartX() + ((float) this.previewApi.getThumbOffset());
        float previewViewEndX = ((((getPreviewViewEndX() - ((float) this.previewApi.getThumbOffset())) - previewViewStartX) * widthOffset) + previewViewStartX) - (((float) this.previewFrameLayout.getWidth()) / 2.0f);
        return previewViewEndX < left ? left : previewViewEndX > width ? width : previewViewEndX;
    }

    /* access modifiers changed from: package-private */
    public float getPreviewViewEndX() {
        return getPreviewViewStartX() + ((float) ((View) this.previewApi).getWidth());
    }

    /* access modifiers changed from: package-private */
    public float getPreviewViewStartX() {
        return ((View) this.previewApi).getX();
    }

    /* access modifiers changed from: package-private */
    public float getWidthOffset(int i2) {
        return ((float) i2) / ((float) this.previewApi.getMax());
    }

    public abstract void hide();

    public abstract void move();

    public abstract void show();
}
