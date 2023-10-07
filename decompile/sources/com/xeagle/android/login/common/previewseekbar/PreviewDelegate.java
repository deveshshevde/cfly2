package com.xeagle.android.login.common.previewseekbar;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.b;
import androidx.core.graphics.drawable.a;
import com.xeagle.android.login.common.previewseekbar.PreviewApi;

public class PreviewDelegate implements PreviewApi.OnPreviewChangeListener {
    private PreviewAnimator animator;
    private boolean enabled;
    private View morphView;
    private PreviewApi previewApi;
    private FrameLayout previewFrameLayout;
    private View previewFrameView;
    private PreviewLoader previewLoader;
    private ViewGroup previewParent;
    private int scrubberColor;
    private boolean setup;
    private boolean showing;
    private boolean startTouch;

    public PreviewDelegate(PreviewApi previewApi2, int i2) {
        this.previewApi = previewApi2;
        previewApi2.addOnPreviewChangeListener(this);
        this.scrubberColor = i2;
    }

    private FrameLayout findFrameLayout(ViewGroup viewGroup, int i2) {
        if (!(i2 == -1 || viewGroup == null)) {
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt.getId() == i2 && (childAt instanceof FrameLayout)) {
                    return (FrameLayout) childAt;
                }
            }
        }
        return null;
    }

    public boolean isSetup() {
        return this.setup;
    }

    public void onLayout(ViewGroup viewGroup, int i2) {
        if (!this.setup) {
            this.previewParent = viewGroup;
        }
    }

    public void onPreview(PreviewApi previewApi2, int i2, boolean z2) {
        if (this.setup && this.enabled) {
            this.animator.move();
            if (!this.showing) {
                boolean z3 = this.startTouch;
            }
            PreviewLoader previewLoader2 = this.previewLoader;
            if (previewLoader2 != null) {
                previewLoader2.loadPreview((long) i2, (long) previewApi2.getMax());
            }
        }
        this.startTouch = false;
    }

    public void onStartPreview(PreviewApi previewApi2, int i2) {
        this.startTouch = true;
    }

    public void onStopPreview(PreviewApi previewApi2, int i2) {
        if (this.showing) {
            this.animator.hide();
        }
        this.showing = false;
        this.startTouch = false;
    }

    public void setEnabled(boolean z2) {
    }

    public void setPreviewColorResourceTint(int i2) {
        setPreviewColorTint(b.c(this.previewParent.getContext(), i2));
    }

    public void setPreviewColorTint(int i2) {
        Drawable g2 = a.g(this.morphView.getBackground());
        a.a(g2, i2);
        this.morphView.setBackground(g2);
        this.previewFrameView.setBackgroundColor(i2);
    }

    public void setPreviewLoader(PreviewLoader previewLoader2) {
        this.previewLoader = previewLoader2;
    }
}
