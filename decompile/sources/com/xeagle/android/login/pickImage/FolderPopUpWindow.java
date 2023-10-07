package com.xeagle.android.login.pickImage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.cfly.uav_pro.R;
import com.xeagle.android.utils.s;

public class FolderPopUpWindow extends PopupWindow implements View.OnClickListener {
    /* access modifiers changed from: private */
    public ListView listView;
    /* access modifiers changed from: private */
    public OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2);
    }

    public FolderPopUpWindow(Context context, BaseAdapter baseAdapter) {
        super(context);
        final View inflate = View.inflate(context, R.layout.pop_folder, (ViewGroup) null);
        ListView listView2 = (ListView) inflate.findViewById(R.id.listView);
        this.listView = listView2;
        listView2.setAdapter(baseAdapter);
        setContentView(inflate);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setAnimationStyle(0);
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                inflate.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int a2 = s.a(315.0f);
                int height = FolderPopUpWindow.this.listView.getHeight();
                ViewGroup.LayoutParams layoutParams = FolderPopUpWindow.this.listView.getLayoutParams();
                if (height <= a2) {
                    a2 = height;
                }
                layoutParams.height = a2;
                FolderPopUpWindow.this.listView.setLayoutParams(layoutParams);
            }
        });
        inflate.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FolderPopUpWindow.this.dismiss();
                return true;
            }
        });
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                if (FolderPopUpWindow.this.onItemClickListener != null) {
                    FolderPopUpWindow.this.onItemClickListener.onItemClick(adapterView, view, i2, j2);
                }
            }
        });
    }

    private void enterAnimator() {
        ListView listView2 = this.listView;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(listView2, "translationY", new float[]{(float) (-listView2.getHeight()), 0.0f});
        ofFloat.setDuration(400);
        ofFloat.start();
    }

    private void exitAnimator() {
        ListView listView2 = this.listView;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(listView2, "translationY", new float[]{0.0f, (float) (-listView2.getHeight())});
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(400);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                FolderPopUpWindow.super.dismiss();
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                FolderPopUpWindow.this.listView.setVisibility(0);
            }
        });
        ofFloat.start();
    }

    public void dismiss() {
        exitAnimator();
    }

    public void onClick(View view) {
        dismiss();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }

    public void setSelection(int i2) {
        this.listView.setSelection(i2);
    }

    public void showAsDropDown(View view, int i2, int i3, int i4) {
        super.showAsDropDown(view, i2, i3, i4);
        enterAnimator();
    }
}
