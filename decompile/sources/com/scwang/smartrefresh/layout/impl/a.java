package com.scwang.smartrefresh.layout.impl;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.legacy.widget.Space;
import androidx.viewpager.widget.ViewPager;
import ja.e;
import ja.i;
import ja.k;
import java.util.LinkedList;
import java.util.List;
import jc.b;
import t.m;
import t.q;

public class a implements ValueAnimator.AnimatorUpdateListener, e, jb.a {

    /* renamed from: a  reason: collision with root package name */
    protected View f12179a;

    /* renamed from: b  reason: collision with root package name */
    protected View f12180b;

    /* renamed from: c  reason: collision with root package name */
    protected View f12181c;

    /* renamed from: d  reason: collision with root package name */
    protected View f12182d;

    /* renamed from: e  reason: collision with root package name */
    protected View f12183e;

    /* renamed from: f  reason: collision with root package name */
    protected int f12184f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f12185g = true;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f12186h = true;

    /* renamed from: i  reason: collision with root package name */
    protected b f12187i = new b();

    public a(View view) {
        this.f12181c = view;
        this.f12180b = view;
        this.f12179a = view;
    }

    public ValueAnimator.AnimatorUpdateListener a(int i2) {
        View view = this.f12181c;
        if (view == null || i2 == 0) {
            return null;
        }
        if ((i2 >= 0 || !b.b(view, 1)) && (i2 <= 0 || !b.b(this.f12181c, -1))) {
            return null;
        }
        this.f12184f = i2;
        return this;
    }

    public View a() {
        return this.f12179a;
    }

    /* access modifiers changed from: protected */
    public View a(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF2 = new PointF();
            while (childCount > 0) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (!b.a(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    childCount--;
                } else if (!(childAt instanceof ViewPager) && b.c(childAt)) {
                    return childAt;
                } else {
                    pointF.offset(pointF2.x, pointF2.y);
                    View a2 = a(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return a2;
                }
            }
        }
        return view2;
    }

    /* access modifiers changed from: protected */
    public View a(View view, boolean z2) {
        LinkedList linkedList = new LinkedList();
        List list = linkedList;
        list.add(view);
        View view2 = null;
        while (list.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z2 || view3 != view) && b.c(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        list.add(viewGroup.getChildAt(i2));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r6, int r7, int r8) {
        /*
            r5 = this;
            r0 = 1
            r1 = -1
            r2 = 0
            r3 = 0
            if (r7 == r1) goto L_0x0021
            android.view.View r4 = r5.f12180b
            android.view.View r7 = r4.findViewById(r7)
            if (r7 == 0) goto L_0x0021
            if (r6 <= 0) goto L_0x0016
            float r4 = (float) r6
            r7.setTranslationY(r4)
            r7 = 1
            goto L_0x0022
        L_0x0016:
            float r4 = r7.getTranslationY()
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0021
            r7.setTranslationY(r3)
        L_0x0021:
            r7 = 0
        L_0x0022:
            if (r8 == r1) goto L_0x003e
            android.view.View r1 = r5.f12180b
            android.view.View r8 = r1.findViewById(r8)
            if (r8 == 0) goto L_0x003e
            if (r6 >= 0) goto L_0x0033
            float r7 = (float) r6
            r8.setTranslationY(r7)
            goto L_0x003f
        L_0x0033:
            float r0 = r8.getTranslationY()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x003e
            r8.setTranslationY(r3)
        L_0x003e:
            r0 = r7
        L_0x003f:
            android.view.View r7 = r5.f12180b
            if (r0 != 0) goto L_0x0048
            float r8 = (float) r6
            r7.setTranslationY(r8)
            goto L_0x004b
        L_0x0048:
            r7.setTranslationY(r3)
        L_0x004b:
            android.view.View r7 = r5.f12182d
            if (r7 == 0) goto L_0x0057
            int r8 = java.lang.Math.max(r2, r6)
            float r8 = (float) r8
            r7.setTranslationY(r8)
        L_0x0057:
            android.view.View r7 = r5.f12183e
            if (r7 == 0) goto L_0x0063
            int r6 = java.lang.Math.min(r2, r6)
            float r6 = (float) r6
            r7.setTranslationY(r6)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.impl.a.a(int, int, int):void");
    }

    public void a(MotionEvent motionEvent) {
        b bVar;
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset((float) (-this.f12179a.getLeft()), (float) (-this.f12179a.getTop()));
        View view = this.f12181c;
        View view2 = this.f12179a;
        if (view != view2) {
            this.f12181c = a(view2, pointF, view);
        }
        if (this.f12181c == this.f12179a) {
            bVar = this.f12187i;
            pointF = null;
        } else {
            bVar = this.f12187i;
        }
        bVar.f21578a = pointF;
    }

    /* access modifiers changed from: protected */
    public void a(View view, i iVar) {
        boolean isInEditMode = this.f12179a.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof q) || (view2 instanceof m))) {
                break;
            }
            view = a(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!isInEditMode) {
                jc.a.a(view, iVar, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.f12181c = view2;
        }
    }

    public void a(i iVar, View view, View view2) {
        a(this.f12179a, iVar);
        if (view != null || view2 != null) {
            this.f12182d = view;
            this.f12183e = view2;
            FrameLayout frameLayout = new FrameLayout(this.f12179a.getContext());
            int indexOfChild = iVar.a().getLayout().indexOfChild(this.f12179a);
            iVar.a().getLayout().removeView(this.f12179a);
            frameLayout.addView(this.f12179a, 0, new ViewGroup.LayoutParams(-1, -1));
            iVar.a().getLayout().addView(frameLayout, indexOfChild, this.f12179a.getLayoutParams());
            this.f12179a = frameLayout;
            if (view != null) {
                view.setTag("fixed-top");
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int indexOfChild2 = viewGroup.indexOfChild(view);
                viewGroup.removeView(view);
                layoutParams.height = b.a(view);
                viewGroup.addView(new Space(this.f12179a.getContext()), indexOfChild2, layoutParams);
                frameLayout.addView(view, 1, layoutParams);
            }
            if (view2 != null) {
                view2.setTag("fixed-bottom");
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
                int indexOfChild3 = viewGroup2.indexOfChild(view2);
                viewGroup2.removeView(view2);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
                layoutParams2.height = b.a(view2);
                viewGroup2.addView(new Space(this.f12179a.getContext()), indexOfChild3, layoutParams2);
                layoutParams3.gravity = 80;
                frameLayout.addView(view2, 1, layoutParams3);
            }
        }
    }

    public void a(k kVar) {
        if (kVar instanceof b) {
            this.f12187i = (b) kVar;
        } else {
            this.f12187i.f21579b = kVar;
        }
    }

    public void a(boolean z2) {
        this.f12187i.f21580c = z2;
    }

    public void a(boolean z2, boolean z3) {
        this.f12185g = z2;
        this.f12186h = z3;
    }

    public View b() {
        return this.f12181c;
    }

    public boolean c() {
        return this.f12185g && this.f12187i.a(this.f12179a);
    }

    public boolean d() {
        return this.f12186h && this.f12187i.b(this.f12179a);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = ((float) (intValue - this.f12184f)) * this.f12181c.getScaleY();
            View view = this.f12181c;
            if (view instanceof AbsListView) {
                b.a((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f12184f = intValue;
    }
}
