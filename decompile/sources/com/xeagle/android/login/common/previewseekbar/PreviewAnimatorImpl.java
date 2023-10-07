package com.xeagle.android.login.common.previewseekbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class PreviewAnimatorImpl extends PreviewAnimator {
    public static final int ALPHA_DURATION = 200;
    private AnimatorListenerAdapter hideListener = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            PreviewAnimatorImpl.this.previewFrameLayout.setVisibility(4);
        }
    };

    public PreviewAnimatorImpl(ViewGroup viewGroup, PreviewApi previewApi, View view, FrameLayout frameLayout, View view2) {
        super(viewGroup, previewApi, view, frameLayout, view2);
    }

    public void hide() {
        this.previewFrameLayout.setAlpha(1.0f);
        this.previewFrameLayout.animate().cancel();
        this.previewFrameLayout.animate().setDuration(200).alpha(0.0f).setListener(this.hideListener);
    }

    public void move() {
        this.previewFrameLayout.setX(getFrameX());
    }

    public void show() {
        move();
        this.previewFrameLayout.setVisibility(0);
        this.previewFrameLayout.setAlpha(0.0f);
        this.previewFrameLayout.animate().cancel();
        this.previewFrameLayout.animate().setDuration(200).alpha(1.0f).setListener((Animator.AnimatorListener) null);
    }
}
