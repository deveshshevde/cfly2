package com.xeagle.android.login.common.previewseekbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;

public class PreviewAnimatorLollipopImpl extends PreviewAnimator {
    static final int MORPH_MOVE_DURATION = 200;
    static final int MORPH_REVEAL_DURATION = 150;
    static final int UNMORPH_MOVE_DURATION = 200;
    static final int UNMORPH_UNREVEAL_DURATION = 150;
    /* access modifiers changed from: private */
    public Animator.AnimatorListener hideListener = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            PreviewAnimatorLollipopImpl.this.morphView.setVisibility(4);
            PreviewAnimatorLollipopImpl.this.morphView.animate().setListener((Animator.AnimatorListener) null);
        }
    };
    /* access modifiers changed from: private */
    public boolean mShowing;
    private Animator.AnimatorListener showListener = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            PreviewAnimatorLollipopImpl.this.morphView.animate().setListener((Animator.AnimatorListener) null);
            PreviewAnimatorLollipopImpl.this.startReveal();
            boolean unused = PreviewAnimatorLollipopImpl.this.mShowing = false;
        }
    };

    public PreviewAnimatorLollipopImpl(ViewGroup viewGroup, PreviewApi previewApi, View view, FrameLayout frameLayout, View view2) {
        super(viewGroup, previewApi, view, frameLayout, view2);
    }

    private int getCenterX(View view) {
        return view.getWidth() / 2;
    }

    private int getCenterY(View view) {
        return view.getHeight() / 2;
    }

    private float getMorphEndX() {
        return (getFrameX() + (((float) this.previewFrameLayout.getWidth()) / 2.0f)) - ((float) this.previewApi.getThumbOffset());
    }

    private float getMorphEndY() {
        return (float) ((int) (this.previewFrameLayout.getY() + (((float) this.previewFrameLayout.getHeight()) / 2.0f)));
    }

    /* access modifiers changed from: private */
    public float getMorphStartX() {
        float previewViewStartX = getPreviewViewStartX() + ((float) this.previewApi.getThumbOffset());
        return ((((getPreviewViewEndX() - ((float) this.previewApi.getThumbOffset())) - previewViewStartX) * getWidthOffset(this.previewApi.getProgress())) + previewViewStartX) - ((float) this.previewApi.getThumbOffset());
    }

    /* access modifiers changed from: private */
    public float getMorphStartY() {
        return ((View) this.previewApi).getY() + ((float) this.previewApi.getThumbOffset());
    }

    private int getRadius(View view) {
        return (int) Math.hypot((double) (view.getWidth() / 2), (double) (view.getHeight() / 2));
    }

    /* access modifiers changed from: private */
    public void startReveal() {
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.previewFrameLayout, getCenterX(this.previewFrameLayout), getCenterY(this.previewFrameLayout), (float) (this.morphView.getWidth() * 2), (float) getRadius(this.previewFrameLayout));
        createCircularReveal.setTarget(this.previewFrameLayout);
        createCircularReveal.setDuration(150);
        createCircularReveal.setInterpolator(new AccelerateInterpolator());
        createCircularReveal.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PreviewAnimatorLollipopImpl.this.previewFrameLayout.animate().setListener((Animator.AnimatorListener) null);
                PreviewAnimatorLollipopImpl.this.previewFrameView.setVisibility(4);
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PreviewAnimatorLollipopImpl.this.previewFrameView.setAlpha(1.0f);
                PreviewAnimatorLollipopImpl.this.previewFrameLayout.setVisibility(0);
                PreviewAnimatorLollipopImpl.this.previewFrameView.setVisibility(0);
                PreviewAnimatorLollipopImpl.this.morphView.setVisibility(4);
                PreviewAnimatorLollipopImpl.this.previewFrameView.animate().alpha(0.0f).setDuration(150);
            }
        });
        createCircularReveal.start();
    }

    private void startUnReveal() {
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.previewFrameLayout, getCenterX(this.previewFrameLayout), getCenterY(this.previewFrameLayout), (float) getRadius(this.previewFrameLayout), (float) (this.morphView.getWidth() * 2));
        createCircularReveal.setTarget(this.previewFrameLayout);
        createCircularReveal.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PreviewAnimatorLollipopImpl.this.previewFrameLayout.animate().setListener((Animator.AnimatorListener) null);
                PreviewAnimatorLollipopImpl.this.previewFrameView.setVisibility(4);
                PreviewAnimatorLollipopImpl.this.previewFrameLayout.setVisibility(4);
                PreviewAnimatorLollipopImpl.this.morphView.setVisibility(0);
                PreviewAnimatorLollipopImpl.this.morphView.animate().x(PreviewAnimatorLollipopImpl.this.getMorphStartX()).y(PreviewAnimatorLollipopImpl.this.getMorphStartY()).scaleX(0.0f).scaleY(0.0f).setDuration(200).setInterpolator(new AccelerateInterpolator()).setListener(PreviewAnimatorLollipopImpl.this.hideListener);
            }
        });
        this.previewFrameView.animate().alpha(1.0f).setDuration(150).setInterpolator(new AccelerateInterpolator());
        createCircularReveal.setDuration(150).setInterpolator(new AccelerateInterpolator());
        createCircularReveal.start();
    }

    public void hide() {
        this.mShowing = false;
        this.previewFrameView.setVisibility(0);
        this.previewFrameLayout.setVisibility(0);
        this.morphView.setX(getMorphEndX());
        this.morphView.setY(getMorphEndY());
        this.morphView.setScaleX(4.0f);
        this.morphView.setScaleY(4.0f);
        this.morphView.setVisibility(4);
        this.morphView.animate().cancel();
        this.previewFrameLayout.animate().cancel();
        startUnReveal();
    }

    public void move() {
        this.previewFrameLayout.setX(getFrameX());
        this.morphView.animate().x(this.mShowing ? getMorphEndX() : getMorphStartX());
    }

    public void show() {
        this.mShowing = true;
        move();
        this.previewFrameLayout.setVisibility(4);
        this.previewFrameView.setVisibility(4);
        this.morphView.setY(((View) this.previewApi).getY());
        this.morphView.setX(getMorphStartX());
        this.morphView.setScaleX(0.0f);
        this.morphView.setScaleY(0.0f);
        this.morphView.setVisibility(0);
        this.morphView.animate().x(getMorphEndX()).y(getMorphEndY()).scaleY(4.0f).scaleX(4.0f).setDuration(200).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(this.showListener);
    }
}
