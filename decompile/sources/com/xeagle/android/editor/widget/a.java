package com.xeagle.android.editor.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.cfly.uav_pro.R;
import com.xeagle.android.editor.widget.a;

public class a extends PopupWindow {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f22946a;

    /* renamed from: b  reason: collision with root package name */
    private CheckedTextView f22947b;

    /* renamed from: c  reason: collision with root package name */
    private CheckedTextView f22948c;

    /* renamed from: d  reason: collision with root package name */
    private CheckedTextView f22949d;

    /* renamed from: com.xeagle.android.editor.widget.a$a  reason: collision with other inner class name */
    public interface C0145a {
        void onItemClick(int i2);
    }

    public a(Activity activity, C0145a aVar) {
        super(activity);
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.editor_pop_layout, (ViewGroup) null);
        this.f22946a = (LinearLayout) inflate.findViewById(R.id.pop_ll);
        CheckedTextView checkedTextView = (CheckedTextView) inflate.findViewById(R.id.tv_editor_all);
        this.f22947b = checkedTextView;
        checkedTextView.setOnClickListener(new View.OnClickListener(aVar) {
            public final /* synthetic */ a.C0145a f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                a.this.c(this.f$1, view);
            }
        });
        CheckedTextView checkedTextView2 = (CheckedTextView) inflate.findViewById(R.id.tv_editor_free);
        this.f22948c = checkedTextView2;
        checkedTextView2.setOnClickListener(new View.OnClickListener(aVar) {
            public final /* synthetic */ a.C0145a f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                a.this.b(this.f$1, view);
            }
        });
        CheckedTextView checkedTextView3 = (CheckedTextView) inflate.findViewById(R.id.tv_editor_oneKey);
        this.f22949d = checkedTextView3;
        checkedTextView3.setOnClickListener(new View.OnClickListener(aVar) {
            public final /* synthetic */ a.C0145a f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                a.this.a(this.f$1, view);
            }
        });
        setContentView(inflate);
        setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.roundcorner));
        setWidth(activity.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.dp_100));
        setHeight(-2);
        setFocusable(false);
    }

    private void a() {
        this.f22947b.setChecked(false);
        this.f22948c.setChecked(false);
        this.f22949d.setChecked(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(C0145a aVar, View view) {
        a(2);
        if (aVar != null) {
            aVar.onItemClick(2);
        }
    }

    private void b() {
        LinearLayout linearLayout = this.f22946a;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", new float[]{(float) (-linearLayout.getHeight()), 0.0f});
        ofFloat.setDuration(400);
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(C0145a aVar, View view) {
        a(1);
        if (aVar != null) {
            aVar.onItemClick(1);
        }
    }

    private void c() {
        LinearLayout linearLayout = this.f22946a;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", new float[]{0.0f, (float) (-linearLayout.getHeight())});
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(400);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                a.super.dismiss();
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                a.this.f22946a.setVisibility(0);
            }
        });
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(C0145a aVar, View view) {
        a(0);
        if (aVar != null) {
            aVar.onItemClick(0);
        }
    }

    public void a(int i2) {
        CheckedTextView checkedTextView;
        a();
        if (i2 == 0) {
            checkedTextView = this.f22947b;
        } else if (i2 == 1) {
            checkedTextView = this.f22948c;
        } else if (i2 == 2) {
            checkedTextView = this.f22949d;
        } else {
            return;
        }
        checkedTextView.setChecked(true);
    }

    public void dismiss() {
        c();
    }

    public void showAsDropDown(View view, int i2, int i3, int i4) {
        super.showAsDropDown(view, i2, i3, i4);
        b();
    }
}
